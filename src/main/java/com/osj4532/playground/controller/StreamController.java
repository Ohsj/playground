package com.osj4532.playground.controller;

import com.osj4532.playground.dto.GetVideoRes;
import com.osj4532.playground.service.StreamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/stream")
@Tag(name = "StreamController", description = "Video Streaming Basic")
public class StreamController {

    private final StreamService streamService;

    public StreamController(StreamService streamService) {
        this.streamService = streamService;
    }

    @GetMapping(value = "/file/lists")
    @Operation(summary = "Show file list", description = "파일 목록을 보여주는 기능")
    public List<String> getFileLists(String dirPath) {
        return streamService.getFileLists(dirPath);
    }

    @GetMapping(value = "/video/{name}")
    @Operation(summary = "Show Video", description = "대형 미디어 파일을 나누어서 읽을 수 있게 해주는 기능")
    public ResponseEntity<ResourceRegion> getVideo(@RequestHeader HttpHeaders headers,
                                                   @PathVariable String name) throws IOException {
        GetVideoRes res = streamService.getVideoStream(headers, name);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory.getMediaType(res.getUrlResource()).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(res.getResourceRegion());
    }
}
