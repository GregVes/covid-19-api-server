package com.covid.reports;

import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class ReportMapper {

    public ReportMapper() {}

    public ReportEntity toEntity(ReportDto dto) {
        return new ReportEntity(
            dto.getProvince(),
            dto.getCountry(),
            LocalDate.parse(dto.getReportDate()),
            dto.getCases(),
            dto.getDead(),
            dto.getRecovered()
            );
    }
    public ReportDto toDto(ReportEntity entity) {
        return new ReportDto(
            entity.getProvince(),
            entity.getCountry(),
            entity.getReportDate().toString(),
            entity.getCases(),
            entity.getDead(),
            entity.getRecovered()
        );
    }
}