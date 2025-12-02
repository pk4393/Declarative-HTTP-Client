package com.example.springboot_4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    // Inject just like any other bean
    private final TodoClient todoClient;

    @GetMapping("/test/{id}")
    public Todo testClient(@PathVariable Integer id) {
        // Looks like a local method call, but makes an HTTP request!
        return this.todoClient.getTodo(id);
    }
}
