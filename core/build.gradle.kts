import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks
bootJar.enabled = true

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")

    kotlin("plugin.jpa")
    kotlin("plugin.allopen")
    kotlin("plugin.spring") // 왜 apply false인지, apply false하면 open이 안되는데
}

dependencies {

    // 의존할 프로젝트를 implementation
    implementation(project(":domain")) // 여기서 annotaion all open이 들어가는 듯?

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
