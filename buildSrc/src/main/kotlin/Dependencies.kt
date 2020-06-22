import org.gradle.api.JavaVersion

object Application {
    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val Gradle = "4.0.0"
    const val Kotlin = "1.3.50"
    const val AppCompat = "1.0.2"
    const val Material = "1.2.0-beta01"
    const val Core = "1.3.0"
    const val FragmentKTX = "1.2.4"
    const val CollectionKTX = "1.1.0"
    const val PaletteKTX = "1.0.0"
    const val Legacy = "1.0.0"
    const val LifeCycleCore = "2.2.0"
    const val LifeCycleRuntime = "2.2.0"
    const val LifeCycleViewModel = "2.2.0"
    const val LifeCycleExtensions = "2.2.0"
    const val LifeCycleReactiveStreams = "2.2.0"
    const val Anko = "0.10.8"
    const val CoroutinesCore = "1.3.7"
    const val CoroutinesAndroid = "1.3.6"
    const val WorkRuntime = "2.3.4"
    const val MultiDex = "2.0.1"

    const val CardView = "1.0.0"
    const val ConstraintLayout = "1.1.3"
    const val CoordinatorLayout = "1.1.0"
    const val FlexboxLayout = "2.0.1"
    const val Preference = "1.1.1"
    const val Glide = "4.11.0"
    const val Fresco = "2.2.0"

    const val Retrofit = "2.9.0"

    const val RxAndroid = "3.0.0"
    const val RxKotlin = "3.0.0"

    const val AndroidUtils = "3.1.4"
    const val AdapterHelper = "2.0.2"
    const val CrashReporter = "1.1.0"
    const val Browser = "1.2.0"
    const val GooglePlayCore = "1.7.3"

    const val AnimatorTool = "2.1@aar"
    const val AnimatorYOYO = "2.3@aar"

    const val AndroidJunit = "4.12"
    const val AndroidTestJunit = "1.1.1"
    const val AndroidTestEspresso = "3.2.0"

    val sourceCompat = JavaVersion.VERSION_1_8
    val targetCompat = JavaVersion.VERSION_1_8
}

object Annotation {
    const val Glide = "com.github.bumptech.glide:compiler:${Versions.Glide}"
}

object Libraries {
    object Essential {
        const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin}"
        const val AppCompat = "androidx.appcompat:appcompat:${Versions.AppCompat}"
        const val Material = "com.google.android.material:material:${Versions.Material}"
        const val Core = "androidx.core:core-ktx:${Versions.Core}"
        const val FragmentKTX = "androidx.fragment:fragment-ktx:${Versions.FragmentKTX}"
        const val CollectionKTX = "androidx.collection:collection-ktx:${Versions.CollectionKTX}"
        const val PaletteKTX = "androidx.palette:palette-ktx:${Versions.PaletteKTX}"
        const val Legacy = "androidx.legacy:legacy-support-core-ui:${Versions.Legacy}"
        const val LifeCycleCore = "androidx.lifecycle:lifecycle-livedata-core-ktx:${Versions.LifeCycleCore}"
        const val LifeCycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LifeCycleRuntime}"
        const val LifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LifeCycleViewModel}"
        const val LifeCycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.LifeCycleExtensions}"
        const val LifeCycleReactiveStreams = "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.LifeCycleReactiveStreams}"
        const val Anko = "org.jetbrains.anko:anko:${Versions.Anko}"
        const val CoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.CoroutinesCore}"
        const val CoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.CoroutinesAndroid}"
        const val WorkRuntime = "androidx.work:work-runtime-ktx:${Versions.WorkRuntime}"
        const val MultiDex = "androidx.multidex:multidex:${Versions.MultiDex}"
    }

    object Reactive {
        const val RxKotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.RxKotlin}"
        const val RxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.RxAndroid}"
    }

    object Network {
        const val Retrofit = "com.squareup.retrofit2:retrofit:${Versions.Retrofit}"
    }

    object Ui {
        const val CardView = "androidx.cardview:cardview:${Versions.CardView}"
        const val ConstraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.ConstraintLayout}"
        const val CoordinatorLayout =
            "androidx.coordinatorlayout:coordinatorlayout:${Versions.CoordinatorLayout}"
        const val FlexboxLayout = "com.google.android:flexbox:${Versions.FlexboxLayout}"
        const val Preference = "androidx.preference:preference:${Versions.Preference}"
        const val Glide = "com.github.bumptech.glide:glide:${Versions.Glide}"
        const val Fresco = "com.facebook.fresco:fresco:${Versions.Fresco}"
    }

    object Utils {
        const val AndroidUtils = "com.github.sungbin5304:AndroidUtils:${Versions.AndroidUtils}"
        const val AdapterHelper = "com.github.sungbin5304:AdapterHelper:${Versions.AdapterHelper}"
        const val CrashReporter = "com.balsikandar.android:crashreporter:${Versions.CrashReporter}"
        const val Browser = "androidx.browser:browser:${Versions.Browser}"
        const val GooglePlayCore = "com.google.android.play:core:${Versions.GooglePlayCore}"
    }

    object Animator {
        const val Tool = "com.daimajia.easing:library:${Versions.AnimatorTool}"
        const val Yoyo = "com.daimajia.androidanimations:library:${Versions.AnimatorYOYO}"
    }
}

object TestLibrary {
    const val Junit = "junit:junit:${Versions.AndroidJunit}"
}

object AndroidTestLibraries {
    const val Junit = "androidx.test.ext:junit:${Versions.AndroidTestJunit}"
    const val Espresso = "androidx.test.espresso:espresso-core:${Versions.AndroidTestEspresso}"
}