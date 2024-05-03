package com.sse.model;

import lombok.Builder;

@Builder
public class ApplicationLog {

    private String level;
    private String message;


}
