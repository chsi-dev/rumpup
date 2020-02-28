# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/gradle-plugin/reference/html/)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
in order to run application in docker please use  you need to set up your local environment variables:
SPRING_DATASOURCE_URL - this variable represents url to your local or remote data source,
please note that this value can contain db name, port, db vendor etc.,
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD

AWS_S3_BUCKET 3s bucket which will be involved in integration test as well
AWS_ACCESS_KEY_ID
AWS_SECRET_ACCESS_KEY

in order to do this you need to have AWS access, please check for hot to
https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html
by default region set to european, it will be extracted to variable ass well

to build an applicaion you need gradle build tool:
https://gradle.org/install/

to run in docker container please install and run docker
https://www.docker.com/products/docker-desktop

to run application in from executable jar:
gradle bootRun

to run in docker container run the script
/scripts/runInDocker.sh

