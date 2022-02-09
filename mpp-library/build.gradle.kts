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
 }

 dependencies {
     dependencies {
         commonMainImplementation(libs.kotlin.stdlib)

         commonMainApi(projects.mppLibrary.featureAuth)
         commonMainApi(projects.mppLibrary.featureProfile)
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
     export(projects.mppLibrary.featureAuth)
     export(projects.mppLibrary.featureProfile)
     export(libs.moko.mvvm.core)
 }