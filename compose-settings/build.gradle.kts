import org.jetbrains.compose.compose

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose") version "1.0.0-alpha3"
  id("com.android.library")
}

kotlin {
  android()
  jvm("desktop") {
    compilations.all {
      kotlinOptions.jvmTarget = "11"
    }
  }
  sourceSets {
    val commonMain by getting {
      dependencies {
        api(compose.runtime)
        api(compose.foundation)
        api(compose.material)
        api(compose.materialIconsExtended)
        api(compose.preview)
      }
    }
    val commonTest by getting
    val androidMain by getting {
      dependencies {
        api("androidx.appcompat:appcompat:1.3.1")
        api("androidx.core:core-ktx:1.6.0")
      }
    }
    val androidTest by getting {
      dependencies {
        implementation("junit:junit:4.13.2")
      }
    }
    val desktopMain by getting {
      dependencies {
        api(compose.preview)
      }
    }
    val desktopTest by getting
  }
}

android {
  compileSdk = 30

  defaultConfig {
    minSdk = 21
    targetSdk = 30
  }

  buildTypes {
    named("release") {
      isMinifyEnabled = false
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  lint {
    isCheckReleaseBuilds = false
    isAbortOnError = false
  }
}

ext["PUBLISH_ARTIFACT_ID"] = "compose-settings"

apply(from = "${rootProject.projectDir}/scripts/publish-module.gradle")
