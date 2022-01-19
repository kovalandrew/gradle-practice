 plugins {
     kotlin("multiplatform")
     id("com.android.library")
     id("dev.icerock.mobile.multiplatform.ios-framework")
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

     sourceSets.configureEach { println("Configure: $name") }

     sourceSets {
         val commonMain by getting
         commonMain.dependencies {
             implementation("org.jetbrains.kotlin:kotlin-stdlib-common:1.6.10")
             api(project(":mpp-library:feature-auth"))
             api(project(":mpp-library:feature-profile"))
         }
     }
 }

 framework {
     export(project = project(":mpp-library:feature-auth"))
     export(project = project(":mpp-library:feature-profile"))
     export("dev.icerock.moko:mvvm-core:0.11.0")
 }