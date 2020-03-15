
package com.covid.reports;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
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
    public List<ReportDto> getReportByCountryAndDate(String country, String date) {
        List<ReportDto> reportsDtos = new ArrayList<ReportDto>();
        List<ReportEntity> reportsEntities = (List<ReportEntity>)repository.findByCountryAndDate(country, LocalDate.parse(date));
        reportsDtos = reportsEntities
            .stream()
            .map(reportEntity -> mapper.toDto(reportEntity))
            .collect(Collectors.toList());
        return reportsDtos;
    }
    public List<ReportDto> getReportsByCountryAndRange(String country, String start, String end) {
        List<ReportDto> reportsDtos = new ArrayList<ReportDto>();
        List<ReportEntity> reportsEntities = (List<ReportEntity>)repository.findByCountryAndRange(country, LocalDate.parse(start), LocalDate.parse(end));
        reportsDtos = reportsEntities
            .stream()
            .map(reportEntity -> mapper.toDto(reportEntity))
            .collect(Collectors.toList());
        return reportsDtos;
    }
    public List<ReportDto> getReportsByCountryFromDate(String country, String start) {
        List<ReportDto> reportsDtos = new ArrayList<ReportDto>();
        List<ReportEntity> reportsEntities = (List<ReportEntity>)repository.findByCountryAndFromDate(country, LocalDate.parse(start));
        reportsDtos = reportsEntities
            .stream()
            .map(reportEntity -> mapper.toDto(reportEntity))
            .collect(Collectors.toList());
        return reportsDtos;
    }
    public List<String> getReportsCountries() {
        return (List<String>)repository.findCities();
    }
}