package com.demo.demoserver.web.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
@Getter
public class TestResponse {
    private final long id;
    private final String name;
    private final boolean status;
    private final Instant time;
}
