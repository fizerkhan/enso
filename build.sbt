lazy val syntax = (project in file("enso-lexer"))
  .withId("enso-lexer")
  .configs(Benchmark)
  .settings(
    inConfig(Benchmark)(Defaults.testSettings),
    name := "enso-lexer",
    organization := "org.enso",
    scalaVersion := "2.12.8",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xlint"),
    publishArtifact := false,
    libraryDependencies ++= Seq(
      "com.storm-enroute" %% "scalameter" % "0.17" % "bench"
    ),
    libraryDependencies += "org.typelevel" %% "cats-core" % "1.6.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
    libraryDependencies += "com.lihaoyi"   %% "pprint"    % "0.5.3",

    resolvers ++= Seq(
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
      "Sonatype OSS Releases"  at "https://oss.sonatype.org/content/repositories/releases"
    ),
    testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework"),
    parallelExecution in Benchmark := false,
    logBuffered := false
  )
  .settings(SbtJFlexPlugin.jflexSettings)
  .settings(mainClass in (Compile,run) := Some("org.enso.main.Main"))

version := "1.0"
organization := "org.enso"
scalaVersion := "2.12.8"

lazy val root = (project in file(".")).aggregate(syntax)

lazy val Benchmark = config("bench") extend Test
