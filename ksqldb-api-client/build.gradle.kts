/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("io.confluent.ksql.java-conventions")
}

dependencies {
    implementation(project(":ksqldb-rest-model"))
    implementation(project(":ksqldb-common"))
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.13.2")
    implementation("io.vertx:vertx-core:4.3.2")
    implementation("io.vertx:vertx-codegen:4.3.2")
    implementation("org.reactivestreams:reactive-streams:1.0.3")
    implementation("com.google.guava:guava:30.1.1-jre")
    implementation("com.github.spotbugs:spotbugs-annotations:4.7.1")
    testImplementation(project(":ksqldb-rest-app"))
    testImplementation(project(mapOf("path" to ":ksqldb-rest-app", "configuration" to "testOutput"))) // TODO: test-jar
    testImplementation(project(":ksqldb-test-util"))
    testImplementation(project(mapOf("path" to ":ksqldb-engine", "configuration" to "testOutput"))) // TODO: test-jar
    testImplementation(project(":ksqldb-execution")) // TODO: find transitive source
    testImplementation(project(":ksqldb-parser")) // TODO: find transitive source
    testImplementation(project(":ksqldb-rest-client")) // TODO: find transitive source
    testImplementation(project(":ksqldb-engine")) // TODO: find transitive source
    testImplementation("org.apache.kafka:kafka-streams:7.4.0-27-ccs")
    testImplementation("org.eclipse.jetty:jetty-jaas:9.4.44.v20210927")
}

description = "ksqldb-api-client"

val testsJar by tasks.registering(Jar::class) {
    archiveClassifier.set("tests")
    from(sourceSets["test"].output)
}

(publishing.publications["maven"] as MavenPublication).artifact(testsJar)

// TODO: shaded jar
// TODO: maven-javadoc-plugin?
// TODO: