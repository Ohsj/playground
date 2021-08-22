package com.osj4532.playground.service;

import com.osj4532.playground.dto.GetVideoRes;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRange;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StreamService {

    List<String> path = new ArrayList<>();

    public List<String> getFileLists(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    getFileLists(file.getPath());
                } else {
                    path.add(file.toString());
                }
            }
        }
        return path;
    }

    public GetVideoRes getVideoStream(HttpHeaders headers, String name) throws IOException {
        name = name.replace("|", "//");

        UrlResource video = new UrlResource("file:D://video//" + name);
        ResourceRegion resourceRegion;
        final long chunkSize = 1000000L;
        long contentLength = video.contentLength();

        Optional<HttpRange> optional = headers.getRange().stream().findFirst();
        HttpRange httpRange;

        if (optional.isPresent()) {
            httpRange = optional.get();
            long start = httpRange.getRangeStart(contentLength);
            long end = httpRange.getRangeEnd(contentLength);
            long rangeLength = Long.min(chunkSize, end - start + 1);
            resourceRegion = new ResourceRegion(video, start, rangeLength);
        } else {
            long rangeLength = Long.min(chunkSize, contentLength);
            resourceRegion = new ResourceRegion(video, 0, rangeLength);
        }

        return GetVideoRes.builder()
                .resourceRegion(resourceRegion)
                .urlResource(video)
                .build();

    }
}
