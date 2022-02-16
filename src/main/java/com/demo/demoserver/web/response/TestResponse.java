package com.demo.demoserver.web.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
@Getter
public class TestResponse {
    private final String name;
    private final Instant time;
}
