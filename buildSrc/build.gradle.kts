 plugins {
     kotlin("jvm") version("1.6.10")
}

 repositories {
     mavenCentral()
     google()
     gradlePluginPortal()
 }

 dependencies {
     implementation("dev.icerock:mobile-multiplatform:0.13.0")
     implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
     implementation("com.android.tools.build:gradle:7.0.4")
 }

