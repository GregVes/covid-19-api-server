
package com.covid.reports;

import java.util.*;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository repository;
    //private Optional<ReportEntity> report;

    public ReportEntity createReport(ReportEntity report) {
        return (ReportEntity) repository.save(report);
    }
    public List<ReportEntity> getReportsByCountry(String country) {
        return (List<ReportEntity>) repository.findByCountry(country);
    }
}