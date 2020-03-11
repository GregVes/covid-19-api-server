package com.covid.reports;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.assertj.core.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

@SpringBootTest
public class ReportServiceTest {

    @Mock
    private ReportRepository repository;

    @InjectMocks
    private ReportService service;

    @Test
    public void whenPost_returnReportWithId() {
        // given
        int id = 1;
        String country = "France";
        LocalDate date = LocalDate.now();
        int cases = 100;
        int dead = 100;
        int recovered = 100;
        ReportEntity input = new ReportEntity("", country, date, cases, dead, recovered);
        ReportEntity expectedReport = new ReportEntity("", country, date, cases, dead, recovered);
        expectedReport.setId(id);
        doReturn(expectedReport).when(repository).save(input);
        // when 
        ReportEntity actualReport = service.createReport(input);
        // then
        assertThat(actualReport).isEqualTo(expectedReport);
    }    
}