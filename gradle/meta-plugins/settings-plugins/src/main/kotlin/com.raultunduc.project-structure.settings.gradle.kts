rootDir.listFiles()
    ?.filter { File(it, "build.gradle.kts").exists() }
    ?.forEach { subproject -> include(subproject.name) }