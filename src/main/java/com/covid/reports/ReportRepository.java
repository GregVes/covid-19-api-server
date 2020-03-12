package com.covid.reports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
//import java.time.LocalDate;
//import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Integer> {

    @Query(value="SELECT * FROM reports WHERE country = ?1", nativeQuery=true)
    List<ReportEntity> findByCountry(String country);
}