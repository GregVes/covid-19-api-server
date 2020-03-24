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
import java.util.Arrays;

@SpringBootTest
public class ReportServiceTest {

    @Mock
    private ReportRepository repository;

    @Mock
    private ReportMapper mapper;

    @InjectMocks
    private ReportService service;

    private String country = "France";
    private int cases = 100;
    private int dead = 100;
    private int year = 2020;
    private int month = 1;
    private int day = 1;

    @Test
    public void postReport() {
        // given
        ReportDto expectedDto = new ReportDto(country, "2020-01-02", cases, dead);
        ReportEntity expectedEntity = new ReportEntity(country, LocalDate.of(year, month, day), cases, dead);
        doReturn(expectedEntity).when(repository).postReport(country, LocalDate.of(year, month, day), cases, dead);
        doReturn(expectedEntity).when(mapper).toEntity(expectedDto);
        doReturn(expectedDto).when(mapper).toDto(expectedEntity);
        // when 
        ReportDto actualReport = service.createReport(expectedDto);
        // then
        assertThat(actualReport.getCountry()).isEqualTo(expectedDto.getCountry());
    }
    @Test
    public void getReportsListByCountry() {
        // given
        int year = 2020;
        int month = 01;
        int day = 01;
        ReportDto report = new ReportDto(country, "2020-01-01", cases,dead);
        List<ReportDto> expectedReports = new ArrayList<ReportDto>();
        expectedReports.add(report);
        String country = this.country;

        ReportEntity reportEntityMock = new ReportEntity(country, LocalDate.of(year, month, day), cases, dead);
        List<ReportEntity> entitiesMocks = new ArrayList<ReportEntity>();
        entitiesMocks.add(reportEntityMock);
        doReturn(entitiesMocks).when(repository).findByCountry(country);
        doReturn(report).when(mapper).toDto(reportEntityMock);
        // when
        List<ReportDto> actualReports = service.getReportsByCountry(country);
        // then 
        assertThat(Integer.valueOf(expectedReports.size())).isEqualTo(Integer.valueOf(actualReports.size()));
        assertThat(expectedReports.get(0).getCountry()).isEqualTo(actualReports.get(0).getCountry());
        assertThat(expectedReports.get(0).getReportDate()).isEqualTo(actualReports.get(0).getReportDate());
        assertThat(expectedReports.get(0).getCases()).isEqualTo(actualReports.get(0).getCases());
        assertThat(expectedReports.get(0).getDead()).isEqualTo(actualReports.get(0).getDead());
    }
    @Test
    public void getCountriesList() {
        // given 
        List<String> expectedCities = Arrays.asList("France", "Germany", "Italy", "Spain");
        doReturn(expectedCities).when(repository).findCountries();
        // when 
        List<String> actualCities = service.getCountryReports();
        // then 
        assertThat(expectedCities).isEqualTo(actualCities);
    }
}