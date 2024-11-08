plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.td1task12"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.td1task12"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    dependencies {
        implementation ("androidx.activity:activity-compose:1.7.0")// ou la dernière version
        implementation ("androidx.compose.ui:ui:1.5.0")  // ou la dernière version
        implementation ("androidx.compose.material3:material3:1.0.0") // ou la dernière version
        implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0") // ou la dernière version
    }


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Utilisation de Compose BOM pour gérer les versions de Compose de manière centralisée
    implementation(platform(libs.androidx.compose.bom))

    // Dépendances pour Jetpack Compose
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation("androidx.compose.material:material") // Gardez simplement la dépendance Material

    // ViewModel pour Jetpack Compose

    // Autres dépendances
    implementation(libs.androidx.material3)

    // Dépendances pour les tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Dépendances pour le débogage
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}