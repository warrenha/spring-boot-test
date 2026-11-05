# Spring Boot Test

A minimal Spring Boot application with a JSON greeting endpoint.

## Prerequisites

- Java 25
- Homebrew (for the one-time Maven installation)

Verify Java is available:

```bash
java --version
```

## One-time Maven wrapper setup

This project was created from an empty directory, so generate the Maven Wrapper once:

```bash
brew install maven
mvn wrapper:wrapper -Dmaven=3.9.12
```

After this, use `./mvnw` for project commands. A separate Maven installation is not required to build or run the project with the wrapper.

## Run the tests

```bash
./mvnw test
```

Or use the provided script:

```bash
./scripts/runTests.sh
```

## Start the server

```bash
./mvnw spring-boot:run
```

Or use the provided script:

```bash
./scripts/startServer.sh
```

The server listens on `http://localhost:8080`. Stop it with `Ctrl-C`.

## Call the endpoint

Supply a name:

```bash
curl 'http://localhost:8080/greeting/hello?name=Warren'
```

Expected response:

```json
{"message":"Hello Warren"}
```

Omit the name to use the default:

```bash
curl 'http://localhost:8080/greeting/hello'
```

Expected response:

```json
{"message":"Hello World"}
```

Say goodbye:

```bash
curl 'http://localhost:8080/greeting/bye?name=Warren'
```

Expected response:

```json
{"message":"Bye Warren"}
```

## Build an executable JAR

```bash
./mvnw clean package
```

Or use the provided script:

```bash
./scripts/buildJar.sh
```

Run it with:

```bash
java -jar target/spring-boot-test-0.0.1-SNAPSHOT.jar
```

Or use the provided script:

```bash
./scripts/runJar.sh
```

Application arguments are forwarded to Spring Boot:

```bash
./scripts/runJar.sh --server.port=8081
```

## Build and run with Docker

First, test and package the application JAR:

```bash
./scripts/buildJar.sh
```

Then build the image with the default name and tag, `spring-boot-test:latest`:

```bash
./scripts/buildDockerImage.sh
```

The Docker build script checks that the JAR exists but does not build it. It uses
`docker/Dockerfile` to copy the JAR into a Debian Trixie Slim image containing the OpenJDK 25 JRE.

Optionally supply a different tag:

```bash
./scripts/buildDockerImage.sh 1.0.0
```

Override the image name with `IMAGE_NAME`:

```bash
IMAGE_NAME=karasu/spring-boot-test ./scripts/buildDockerImage.sh 1.0.0
```

Run the container:

```bash
docker run --rm --publish 8080:8080 spring-boot-test:latest
```

Run `buildJar.sh` again whenever the application changes before rebuilding the image.
