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
             implementation(Deps.stdLib)
             api(project(Modules.featureAuth))
             api(project(Modules.featureProfile))
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
     export(project = project(Modules.featureAuth))
     export(project = project(Modules.featureProfile))
     export(Deps.mokoMvvmCore)
 }