# About

REST $domain;format="lower"$ micro service capable of CRUD and query operations.

# What's under the hood?

- [Spray](http://spray.io/) 

# Quick start usage

Execute this:

    cd otrl-service-$domain;format="lower"$/
    env JAVA_OPTS="-Dkamon.auto-start=true" sbt "project $domain;format="lower"$Service" aspectj-runner:run

Invoke CRUD and query operations on the service at `http://localhost:9001/$domain;format="lower"$` 

# Configuration

    TODO setup and document

# Metrics

    TODO setup and document

