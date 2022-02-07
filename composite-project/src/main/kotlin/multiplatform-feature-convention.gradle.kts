plugins {
    id("org.jetbrains.kotlin.multiplatform")
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