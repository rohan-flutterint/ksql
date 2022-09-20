/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("io.confluent.ksql.java-conventions")
}

dependencies {
    implementation(project(":ksqldb-common"))
    implementation("org.apache.commons:commons-csv:1.4")
    implementation("io.confluent:kafka-schema-registry-client:7.4.0-103")
    implementation("io.confluent:common-logging:7.4.0-106")
    implementation("io.confluent:kafka-connect-avro-converter:7.4.0-103")
    implementation("io.confluent:kafka-protobuf-provider:7.4.0-103")
    api("io.confluent:kafka-json-schema-provider:7.4.0-103")
    api("io.confluent:kafka-connect-protobuf-converter:7.4.0-103")
    api("io.confluent:kafka-connect-json-schema-converter:7.4.0-103")
    implementation("io.confluent:kafka-avro-serializer:7.4.0-103")
    testImplementation(project(":ksqldb-test-util"))
    testImplementation(project(":ksqldb-common"))
}

description = "ksqldb-serde"

val testsJar by tasks.registering(Jar::class) {
    archiveClassifier.set("tests")
    from(sourceSets["test"].output)
}

(publishing.publications["maven"] as MavenPublication).artifact(testsJar)
