plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Application.compileSdk)
    defaultConfig {
        minSdkVersion(Application.minSdk)
        targetSdkVersion(Application.targetSdk)
        versionCode = Application.versionCode
        versionName = Application.versionName
        multiDexEnabled = true
        setProperty("archivesBaseName", "v$versionName($versionCode)")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    sourceSets {
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }

    packagingOptions {
        exclude ("META-INF/library_release.kotlin_module")
    }

    compileOptions {
        sourceCompatibility = Versions.sourceCompat
        targetCompatibility = Versions.targetCompat
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libraries.Essential.Anko)
    implementation(Libraries.Essential.Core)
    implementation(Libraries.Essential.Legacy)
    implementation(Libraries.Essential.Kotlin)
    implementation(Libraries.Essential.AppCompat)
    implementation(Libraries.Essential.LifeCycleViewModel)
    implementation(Libraries.Essential.LifeCycleExtensions)

    implementation(Libraries.Ui.Glide)
    implementation(Libraries.Ui.CardView)
    implementation(Libraries.Ui.ConstraintLayout)

    implementation(Libraries.Network.Retrofit)

    implementation(Libraries.Reactive.RxKotlin)
    implementation(Libraries.Reactive.RxAndroid)

    implementation(Libraries.Utils.AndroidUtils)
    implementation(Libraries.Utils.AdapterHelper)
    implementation(Libraries.Utils.CrashReporter)

    implementation(Libraries.Animator.Tool)
    implementation(Libraries.Animator.Yoyo)

    testImplementation(TestLibrary.Junit)
    androidTestImplementation(AndroidTestLibraries.Junit)
    androidTestImplementation(AndroidTestLibraries.Espresso)

    kapt(Annotation.Glide)
}
