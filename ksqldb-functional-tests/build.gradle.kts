/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("io.confluent.ksql.java-conventions")
}

dependencies {
    implementation(project(":ksqldb-engine"))
    api("org.apache.kafka:kafka-clients:7.4.0-27-ccs:test")
    implementation("junit:junit:4.13.2")
    implementation("com.github.rvesse:airline:2.6.0")
    implementation("org.hamcrest:hamcrest-all:1.3")
    implementation("org.apache.kafka:kafka-streams-test-utils:7.4.0-27-ccs")
    implementation(project(":ksqldb-rest-app"))
    implementation("com.google.protobuf:protobuf-java:3.19.4")
    implementation("com.google.protobuf:protobuf-java-util:3.19.4")
    implementation("commons-io:commons-io:2.7")
    testImplementation(project(mapOf("path" to ":ksqldb-engine", "configuration" to "testOutput")))
    testImplementation(project(mapOf("path" to ":ksqldb-rest-model", "configuration" to "testOutput")))
    testImplementation(project(mapOf("path" to ":ksqldb-common", "configuration" to "testOutput")))
    testImplementation(project(mapOf("path" to ":ksqldb-metastore", "configuration" to "testOutput")))
    testImplementation(project(":ksqldb-rest-client"))
    testImplementation(project(mapOf("path" to ":ksqldb-rest-client", "configuration" to "testOutput")))
    testImplementation(project(mapOf("path" to ":ksqldb-rest-app", "configuration" to "testOutput")))
    testImplementation(project(":ksqldb-test-util"))
    testImplementation("io.confluent.avro:avro-random-generator:0.2.2")
}

description = "ksqldb-functional-tests"

val testsJar by tasks.registering(Jar::class) {
    archiveClassifier.set("tests")
    from(sourceSets["test"].output)
}

(publishing.publications["maven"] as MavenPublication).artifact(testsJar)
