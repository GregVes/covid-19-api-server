package com.covid.reports;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ReportController {
    @Autowired
    private ReportService service;

    @PostMapping("/reports")
    public @ResponseBody ReportEntity create(@RequestBody ReportEntity report) {
        return service.createReport(report);
    }
}