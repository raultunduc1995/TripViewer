plugins {
    id("com.raultunduc.android-lib")
}
android {
    namespace = "com.example.datatrips"
    defaultConfig {
        buildConfigField("String", "URL", "\"https://autoliv.github.io/\"")
    }
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.retrofit)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}