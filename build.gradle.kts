
plugins {
    kotlin("jvm")

    // 코틀린 annotaion plugin.
    // 자바 어노테이션은 코틀린 컴파일 후 동작하므로 코틀린 컴파일시 자바 어노테이션을 먼저 동작시켜야 할 때 사용한다.
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

    // 패키지명, 버전명 명시를 위함
    group = "com.pado"
    version = props.getProperty("appVersion") ?: "1.0.0-SNAPSHOT"

    // test 라는 task 실행시 useJUnitPlatform()을 수행
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    // KotlinCompile task 실행시 옵션을 아래와 같이 설정
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            // 자바, 스프링에서 제공하는 널처리 이점을 옵션으로 가져가기 위함
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

        // 잭슨은 기본적으로 json을 역질렬화 시킬때 기본 생성자를 필요로 한다.
        // 직렬화시 리플렉션을 사용하는데, 리플렉션에셔 기본생성자가 필요하기 때문에 역직렬화시에도 필요.
        // 코틀린에서는 매개변수가 없는 생성자를 만들려면, 생성자의 모든 기본값을 채워야한다.
        // 이에, 잭슨 코틀린 모듈을 지원하여 매개변수가 없는 생성자가 없더라도 직렬화, 역직렬화를 지원한다.
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        implementation("io.github.microutils:kotlin-logging:${Version.kotlinLoggingVersion}")

        testImplementation("io.kotest:kotest-runner-junit5:${Version.kotestVersion}")
        testImplementation("io.kotest:kotest-assertions-core:${Version.kotestVersion}")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.kotlinCoroutinesVersion}")
        testImplementation("io.mockk:mockk:${Version.mockkVersion}")
        testImplementation("io.kotest.extensions:kotest-extensions-spring:${Version.kotestExtensionsSpringVersion}")
        testImplementation("org.mockito.kotlin:mockito-kotlin:${Version.mockitoVersion}")

    }

    repositories {
        maven("https://plugins.gradle.org/m2/") // gradle plugin 저장소의 주소
        mavenCentral()
        maven("https://jitpack.io") // jitpack에 배포된 라이브러리를 쓸때 jitpack 저장소 사용
    }
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
