import org.gradle.api.JavaVersion

object Config {
    const val applicationId = "com.hfad.translator"
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
    val javaVersion = JavaVersion.VERSION_1_8
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}


object Modules {
    const val app = ":app"
    const val core = ":core"
    const val model = ":model"
    const val repository = ":repository"
    const val utils = ":utils"

    //Features
    const val historyScreen = ":historyScreen"
}

object Versions {
    //Design
    const val appcompat = "1.4.0"
    const val material = "1.4.0"
    const val constraintlayout = "2.1.2"
    const val swiperefreshlayout = "1.1.0"

    //Kotlin
    const val core = "1.6.0"
    const val stdlib = "1.5.21"
    const val coroutinesCore = "1.4.3"
    const val coroutinesAndroid = "1.4.3"

    //Retrofit
    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"
    const val interceptor = "5.0.0-alpha.3"
    const val adapterCoroutines = "0.9.2"

    //Koin
    const val koin = "3.1.2"
    const val koinAndroid = "3.1.2"
    const val koinAndroidCompat = "3.1.2"

    //Coil
    const val coil = "0.11.0"

    //Room
    const val roomKtx = "2.4.1"
    const val runtime = "2.4.1"
    const val roomCompiler = "2.4.1"

    //Test
    const val jUnit = "4.12"
    const val runner = "1.2.0"
    const val espressoCore = "3.2.0"

    //Glide
    const val glide = "4.12.0"
    const val glideCompiler = "4.11.0"

    //View binding delegate
    const val viewBindingDelegate = "1.4.7"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout ="androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"

}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.stdlib}"
    const val coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val adapter_coroutines = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.adapterCoroutines}"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"

}

object Koin {
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinAndroid}"
    const val koinAndroidCompat = "io.insert-koin:koin-android-compat:${Versions.koinAndroidCompat}"
}
object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideCompiler}"
}


object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.runtime}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.roomKtx}"
}

object ViewBindingDelegate {
    const val viewBindingDelegate = "com.github.kirich1409:viewbindingpropertydelegate:${Versions.viewBindingDelegate}"
}

object TestImpl {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}
