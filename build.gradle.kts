import org.jetbrains.intellij.platform.gradle.tasks.aware.SplitModeAware

plugins {
    id("org.jetbrains.intellij.platform")
    id("org.jetbrains.kotlin.jvm")
}

subprojects {
    apply(plugin = "org.jetbrains.intellij.platform.module")
    apply(plugin = "org.jetbrains.kotlin.jvm")
}

dependencies {
    intellijPlatform {
        intellijIdea("2026.1.3")
        pluginModule(implementation(project(":frontend")))
    }
}

intellijPlatform {
    splitMode = true
    pluginInstallationTarget = SplitModeAware.PluginInstallationTarget.FRONTEND

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
    }

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }
}
