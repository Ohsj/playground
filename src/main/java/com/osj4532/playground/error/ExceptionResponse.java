package com.osj4532.playground.error;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionResponse {
    private String timestamp;
    private String status;
    private String statusName;
    private String path;
    private String errMsg;
    private String errClassName;
}
