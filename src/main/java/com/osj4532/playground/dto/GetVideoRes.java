package com.osj4532.playground.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;

@Getter
@Setter
public class GetVideoRes {
    ResourceRegion resourceRegion;
    UrlResource urlResource;

    @Builder
    public GetVideoRes(ResourceRegion resourceRegion, UrlResource urlResource) {
        this.resourceRegion = resourceRegion;
        this.urlResource = urlResource;
    }
}
