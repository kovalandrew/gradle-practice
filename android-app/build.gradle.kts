plugins {
    id("com.android.application")
}

repositories {
    mavenCentral()
    google()
}

android {
    compileSdk = 30
}

dependencies {
    implementation(project(":mpp-library"))
}