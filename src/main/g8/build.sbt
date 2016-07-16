import sbt._

name := "$org$-service-crud-$domain;format="lower"$"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val commonSettings = Seq(
  organization := "io.$org$.service",
  version := "0.5.0-SNAPSHOT",
  scalaVersion := "2.11.7",
  resolvers += Resolver.url("edinhodzic", url("http://dl.bintray.com/edinhodzic/kyriakos"))(Resolver.ivyStylePatterns),
  scalacOptions ++= Seq("-deprecation", "-feature", "-language:postfixOps"),
  libraryDependencies ++= Seq(
    // scala
    "org.scala-lang" % "scala-library" % "2.11.7",
    // $org$
    "io.kyriakos.library" % "kyriakos-lib-domain_2.11" % "1.0.0",
    // test
    "io.spray" % "spray-testkit_2.11" % "1.3.3" % "test",
    "org.specs2" % "specs2-core_2.11" % "3.6.6" % "test",
    "org.specs2" % "specs2-junit_2.11" % "3.6.6" % "test",
    "org.specs2" % "specs2-mock_2.11" % "3.6.6" % "test"
  )
)

lazy val $domain;format="lower"$CrudParent = project.in(file("."))
  .aggregate($domain;format="lower"$CrudDomain, $domain;format="lower"$CrudService, $domain;format="lower"$CrudClient)

lazy val $domain;format="lower"$CrudDomain = project
  .in(file("./$domain;format="lower"$-domain"))
  .settings(name := "$domain;format="lower"$-domain")
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Seq(
    "io.spray" % "spray-json_2.11" % "1.3.2",
    "io.spray" % "spray-httpx_2.11" % "1.3.3",
    "com.typesafe.akka" % "akka-actor_2.11" % "2.4.1"
  ))

lazy val $domain;format="lower"$CrudService = project
  .in(file("./$domain;format="lower"$-service"))
  .settings(name := "$domain;format="lower"$-service")
  .dependsOn($domain;format="lower"$CrudDomain)
  .settings(commonSettings: _*)
  .settings(mainClass in Compile := Some("io.$org$.service.$domain;format="lower"$.$domain$CrudService"))
  .settings(libraryDependencies ++= Seq(
    // $org$
    "io.kyriakos.library" % "kyriakos-lib-repository-h2_2.11" % "1.0.0",
    "io.kyriakos.library" % "kyriakos-lib-repository-mongo_2.11" % "1.0.0",
    "io.kyriakos.library" % "kyriakos-lib-rest-spray_2.11" % "1.0.0",
    // kamon
    "io.kamon" % "kamon-core_2.11" % "0.5.2",
    "io.kamon" % "kamon-log-reporter_2.11" % "0.5.2", // TODO remove or turn off for production
    "io.kamon" % "kamon-system-metrics_2.11" % "0.5.2",
    // aspectj
    "org.aspectj" % "aspectjweaver" % "1.8.6"
  ))

lazy val $domain;format="lower"$CrudClient = project
  .in(file("./$domain;format="lower"$-client"))
  .settings(name := "$domain;format="lower"$-client")
  .dependsOn($domain;format="lower"$CrudDomain)
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Seq(
    "io.kyriakos.library" % "kyriakos-lib-client_2.11" % "1.0.0"
  ))
