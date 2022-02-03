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

     sourceSets {
         val commonMain by getting
         commonMain.dependencies {
             implementation("org.jetbrains.kotlin:kotlin-stdlib-common:1.6.10")
             api(project(":mpp-library:feature-auth"))
             api(project(":mpp-library:feature-profile"))
         }
     }
 }
 allprojects {
     tasks.create("PrintSourceSets") {
         group = "source-sets-printer"

         doFirst {
             // Добавить проверку, что есть multiplatform плагин
             // Если есть, тогда вызывать блок котлин
             // Утащить это в корневой билд градл ктс

             println("=== SOURCE SETS PRINTER 2000 ===")
             kotlin {
                 this.sourceSets.forEach { println("SourceSet name: ${it.name}") }
                 println("=== SOURCE SETS END. TOTAL: ${this.sourceSets.size} ITEMS ===")
             }
         }
     }
 }
 framework {
     export(project = project(":mpp-library:feature-auth"))
     export(project = project(":mpp-library:feature-profile"))
     export("dev.icerock.moko:mvvm-core:0.11.0")
 }