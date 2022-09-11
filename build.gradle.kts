
plugins {
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.noarg")
}


//java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

val props = org.jetbrains.kotlin.konan.properties.loadProperties("ci.properties")

extra["kotlin-coroutines.version"] = "1.6.1"

allprojects{
    apply(plugin = "kotlin")
    apply(plugin = "java")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "kotlin-noarg")

    group = "com.pado"
    version = props.getProperty("appVersion") ?: "1.0.0-SNAPSHOT"

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    repositories {
        mavenCentral()
    }

}

subprojects{
    dependencies {
        implementation(kotlin("stdlib"))
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("io.github.microutils:kotlin-logging:${Version.kotlinLoggingVersion}")

        testImplementation("io.kotest:kotest-runner-junit5:${Version.kotestVersion}")
        testImplementation("io.kotest:kotest-assertions-core:${Version.kotestVersion}")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.kotlinCoroutinesVersion}")
        testImplementation("io.mockk:mockk:${Version.mockkVersion}")
        testImplementation("io.kotest.extensions:kotest-extensions-spring:${Version.kotestExtensionsSpringVersion}")
        testImplementation("org.mockito.kotlin:mockito-kotlin:${Version.mockitoVersion}")

    }

    repositories {
        maven("https://plugins.gradle.org/m2/")
        mavenCentral()
        maven("https://jitpack.io")
    }
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
