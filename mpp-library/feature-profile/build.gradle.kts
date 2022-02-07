 plugins {
     id("android-conventions")
     id("multiplatform-feature-convention")
}

 repositories {
     mavenCentral()
     google()
 }

 dependencies {
     commonMainApi("dev.icerock.moko:mvvm-core:0.11.0")
 }