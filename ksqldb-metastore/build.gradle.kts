/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("io.confluent.ksql.java-conventions")
}

dependencies {
    api(project(":ksqldb-common"))
    api(project(":ksqldb-execution"))
    testImplementation(project(":ksqldb-common"))
    testImplementation(project(":ksqldb-test-util"))
}

description = "ksqldb-metastore"

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