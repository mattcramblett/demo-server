package com.demo.demoserver.web.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserResponse {

    private final Long id;
    private final String name;
}
