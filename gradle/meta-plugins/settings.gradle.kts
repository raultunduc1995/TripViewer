dependencyResolutionManagement {
    repositories.gradlePluginPortal()
    versionCatalogs {
        create("libs") {
            from(files("../libs.versions.toml"))
        }
    }
}
include("settings-plugins")