plugins {
    id("com.raultunduc.android-app")
}
android {
    namespace = "com.example.tripviewer"
    defaultConfig {
        applicationId = "com.example.tripviewer"
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = libs.versions.compose.get()
}

dependencies {
    implementation(project(":feature-trips-details"))
    implementation(project(":data-trips"))

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.bundles.hilt.with.navigation)
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}