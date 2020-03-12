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

    @Mock
    private ReportMapper mapper;

    @InjectMocks
    private ReportService service;

    private String province = "foobar";
    private String country = "France";
    private int cases = 100;
    private int dead = 100;
    private int recovered = 100;
    private int year = 2020;
    private int month = 1;
    private int day = 1;

    @Test
    public void postAReport() {
        // given
        ReportDto expectedDto = new ReportDto(province, country, "2020-01-02", cases, dead, recovered);
        ReportEntity expectedEntity = new ReportEntity(province, country, LocalDate.of(year, month, day), cases, dead, recovered);
        doReturn(expectedEntity).when(repository).save(expectedEntity);
        doReturn(expectedEntity).when(mapper).toEntity(expectedDto);
        doReturn(expectedDto).when(mapper).toDto(expectedEntity);
        // when 
        ReportDto actualReport = service.createReport(expectedDto);
        // then
        assertThat(actualReport.getProvince()).isEqualTo(expectedDto.getProvince());
    }
    @Test
    public void getReportsByCountry() {
        // given
        int year = 2020;
        int month = 01;
        int day = 01;
        ReportDto report = new ReportDto(province, country, "2020-01-01", cases,dead,recovered);
        List<ReportDto> expectedReports = new ArrayList<ReportDto>();
        expectedReports.add(report);
        String country = this.country;

        ReportEntity reportEntityMock = new ReportEntity(province, country, LocalDate.of(year, month, day), cases, dead, recovered);
        List<ReportEntity> entitiesMocks = new ArrayList<ReportEntity>();
        entitiesMocks.add(reportEntityMock);
        doReturn(entitiesMocks).when(repository).findByCountry(country);
        doReturn(report).when(mapper).toDto(reportEntityMock);
        // when
        List<ReportDto> actualReports = service.getReportsByCountry(country);
        // then 
        assertThat(Integer.valueOf(expectedReports.size())).isEqualTo(Integer.valueOf(actualReports.size()));
        assertThat(expectedReports.get(0).getProvince()).isEqualTo(actualReports.get(0).getProvince());
        assertThat(expectedReports.get(0).getCountry()).isEqualTo(actualReports.get(0).getCountry());
        assertThat(expectedReports.get(0).getReportDate()).isEqualTo(actualReports.get(0).getReportDate());
        assertThat(expectedReports.get(0).getCases()).isEqualTo(actualReports.get(0).getCases());
        assertThat(expectedReports.get(0).getDead()).isEqualTo(actualReports.get(0).getDead());
        assertThat(expectedReports.get(0).getRecovered()).isEqualTo(actualReports.get(0).getRecovered());
    }
}