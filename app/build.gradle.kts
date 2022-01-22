plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Releases.versionCode
        versionName = Releases.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

    dependencies {
        /**Modules**/
        implementation(project(":utils"))
        //AndroidX
        implementation(Design.appcompat)
        //You should not use the com.android.support and com.google.android.material dependencies in your app at the same time
        implementation(Design.material)
        implementation(Design.constraintlayout)
        implementation(Design.swiperefreshlayout)

        //Retrofit
        implementation(Retrofit.retrofit)
        implementation(Retrofit.converter_gson)
        implementation(Retrofit.logging_interceptor)
        implementation(Retrofit.adapter_coroutines)

        //Room
        implementation(Room.runtime)
        kapt(Room.compiler)
        implementation(Room.room_ktx)

        //Glide
        implementation(Glide.glide)
        kapt(Glide.glideCompiler)

        //view binding delegate
        implementation(ViewBindingDelegate.viewBindingDelegate)

        implementation(Koin.koin_android)
        implementation(Koin.koin_view_model)

        // Coroutine
        implementation(Kotlin.core)
        implementation(Kotlin.stdlib)
        implementation(Kotlin.coroutines_core)
        implementation(Kotlin.coroutines_android)


        //Test
        testImplementation(TestImpl.junit)
        androidTestImplementation(TestImpl.runner)
        androidTestImplementation(TestImpl.espresso)
        implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    }

