
sys.props.get("dependency.resolution") match {
  case Some("ivy") =>
    addCommandAlias(
      "setDependencyResolution",
      """set dependencyResolution := sbt.librarymanagement.ivy.IvyDependencyResolution(ivyConfiguration.value)"""
    )
  case Some("coursier") =>
    addCommandAlias(
      "setDependencyResolution",
      """set dependencyResolution := sbt.librarymanagement.coursier.CoursierDependencyResolution(Resolver.combineDefaultResolvers(resolvers.value.toVector))"""
    )
  case _ => sys.error("""|The system property 'dependency.resolution' is not defined.
                         |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
}

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.17"
)
