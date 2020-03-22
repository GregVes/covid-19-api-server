/*package com.covid.reports;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

@SpringBootTest
public class ReportMapperTest {

    private String country = "bar";
    private String reportDate = "2020-01-01";
    private int cases = 10;
    private int dead = 10;
    private int recovered = 10;
    private ReportMapper reportMapper = new ReportMapper();

    @Test
    public void convertToDto() {
        // given
        ReportEntity reportEntity = new ReportEntity(country, LocalDate.of(2020,01,01), cases, dead, recovered);
        ReportDto expectedReportDto = new ReportDto(country, reportDate, cases, dead, recovered);
        // when
        ReportDto actualReportDto = reportMapper.toDto(reportEntity);
        // then 
        assertThat(expectedReportDto.getCountry()).isEqualTo(actualReportDto.getCountry());
        assertThat(expectedReportDto.getReportDate()).isEqualTo(actualReportDto.getReportDate());
        assertThat(expectedReportDto.getCases()).isEqualTo(actualReportDto.getCases());
        assertThat(expectedReportDto.getDead()).isEqualTo(actualReportDto.getDead());
        assertThat(expectedReportDto.getRecovered()).isEqualTo(actualReportDto.getRecovered());
    }
    @Test
    public void converToEntity() {
        // given
        ReportDto reportDto = new ReportDto(country, reportDate, cases, dead, recovered);
        ReportEntity expectedReportEntity = new ReportEntity(country, LocalDate.of(2020,01,01), cases, dead, recovered);
        // when 
        ReportEntity actualReportEntity = reportMapper.toEntity(reportDto);
        // then
        assertThat(expectedReportEntity.getCountry()).isEqualTo(actualReportEntity.getCountry());
        assertThat(expectedReportEntity.getReportDate()).isEqualTo(actualReportEntity.getReportDate());
        assertThat(expectedReportEntity.getCases()).isEqualTo(actualReportEntity.getCases());
        assertThat(expectedReportEntity.getDead()).isEqualTo(actualReportEntity.getDead());
        assertThat(expectedReportEntity.getRecovered()).isEqualTo(actualReportEntity.getRecovered());
    }
}*/