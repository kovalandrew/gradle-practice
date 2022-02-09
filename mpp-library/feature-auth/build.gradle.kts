 plugins {
     kotlin("multiplatform")
     id("com.android.library")
}

 android {
     compileSdk = 30
     defaultConfig {
         minSdk = 16
     }

     sourceSets.getByName("main").manifest.srcFile("src/androidMain/AndroidManifest.xml")
 }

 repositories {
     mavenCentral()
     google()
 }

 kotlin {
     ios()
     android()
 }

 dependencies {
     commonMainApi(libs.moko.mvvm.core)
     commonMainImplementation(libs.kotlin.stdlib)
 }