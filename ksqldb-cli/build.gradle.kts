/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("io.confluent.ksql.java-conventions")
}

dependencies {
    implementation(project(":ksqldb-rest-client"))
    implementation(project(":ksqldb-version-metrics-client"))
    implementation("javax.inject:javax.inject:1")
    implementation("com.github.rvesse:airline:2.6.0")
    implementation("net.java.dev.jna:jna:4.4.0")
    implementation("org.jline:jline:3.13.1")
    testImplementation(project(mapOf("path" to ":ksqldb-engine", "configuration" to "testOutput")))
    testImplementation(project(":ksqldb-rest-app"))
    testImplementation(project(mapOf("path" to ":ksqldb-rest-app", "configuration" to "testOutput")))
    testImplementation(project(":ksqldb-test-util"))
    testImplementation("org.eclipse.jetty:jetty-jaas:9.4.44.v20210927")
    testImplementation("com.approvaltests:approvaltests:9.5.0")
}

description = "ksqldb-cli"

val testsJar by tasks.registering(Jar::class) {
    archiveClassifier.set("tests")
    from(sourceSets["test"].output)
}

(publishing.publications["maven"] as MavenPublication).artifact(testsJar)
