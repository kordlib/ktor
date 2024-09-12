/*
 * Copyright 2014-2024 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    `kotlin-dsl`
    // Serialization version should be aligned with the Kotlin version embedded in Gradle
    // https://docs.gradle.org/current/userguide/compatibility.html#kotlin
    kotlin("plugin.serialization") version "1.9.24"
}

val buildSnapshotTrain = properties["build_snapshot_train"]?.toString().toBoolean()

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    if (buildSnapshotTrain) {
        mavenLocal()
    }
}

val ktor_version = "3.0.0-eap-852"

dependencies {
    val kotlin_version = libs.versions.kotlin.get()
    implementation(kotlin("gradle-plugin", kotlin_version))
    implementation(kotlin("serialization", kotlin_version))

    val ktlint_version = libs.versions.ktlint.get()
    implementation("org.jmailen.gradle:kotlinter-gradle:$ktlint_version")

    implementation("io.ktor:ktor-server-default-headers:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-cio:$ktor_version")
    implementation("io.ktor:ktor-server-jetty:$ktor_version")
    implementation("io.ktor:ktor-server-websockets:$ktor_version")
    implementation("io.ktor:ktor-server-auth:$ktor_version")
    implementation("io.ktor:ktor-server-caching-headers:$ktor_version")
    implementation("io.ktor:ktor-server-conditional-headers:$ktor_version")
    implementation("io.ktor:ktor-server-compression:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx:$ktor_version")
    implementation("io.ktor:ktor-network-tls-certificates:$ktor_version")
    implementation("io.ktor:ktor-utils:$ktor_version")

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.logback.classic)
    implementation(libs.tomlj)
}

kotlin {
    jvmToolchain(8)
}
