pluginManagement {
    includeBuild("gradle/meta-plugins")
}
plugins {
    id("com.raultunduc.settings")
    id("com.raultunduc.build-scan-config")
}
rootProject.name = "TripViewer"