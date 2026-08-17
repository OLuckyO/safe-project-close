import org.jetbrains.intellij.platform.gradle.extensions.intellijPlatform

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://packages.jetbrains.team/maven/p/ij/intellij-dependencies/")
    }
    plugins {
        id("org.jetbrains.kotlin.jvm") version "2.3.20"
    }
}

plugins {
    id("org.jetbrains.intellij.platform.settings") version "2.18.1"
}

rootProject.name = "safe.project.close"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        intellijPlatform {
            defaultRepositories()
        }
    }
}

include("frontend")
