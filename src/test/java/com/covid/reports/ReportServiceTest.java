package com.covid.reports;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.assertj.core.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@SpringBootTest
public class ReportServiceTest {

    @Mock
    private ReportRepository repository;

    @InjectMocks
    private ReportService service;

    @Test
    public void postAReport() {
        // given
        int id = 1;
        String country = "France";
        LocalDate reportDate = LocalDate.now();
        int cases = 100;
        int dead = 100;
        int recovered = 100;
        ReportEntity input = new ReportEntity("", country, reportDate, cases, dead, recovered);
        ReportEntity expectedReport = new ReportEntity("", country, reportDate, cases, dead, recovered);
        expectedReport.setId(id);
        doReturn(expectedReport).when(repository).save(input);
        // when 
        ReportEntity actualReport = service.createReport(input);
        // then
        assertThat(actualReport).isEqualTo(expectedReport);
    }   
    @Test
    public void getAllReportsByCountry() {
        // given
        ReportEntity report1 = new ReportEntity("", "Italy", LocalDate.of(20202,01,10), 100,100,100);
        ReportEntity report2 = new ReportEntity("", "Italy", LocalDate.of(20202,01,11), 100,100,100);
        List<ReportEntity> expectedReports = new ArrayList<ReportEntity>();
        expectedReports.add(report1);
        expectedReports.add(report2);
        String country = "Italy";
        doReturn(expectedReports).when(repository).findByCountry(country);
        // when
        List<ReportEntity> actualReports = service.getReportsByCountry(country);
        // then 
        assertThat(Integer.valueOf(expectedReports.size())).isEqualTo(Integer.valueOf(actualReports.size()));
    }
}