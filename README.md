# COVID-19 API Server

This is a Java/Spring Boot server that manages daily reports of COVID-19 cases received from the [COVID-19 Data Extractor*](https://github.com/GregVes/covid-19-data-extractor)

*original data source is the Johns Hopkins University Center for Systems Science and Engineering's [data repository](https://github.com/CSSEGISandData/COVID-19).

API documentation can be found [here](https://covid-api-server.herokuapp.com/swagger-ui.html#/).

By country
```
https://covid-api-server.herokuapp.com/reports?country=Spain
```
By country and  a specific date
```
https://covid-api-server.herokuapp.com/reports?country=Germany&date=2020-03-05
```
By country and from a specific date
```
https://covid-api-server.herokuapp.com/reports?country=Mainland%20&start=2020-02-25
```
By country and from a range of dates
```
https://covid-api-server.herokuapp.com/reports?country=Italy&start=2020-03-10&end=2020-03-13
```
