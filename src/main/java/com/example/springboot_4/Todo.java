package com.example.springboot_4;

// A simple record to hold the data
public record Todo(Integer id, Integer userId, String title, Boolean completed) {}
