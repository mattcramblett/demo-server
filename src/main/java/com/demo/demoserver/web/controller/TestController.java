package com.demo.demoserver.web.controller;

import com.demo.demoserver.web.request.TestRequest;
import com.demo.demoserver.web.response.TestResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {

    @PostMapping("/hello-world")
    public ResponseEntity<TestResponse> helloWorld(@RequestBody final TestRequest request) {
        return ResponseEntity.ok(new TestResponse(
                request.getName(),
                request.getTime()
        ));
    }
}
