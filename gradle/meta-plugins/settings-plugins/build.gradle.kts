plugins {
    `kotlin-dsl`
}
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}
dependencies {
    implementation(libs.gradle.build.scan)
}