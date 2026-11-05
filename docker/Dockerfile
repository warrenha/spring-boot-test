FROM debian:trixie-slim

RUN apt-get update \
    && apt-get install --yes --no-install-recommends \
        ca-certificates \
        openjdk-25-jre-headless \
    && rm -rf /var/lib/apt/lists/* \
    && groupadd --system spring \
    && useradd --system --gid spring --no-create-home spring

WORKDIR /app

COPY --chown=spring:spring \
    target/spring-boot-test-0.0.1-SNAPSHOT.jar \
    app.jar

USER spring:spring

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
