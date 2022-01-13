plugins {
    id("com.android.application")
}

repositories {
    mavenCentral()
    google()
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 16
    }

    lint {
        isAbortOnError = false
    }
}

dependencies {
    implementation(project(":mpp-library"))
}