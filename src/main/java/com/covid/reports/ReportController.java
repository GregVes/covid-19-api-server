package com.covid.reports;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import java.util.*;
//import java.time.LocalDate;

@RestController
@RequestMapping("/")
public class ReportController {
    @Autowired
    private ReportService service;

    @PostMapping("/reports")
    public @ResponseBody ReportDto create(@RequestBody ReportDto report) {
        return service.createReport(report);
    }
    /*@GetMapping("/reports")
    public @ResponseBody int getBy(
        @RequestParam(name="country", required=true) String country,
        @RequestParam(name="date", required=false) String date,
        @RequestParam(name="start", required=false) String start,
        @RequestParam(name="end", required=false) String end
    ) {
        System.out.println(country + date + start + end);
        return 1;
    }*/
}