/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("io.confluent.ksql.java-conventions")
}

dependencies {
    implementation(project(":ksqldb-rest-model"))
    implementation(project(":ksqldb-rest-client"))
    implementation(project(":ksqldb-engine"))
    implementation(project(":ksqldb-version-metrics-client"))
    implementation(project(":ksqldb-parser"))
    implementation("io.confluent:kafka-json-serializer:7.4.0-103")
    implementation("com.github.rvesse:airline:2.6.0")
    implementation("org.apache.kafka:connect-json:7.4.0-27-ccs")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.13.2")
    implementation("org.apache.kafka:kafka-log4j-appender:7.4.0-27-ccs")
    implementation("io.confluent:confluent-log4j-extensions:7.4.0-106")
    implementation("io.vertx:vertx-core:4.3.2")
    implementation("io.vertx:vertx-codegen:4.3.2")
    implementation("io.vertx:vertx-web:4.3.2")
    implementation("io.vertx:vertx-dropwizard-metrics:4.3.2")
    api("io.vertx:vertx-web-client:4.3.2")
    implementation("io.netty:netty-tcnative-boringssl-static:2.0.53.Final")
    implementation("org.reactivestreams:reactive-streams:1.0.3")
    implementation("org.eclipse.jetty:jetty-jaas:9.4.44.v20210927")
    testImplementation(project(mapOf("path" to ":ksqldb-common", "configuration" to "testOutput")))
    testImplementation(project(mapOf("path" to ":ksqldb-engine", "configuration" to "testOutput")))
    testImplementation(project(mapOf("path" to ":ksqldb-rest-model", "configuration" to "testOutput")))
    testImplementation(project(":ksqldb-test-util"))
    testImplementation("org.codehaus.plexus:plexus-utils:3.3.0")
    testImplementation("com.kjetland:mbknor-jackson-jsonschema_2.13:1.0.39")
    testImplementation("org.jeasy:easy-random-core:4.2.0")
}

description = "ksqldb-rest-app"

val testsJar by tasks.registering(Jar::class) {
    archiveClassifier.set("tests")
    from(sourceSets["test"].output)
}

val testOutput by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = false
}

artifacts {
    add("testOutput", tasks.named("testsJar").get())
}

(publishing.publications["maven"] as MavenPublication).artifact(testsJar)
