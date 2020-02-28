#!/bin/sh
#clean previous version of executable spring boot jar, run all tests
cd ..
gradle clean test bootJar
docker build . -t chsi
docker run \
  -e SPRING_DATASOURCE_USERNAME=`echo $SPRING_DATASOURCE_USERNAME` \
  -e SPRING_DATASOURCE_PASSWORD=`echo $SPRING_DATASOURCE_PASSWORD` \
  -e SPRING_DATASOURCE_URL=`echo $SPRING_DATASOURCE_URL` \
  -e AWS_S3_BUCKET=`echo $AWS_S3_BUCKET` \
  -e AWS_ACCESS_KEY_ID=`echo $AWS_ACCESS_KEY_ID` \
  -e AWS_SECRET_ACCESS_KEY=`echo $AWS_SECRET_ACCESS_KEY`\
  -p 8080:8080  chsi:latest