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
        renderscriptTargetApi = 18
        renderscriptSupportModeEnabled = true
        renderscriptSupportModeBlasEnabled = true
        vectorDrawables.useSupportLibrary = true
        setProperty("archivesBaseName", "v$versionName($versionCode)")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildFeatures {
            dataBinding = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isUseProguard = true
            isShrinkResources = true
            isZipAlignEnabled = true
            isCrunchPngs = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isCrunchPngs = false
        }
    }

    dexOptions {
        preDexLibraries =  true
        javaMaxHeapSize = "4g"
    }

    sourceSets {
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice.txt")
        exclude("META-INF/ASL2.0")
        exclude("META-INF/*.kotlin_module")
    }

    compileOptions {
        sourceCompatibility = Versions.sourceCompat
        targetCompatibility = Versions.targetCompat
    }
    kotlinOptions {
        jvmTarget = Versions.targetCompat.toString()
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libraries.Essential.Kotlin)
    implementation(Libraries.Essential.AppCompat)
    implementation(Libraries.Essential.Material)
    implementation(Libraries.Essential.Core)
    implementation(Libraries.Essential.FragmentKTX)
    implementation(Libraries.Essential.CollectionKTX)
    implementation(Libraries.Essential.PaletteKTX)
    implementation(Libraries.Essential.Legacy)
    implementation(Libraries.Essential.LifeCycleCore)
    implementation(Libraries.Essential.LifeCycleRuntime)
    implementation(Libraries.Essential.LifeCycleViewModel)
    implementation(Libraries.Essential.LifeCycleExtensions)
    implementation(Libraries.Essential.LifeCycleReactiveStreams)
    implementation(Libraries.Essential.Anko)
    implementation(Libraries.Essential.CoroutinesCore)
    implementation(Libraries.Essential.CoroutinesAndroid)
    implementation(Libraries.Essential.WorkRuntime)
    implementation(Libraries.Essential.MultiDex)

    implementation(Libraries.Ui.Glide)
    implementation(Libraries.Ui.CardView)
    implementation(Libraries.Ui.ConstraintLayout)
    implementation(Libraries.Ui.CoordinatorLayout)
    implementation(Libraries.Ui.Preference)
    implementation(Libraries.Ui.FlexboxLayout)
    implementation(Libraries.Ui.Fresco)

    implementation(Libraries.Network.Retrofit)

    implementation(Libraries.Reactive.RxKotlin)
    implementation(Libraries.Reactive.RxAndroid)

    implementation(Libraries.Utils.AndroidUtils)
    implementation(Libraries.Utils.AdapterHelper)
    implementation(Libraries.Utils.CrashReporter)
    implementation(Libraries.Utils.Browser)
    implementation(Libraries.Utils.GooglePlayCore)

    implementation(Libraries.Animator.Tool)
    implementation(Libraries.Animator.Yoyo)

    testImplementation(TestLibrary.Junit)
    androidTestImplementation(AndroidTestLibraries.Junit)
    androidTestImplementation(AndroidTestLibraries.Espresso)

    implementation(group = "", name = "FastScroll", ext = "aar")
    implementation(group = "", name = "Event", ext = "aar")

    kapt(Annotation.Glide)
}
