 plugins {
     kotlin("multiplatform") version("1.5.30")
     //id("com.android.library")
}

// android {
//     compileSdk = 30
// }

 repositories {
     mavenCentral()
     google()
 }

 kotlin {
     iosX64()

     sourceSets.configureEach { println("Configure: $name") }

     sourceSets {
         val commonMain by getting
         commonMain.dependencies {
             implementation("org.jetbrains.kotlin:kotlin-stdlib-common:1.5.30")
         }

     }
 }