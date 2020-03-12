package com.covid.reports;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(
    name = "reports",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"reportDate", "country"})
    }
)
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String province;
    @NotNull
    private String country;
    @NotNull
    private LocalDate reportDate;
    private int cases;
    private int dead;
    private int recovered;

    public ReportEntity() {}

    public ReportEntity(String province, String country, LocalDate reportDate, int cases, int dead, int recovered) {
        this.province = province;
        this.country = country;
        this.reportDate = reportDate;
        this.cases = cases;
        this.dead = dead;
        this.recovered = recovered;
    }
    /*public ReportEntity(String province, String country, LocalDate reportDate, int cases, int dead, int recovered) {
        this.province = province;
        this.country = country;
        this.reportDate = reportDate;
        this.cases = cases;
        this.dead = dead;
        this.recovered = recovered;
    }*/

    public Integer getId() {
        return this.id;
    }
    public String getProvince() {
        return this.province;
    }
    public String getCountry() {
        return this.country;
    }
    public LocalDate getReportDate() {
        return this.reportDate;
    }
    public int getCases() {
        return this.cases;
    }
    public int getDead() {
        return this.dead;
    }
    public int getRecovered() {
        return this.recovered;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }
    public void setCases(int cases) {
        this.cases = cases;
    }
    public void setDead(int dead) {
        this.dead = dead;
    }
    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }
}