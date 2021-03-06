package com.covid.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;
//import java.time.LocalDate;

@Api(value = "ReportController" , tags = {"Report Controller"})
@SwaggerDefinition(tags = {
    @Tag(name = "Report Controller",
    description = "Controller operating on Reports resources"
    )
})
@CrossOrigin
@RestController
@RequestMapping("/")
public class ReportController {
    @Autowired
    private ReportService service;

    @ApiIgnore
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
    @GetMapping("/reports/countries")
    public @ResponseBody List<String> getReportsCountries() {
        return service.getCountryReports();
    }
    @GetMapping("/reports/{country}/latest")
    public @ResponseBody ReportDto getCountryLatestReport(@PathVariable String country) {
        return service.getLatestReport(country);
    }
}