buildscript {
    repositories {
        google()
        jcenter()
        maven {
            url = uri("https://jitpack.io")
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.Gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://oss.jfrog.org/libs-snapshot") }
        maven { url = uri("https://dl.bintray.com/android/android-tools") }

        mavenLocal()
        mavenCentral()

        flatDir {
            dirs("aars")
        }
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}