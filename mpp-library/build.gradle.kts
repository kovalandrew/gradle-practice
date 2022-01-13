 plugins {
     kotlin("multiplatform")
     id("com.android.library")
}

 android {
     compileSdk = 30

     sourceSets.getByName("main").manifest.srcFile("src/androidMain/AndroidManifest.xml")
 }

 repositories {
     mavenCentral()
     google()
 }

 kotlin {
     ios {
         binaries {
             framework("MultiPlatformLibrary")
         }
     }
     
     android()

     sourceSets.configureEach { println("Configure: $name") }

     sourceSets {
         val commonMain by getting
         commonMain.dependencies {
             implementation("org.jetbrains.kotlin:kotlin-stdlib-common:1.5.30")
             implementation(project(":mpp-library:feature-auth"))
             implementation(project(":mpp-library:feature-profile"))
         }
     }
 }