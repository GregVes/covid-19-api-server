
package com.covid.reports;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportsService {

    @Autowired
    private ReportRepository repository;
    //private Optional<ReportEntity> report;

    public ReportEntity createReport(ReportEntity report) {
        return (ReportEntity) repository.save(report);
    }
}