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

     sourceSets {
         val commonMain by getting
         commonMain.dependencies {
             implementation("org.jetbrains.kotlin:kotlin-stdlib-common:1.6.10")
         }
     }
 }

 dependencies {
     commonMainApi("dev.icerock.moko:mvvm-core:0.11.0")
 }