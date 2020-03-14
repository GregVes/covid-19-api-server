#!/usr/bin/bash

docker build -t covid-api .
docker run -p 8080:8080 -t covid-api