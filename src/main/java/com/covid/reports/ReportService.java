
package com.covid.reports;

import java.util.*;
import java.util.stream.Collectors;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository repository;
    @Autowired 
    private ReportMapper mapper;
    //private Optional<ReportEntity> report;

    public ReportDto createReport(ReportDto reportDto) {
        ReportEntity reportEntity = mapper.toEntity(reportDto);
        reportEntity = repository.save(reportEntity);
        reportDto = mapper.toDto(reportEntity);
        return reportDto;
    }
    public List<ReportDto> getReportsByCountry(String country) {
        List<ReportDto> reportsDtos = new ArrayList<ReportDto>();
        List<ReportEntity> reportsEntities = (List<ReportEntity>)repository.findByCountry(country);
        reportsDtos = reportsEntities
            .stream()
            .map(reportEntity -> mapper.toDto(reportEntity))
            .collect(Collectors.toList());
        return reportsDtos;
    }
}