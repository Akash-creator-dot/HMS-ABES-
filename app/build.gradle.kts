plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services)

}


android {

    namespace = "com.techgiants.hmsabes"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.techgiants.hmsabes"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildFeatures{
        viewBinding=true

    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.firestore)
    implementation(libs.circleimageview)
    implementation(libs.firebase.storage)
    implementation(libs.constraintlayout)
    implementation(libs.lottie)
    implementation(libs.firebase.messaging)
    implementation(libs.androidx.material)
    implementation(libs.androidx.appcompat.v170)
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx.v284)
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v251) // ViewModel
    implementation(libs.androidx.lifecycle.livedata.ktx) // LiveData
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation (libs.denzcoskun.imageslideshow)
    implementation (libs.play.services.auth) {
        exclude ("com.google.android.gms", "play-services-auth")
    }
    implementation (libs.core)
    implementation(libs.appcompat.v151)
    implementation (libs.picasso)

    implementation (libs.dexter)
}
