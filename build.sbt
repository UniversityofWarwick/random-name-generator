organization := "uk.co.halfninja"
name := "random-name-generator"
version := "0.4-warwick"
scalaVersion := "2.13.0"
crossScalaVersions := Seq("2.11.12", "2.12.8", "2.13.0")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % "test"
)

val WarwickPublicSnapshots: MavenRepository = "Nexus Snapshots" at "https://mvn.elab.warwick.ac.uk/nexus/repository/public-snapshots"
val WarwickPublicReleases: MavenRepository = "Nexus Releases" at "https://mvn.elab.warwick.ac.uk/nexus/repository/public-releases"

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
publishTo := {
  if (isSnapshot.value) Some(WarwickPublicSnapshots)
  else Some(WarwickPublicReleases)
}

// Fix publishing on SBT 1.x
// https://github.com/sbt/sbt/issues/3570
updateOptions := updateOptions.value.withGigahorse(false)
