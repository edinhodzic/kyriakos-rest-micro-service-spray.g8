giter8Settings

resolvers += Resolver.url("typesafe", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns)

G8Keys.g8TestBufferLog := false

lazy val otrlLibMicroServiceSprayTemplate = project.in(file("."))

scriptedLaunchOpts ++= sys.process.javaVmArguments.filter(
  a => Seq("-Xmx", "-Xms", "-XX", "-Dsbt.log.noformat").exists(a.startsWith)
)

publishTo := Some("OTRL" at "https://mvn.otrl.io")
