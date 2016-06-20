# About

This template generates a REST service project based on (among other things) [Sbt](http://www.scala-sbt.org/) and [Spray](http://spray.io/). The service is capable of CRUD and query operations over a particular domain object.

The anatomy of a project generated by this template is depicted in the following diagram:

[![Build Status](https://travis-ci.org/edinhodzic/kyriakos-rest-micro-service-spray.svg?branch=master)](https://travis-ci.org/edinhodzic/kyriakos-rest-micro-service-spray)

![Anatomy of a REST service project](https://cloud.githubusercontent.com/assets/4981314/12087852/3ae9fc4e-b2ce-11e5-8f13-df359424a6ae.jpg)

So for a hypothetical user service, the Sbt project structure which the template generates is:

    my-service-user/build.sbt
    my-service-user/user-domain
    my-service-user/user-service
    my-service-user/user-client

The packages and code it generates within those modules is also appropriately named according to the inputs given to the [giter8](https://github.com/n8han/giter8) template (see usage section).

The generated code is also minimal as it is based on abstractions found in the following libraries:

- [`kyriakos-lib-rest-spray`](https://github.com/edinhodzic/kyriakos-lib-rest-spray)
- [`kyriakos-lib-repository-h2`](https://github.com/edinhodzic/kyriakos-lib-repository-h2) / [`kyriakos-lib-repository-mongo`](https://github.com/edinhodzic/kyriakos-lib-repository-mongo)

# What's under the hood?

- [giter8](https://github.com/n8han/giter8) 

# Prerequisites

As a prerequisite you should have a giter8 installed as per the [installation instructions](https://github.com/n8han/giter8#installation).

# Quick start usage

This shouldn't even take a couple of minutes. Suppose we were implementing a user REST service.

## Step 1 - create a REST web service project

Apply this template with the `org` and `domain` template parameters set to `acme` and `User` respectively:

    $ g8 https://github.com/edinhodzic/kyriakos-rest-micro-service-spray --org=acme --domain=User

That creates a project in a `./acme-service-user` directory. This directory contains the Sbt multi-module project as per the aforementioned project structure.

## Step 2 - start the service

From the project root we can invoke an Sbt command to start the service which lives in the `user-service` module:

    cd acme-service-user/
    sbt "project userService" aspectj-runner:run

The above starts up the `io.acme.service.user.UserRestService` Scala application which mixes in Spray's `SimpleRoutingApp` making the service available at `http://localhost:9001/user`.

## Step 3 - do stuff with the service

Below are the REST conventions and CRUD and query operations which you can now perform on this newly built service.

| Method | Description    | Collection URI HTTP responses      | Item URI HTTP responses            |
|--------|----------------|------------------------------------|------------------------------------|
| POST   | Create         | `201 Created` / `409 Conflict`?    | unsupported                        |
| GET    | Read           | `200 Ok`                           | `200 Ok` / `404 Not Found`         |
| PUT    | Whole update   | unsupported                        | `204 No Content` / `404 Not Found` |
| PATCH  | Partial update | unsupported                        | `204 No Content` / `404 Not Found` |
| DELETE | Delete         | unsupported                        | `204 No Content` / `404 Not Found` |


# Configuration

    TODO setup and document

# Metrics

    TODO setup and document

# What's next?

- [ ] get back go `sbt "project userService" run` for running the service
- [ ] resolve any `TODO`s above
- [x] add a README.md to the generated project
