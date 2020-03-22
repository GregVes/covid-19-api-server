package com.covid.reports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Integer> {


    @Query(value=
    "INSERT INTO reports(country, report_date, cases, dead, recovered) "
    + 
    "VALUES(?1,?2,?3,?4,?5)"
    +
    "ON CONFLICT (country,report_date) DO UPDATE SET "
    +
    "cases = reports.cases + ?3, dead = reports.dead + ?4, recovered = reports.recovered + ?5 returning *"
     
     , nativeQuery=true)
    ReportEntity postReport(String country, LocalDate date, int cases, int dead, int recovered);

    @Query(value="SELECT * FROM reports WHERE country = ?1", nativeQuery=true)
    List<ReportEntity> findByCountry(String country);

    @Query(value="SELECT * FROM reports WHERE country = ?1 AND report_date = ?2", nativeQuery=true)
    List<ReportEntity> findByCountryAndDate(String country, LocalDate date);

    @Query(value="SELECT * FROM reports WHERE country = ?1 AND report_date BETWEEN ?2 AND ?3", nativeQuery=true)
    List<ReportEntity> findByCountryAndRange(String country, LocalDate start, LocalDate end);

    @Query(value="SELECT * FROM reports WHERE country = ?1 AND report_date >= ?2", nativeQuery=true)
    List<ReportEntity> findByCountryAndFromDate(String country, LocalDate start);

    @Query(value="SELECT DISTINCT country FROM reports", nativeQuery=true)
    List<String> findCities();

    @Query(value="SELECT * FROM reports WHERE country = ?1 AND report_date = CURRENT_DATE-1", nativeQuery=true)
    ReportEntity findLatestReport(String country);
}