package com.covid.reports;

public class ReportDto {
    private String country;
    private String reportDate;
    private int cases;
    private int dead;
    private int recovered;

    public ReportDto() {}

    public ReportDto(
        String country,
        String reportDate,
        int cases,
        int dead,
        int recovered 
    ) {
        this.country = country;
        this.reportDate = reportDate;
        this.cases = cases;
        this.dead = dead;
        this.recovered = recovered;
    }

    public String getCountry() { return this.country; }
    public String getReportDate() { return this.reportDate; }
    public int getCases() { return this.cases; }
    public int getDead() { return this.dead; }
    public int getRecovered() { return this.recovered; }

    public void setCountry(String country) { this.country = country; }
    public void setReportDate(String date) { this.reportDate = date; }
    public void setCases(int cases) { this.cases = cases; }
    public void setDead(int dead) { this.dead = dead; }
    public void setRecovered(int recovered) { this.recovered = recovered; }
}