/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("io.confluent.ksql.java-conventions")
}

dependencies {
    implementation(project(":ksqldb-common"))
    api(project(":ksqldb-rest-model"))
    api(project(":ksqldb-parser"))
    api(project(":ksqldb-metastore"))
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.13.2")
    implementation("org.reactivestreams:reactive-streams:1.0.3")
    testImplementation(project(":ksqldb-test-util"))
    testImplementation("io.vertx:vertx-web:4.3.2")
}

description = "ksqldb-rest-client"

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
