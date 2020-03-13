package com.covid.reports;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
//import java.time.LocalDate;

@RestController
@RequestMapping("/")
public class ReportController {
    @Autowired
    private ReportService service;

    @PostMapping("/reports")
    public @ResponseBody ReportDto createReport(@RequestBody ReportDto report) {
        return service.createReport(report);
    }
    @GetMapping("/reports")
    public @ResponseBody List<ReportDto> getReportsByFilters(
        @RequestParam(name="country", required=true) String country,
        @RequestParam(name="date", required=false) String date,
        @RequestParam(name="start", required=false) String start,
        @RequestParam(name="end", required=false) String end
    ) {
        boolean requestsOnlyCountry = date == null && start == null && end == null;
        boolean requestsCountryAndDate = date != null;
        boolean requestsCountryFromDate = start != null && end == null;
        if (requestsOnlyCountry) {
            return service.getReportsByCountry(country);
        }
        else if (requestsCountryAndDate) {
            return service.getReportByCountryAndDate(country, date);
        }
        else if(requestsCountryFromDate) {
            return service.getReportsByCountryFromDate(country, start);
        }
        else {
            // country + start
            return service.getReportsByCountryAndRange(country, start, end);
        }
    }
}