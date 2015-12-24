# About

This template generates a REST service project based on (among other things) [Sbt](http://www.scala-sbt.org/) and [Spray](http://spray.io/). The service is capable of CRUD and query operations over a particular domain object.

The Sbt project structure which it generates for a hypothetical `otrl-service-user` service is:

    otrl-service-user/build.sbt
    otrl-service-user/user-domain
    otrl-service-user/user-service
    otrl-service-user/user-client

The packages and code it generates within those modules is also appropriately named according to the inputs given to the [giter8](https://github.com/n8han/giter8) template (see usage section).

The generated code is also minimal as it is based on abstractions found in the following libraries:

- [`otrl-lib-rest-spray`](https://github.com/otrl/otrl-lib-rest-spray)
- [`otrl-lib-repository-h2`](https://github.com/otrl/otrl-lib-repository-h2) / [`otrl-lib-repository-mongo`](https://github.com/otrl/otrl-lib-repository-mongo)

# What's under the hood?

- [giter8](https://github.com/n8han/giter8) 

# Prerequisites

As a prerequisite you should have a giter8 installed as per the [installation instructions](https://github.com/n8han/giter8#installation).

# Quick start usage

This shouldn't even take a couple of minutes. Suppose we were implementing a user REST service.

## Step 1 - create a REST web service project

Apply this template with the `domain` template parameter set to `User`:

    $ g8 https://github.com/otrl/otrl-rest-micro-service.g8 --domain=User

That creates a project in a `./otrl-service-user` directory. This directory contains the Sbt multi-module project as per the aforementioned project structure.

## Step 2 - start the service

From the project root we can invoke an Sbt command to start the service which lives in the `user-service` module:

    cd otrl-service-user/
    sbt "project userService" run

The above starts up the `io.otrl.service.user.UserRestService` Scala application which mixes in Spray's `SimpleRoutingApp` making the service available at `http://localhost:9001/user`.

## Step 3 - do stuff with the service

Please see the [OTRL REST service conventions](https://gist.github.com/otrl/rest-service-conventions) gist for details on the REST conventions and CRUD and query operations which you can now perform on this newly built service.

# Configuration

    TODO setup and document

# Metrics

    TODO setup and document

# What's next?

- [ ] resolve any `TODO`s above
- [ ] add a README.md to the generated project
