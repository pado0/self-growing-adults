import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks


plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("plugin.jpa")
	kotlin("plugin.allopen")
	id("java-test-fixtures")
}

allOpen{
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
	annotation("org.springframework.stereotype.Service")
}

apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")
apply(plugin = "org.jetbrains.kotlin.plugin.spring")

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("com.h2database:h2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

kotlin.sourceSets.main {
	setBuildDir("$buildDir")
}
