import sbt._

name := "otrl-service-rest-$domain;format="lower"$"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val commonSettings = Seq(
  organization := "io.otrl.service",
  version := "0.5.0-SNAPSHOT",
  scalaVersion := "2.11.7",
  libraryDependencies ++= Seq(
    // scala
    "org.scala-lang" % "scala-library" % "2.11.7",
    // otrl
    "io.otrl.library" % "otrl-lib-domain_2.11" % "0.5.0-SNAPSHOT",
    // test
    "io.spray" % "spray-testkit_2.11" % "1.3.3" % "test",
    "org.specs2" % "specs2-core_2.11" % "3.6.6" % "test",
    "org.specs2" % "specs2-junit_2.11" % "3.6.6" % "test",
    "org.specs2" % "specs2-mock_2.11" % "3.6.6" % "test"
  )
)

lazy val $domain;format="lower"$Parent = project.in(file("."))
  .aggregate($domain;format="lower"$Domain, $domain;format="lower"$Service, $domain;format="lower"$Client)

lazy val $domain;format="lower"$Domain = project
  .in(file("./$domain;format="lower"$-domain"))
  .settings(name := "$domain;format="lower"$-domain")
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Seq(
    "io.spray" % "spray-json_2.11" % "1.3.2",
    "io.spray" % "spray-httpx_2.11" % "1.3.3",
    "com.typesafe.akka" % "akka-actor_2.11" % "2.4.1"
  ))

lazy val $domain;format="lower"$Service = project
  .in(file("./$domain;format="lower"$-service"))
  .settings(name := "$domain;format="lower"$-service")
  .dependsOn($domain;format="lower"$Domain)
  .settings(commonSettings: _*)
  .settings(mainClass in Compile := Some("io.otrl.service.$domain;format="lower"$.$domain$RestService"))
  .settings(libraryDependencies ++= Seq(
    // otrl
    "io.otrl.library" % "otrl-lib-repository-h2_2.11" % "0.5.0-SNAPSHOT",
    "io.otrl.library" % "otrl-lib-repository-mongo_2.11" % "0.1.0-SNAPSHOT",
    "io.otrl.library" % "otrl-lib-rest-spray_2.11" % "0.6.0-SNAPSHOT",
    // kamon
    "io.kamon" % "kamon-core_2.11" % "0.5.2",
    "io.kamon" % "kamon-log-reporter_2.11" % "0.5.2", // TODO remove or turn off for production
    "io.kamon" % "kamon-system-metrics_2.11" % "0.5.2",
    // aspectj
    "org.aspectj" % "aspectjweaver" % "1.8.6"
  ))

lazy val $domain;format="lower"$Client = project
  .in(file("./$domain;format="lower"$-client"))
  .settings(name := "$domain;format="lower"$-client")
  .dependsOn($domain;format="lower"$Domain)
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Seq(
    "io.otrl.library" % "otrl-lib-client_2.11" % "0.1.0-SNAPSHOT"
  ))
