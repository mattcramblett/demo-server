package com.demo.demoserver.web.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
public class TestRequest {

    private String name;
    private boolean active;
    private Instant time;
}
