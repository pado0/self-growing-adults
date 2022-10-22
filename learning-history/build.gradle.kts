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

    // 카프카
    implementation ("org.springframework.kafka:spring-kafka")

    // 우리는 api 요청을 카프카로 받아야함. 카프카 producer가 http 인것
    // cloud function kotlin이랑 cloud starter stream kafka를 찾을 수 없다는 오류가 난다.
    // 멀티모듈 의존성 이슈는 아닌 것 같고, 진짜 deprecated 라이브러리인가

    //    implementation("org.springframework.cloud:spring-cloud-function-kotlin")
    implementation("org.springframework.integration:spring-integration-webflux")
    implementation("org.springframework.boot:spring-boot-starter-json")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    //    implementation("org.springframework.cloud:spring-cloud-starter-stream-kafka")



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
