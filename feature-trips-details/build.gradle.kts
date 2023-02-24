plugins {
    id("com.raultunduc.android-lib")
}
android {
    namespace = "com.example.featurestripsdetails"
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = libs.versions.compose.get()
}
dependencies {
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