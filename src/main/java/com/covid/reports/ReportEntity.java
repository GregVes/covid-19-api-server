package com.covid.reports;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reports")
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String province;
    @NotNull
    private String country;
    @NotNull
    @Column(unique = true)
    private LocalDate date;
    @NotNull
    private int cases;
    @NotNull
    private int dead;
    @NotNull
    private int recovered;

    public ReportEntity() {}

    public ReportEntity(String province, String country, LocalDate date, int cases, int dead, int recovered) {
        this.province = province;
        this.country = country;
        this.date = date;
        this.cases = cases;
        this.dead = dead;
        this.recovered = recovered;
    }

    public String getProvince() {
        return this.province;
    }
    public String getCountry() {
        return this.country;
    }
    public LocalDate getDate() {
        return this.date;
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
    public void setProvince(String province) {
        this.province = province;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setDate(LocalDate date) {
        this.date = date;
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