pluginManagement {
    includeBuild("../meta-plugins")
}
plugins {
    id("com.raultunduc.settings")
}
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../libs.versions.toml"))
        }
    }
}