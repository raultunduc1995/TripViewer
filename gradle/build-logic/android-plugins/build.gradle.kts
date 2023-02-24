plugins {
    `kotlin-dsl`
}
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}
dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.hilt.gradlePlugin)
}