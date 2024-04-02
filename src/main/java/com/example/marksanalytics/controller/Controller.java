package com.example.marksanalytics.controller;

import com.example.marksanalytics.model.Marks;
import com.example.marksanalytics.service.AnalyticsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final AnalyticsService service;

    public Controller(AnalyticsService service) {
        this.service = service;
    }

    @PostMapping("/")
    public String info(@RequestBody List<Marks> marks) {
        return service.analytics(marks);
    }
}
