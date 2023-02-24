pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
    if (File(rootDir, "gradle/build-logic").exists())
        includeBuild("gradle/build-logic")
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}