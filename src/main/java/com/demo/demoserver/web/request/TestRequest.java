package com.demo.demoserver.web.request;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TestRequest {

    private String name;
    private boolean active;
    private Instant time;
}
