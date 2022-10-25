import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks
bootJar.enabled = false
jar.enabled = true

plugins {

	// springframework.boot는 jar파일 생성해주는 플러그인이므로 전체 종속성보다는 각 모듈별로 지정
	// https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/
	id("org.springframework.boot")
	id("io.spring.dependency-management")

	// jpa에서 엔티티 클래스를 생성하려면 매개변수 없는 생성자가 필요하다
	// noargs 플러그인을 래핑한게 plugin.jpa이다. 리플렉션을 통해 매개변수 없는 생성자로
	// jpa가 엔티티를 인스턴스화 할 수 있도록 도와준다.
	kotlin("plugin.jpa")
	kotlin("plugin.spring")

	// 코틀린은 기본적으로 final로 클래스를 선언함. 이에, 스프링 CGLIB가 프록시를 만들 수 없어 오류.
	// 이때문에 클래스를 open으로 선언하는 allopen 플러그인을 사용한다
	kotlin("plugin.allopen")

	id("java-test-fixtures")
}

// 아래 클래스에 allopen을 붙여주는 이유는, 아래 클래스들은 직접 어노테이션을 (@Component 등) 지정해주지 않기 때문에
// final 클래스로 선언되어 프록시를 만들지 못하기 때문이다. 이에 사용할 클래스만 직접 붙여준다.
allOpen{
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
	annotation("org.springframework.stereotype.Service")
}

// 아래 애들과 plugin{id}에 선언된 애들의 차이가 있나.
//apply(plugin = "org.springframework.boot")
//apply(plugin = "io.spring.dependency-management")

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("com.h2database:h2")

	// db setting
	implementation("org.flywaydb:flyway-core")
	runtimeOnly("com.h2database:h2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

kotlin.sourceSets.main {
	setBuildDir("$buildDir")
}
