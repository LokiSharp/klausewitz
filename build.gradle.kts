import groovy.json.JsonBuilder
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.text.SimpleDateFormat
import java.util.Calendar.getInstance

val projectName: String by project
val projectGroup: String by project
val projectVersion: String by project
val projectDescription: String by project
val projectUrl: String by project
val projectLicensesName: String by project
val projectLicensesUrl: String by project
val projectDeveloperId: String by project
val projectDeveloperName: String by project
val projectDeveloperEmail: String by project
val projectScmConnection: String by project
val projectScmDeveloperConnection: String by project
val projectScmUrl: String by project

plugins {
    java
    kotlin("jvm") version "1.3.31"
    jacoco
    maven
    `maven-publish`
    id("com.github.kt3k.coveralls") version "2.8.2"
}

group = projectGroup
version = projectVersion

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.google.guava:guava:27.0.1-jre")
    testCompile("junit", "junit", "4.12")
    implementation("org.antlr:antlr4-runtime:4.7.2")
    implementation("org.atteo:evo-inflector:1.2.2")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.test {
    extensions.configure(JacocoTaskExtension::class) {
        excludes = listOf(
            "**/clausewitz/antlr/**",
            "**/clausewitz/parser/**",
            "**/clausewitz/hoi4/types/**"
        )
    }
}

tasks.jacocoTestReport {
    classDirectories.setFrom(
        fileTree("build/classes/kotlin/main").apply {
            exclude(
                "**/clausewitz/antlr/**",
                "**/clausewitz/parser/**",
                "**/clausewitz/hoi4/types/**"
            )
        })
    reports {
        xml.isEnabled = true
        html.isEnabled = true
    }
}

coveralls {
    sourceDirs.plusAssign(listOf("src/main/kotlin"))
    jacocoReportPath = "build/reports/jacoco/test/jacocoTestReport.xml"
}

tasks.register<Jar>("sourcesJar") {
    from(sourceSets.main.get().allJava)
    archiveClassifier.set("sources")
}

tasks.register<Jar>("javadocJar") {
    from(tasks.javadoc)
    archiveClassifier.set("javadoc")
}


publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            artifactId = projectName
            from(components["java"])
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set(projectName)
                description.set(projectDescription)
                url.set(projectUrl)
                licenses {
                    license {
                        name.set(projectLicensesName)
                        url.set(projectLicensesUrl)
                    }
                }
                developers {
                    developer {
                        id.set(projectDeveloperId)
                        name.set(projectDeveloperName)
                        email.set(projectDeveloperEmail)
                    }
                }
                scm {
                    connection.set(projectScmConnection)
                    developerConnection.set(projectScmDeveloperConnection)
                    url.set(projectScmUrl)
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri("$buildDir/repos/releases")
            val snapshotsRepoUrl = uri("$buildDir/repos/snapshots")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
        }
    }
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

tasks.create("generateDescriptorJson") {
    doLast {
        val packageDir = "${projectGroup.replace('.', '/')}/${project.name}"
        val date = SimpleDateFormat("yyyy-MM-dd").format(getInstance().time)
        val root = mapOf(
            "package" to mapOf(
                "name" to "clausewitz",
                "repo" to "maven",
                "subject" to "lokisharp",
                "desc" to projectDescription,
                "website_url" to projectUrl,
                "issue_tracker_url" to "${projectUrl}/issues",
                "vcs_url" to "${projectUrl}.git",
                "licenses" to listOf("AGPL-V3"),
                "labels" to listOf("clausewitz", "kotlin"),
                "public_download_numbers" to false,
                "public_stats" to false
            ),
            "version" to mapOf(
                "name" to projectVersion,
                "released" to date,
                "vcs_tag" to projectVersion,
                "gpgSign" to true
            ),
            "files" to listOf(
                mapOf(
                    "includePattern" to "build/libs/(.*\\.jar)",
                    "uploadPattern" to "$packageDir/$projectVersion/\$1",
                    "matrixParams" to mapOf("override" to 1)
                ),
                mapOf(
                    "includePattern" to "build/libs/(.*\\.pom)",
                    "uploadPattern" to "$packageDir/$projectVersion/\$1",
                    "matrixParams" to mapOf("override" to 1)
                )
            ),
            "publish" to true
        )

        val json = JsonBuilder(root)
        val jsonFile = File("$buildDir/descriptor.json")
        jsonFile.writeText(json.toPrettyString())
    }
}

task("generatePom") {
    doLast {
        maven.pom {
            withGroovyBuilder {
                "project" {
                    "licenses" {
                        "license" {
                            setProperty("name", projectLicensesName)
                            setProperty("url", projectLicensesUrl)
                        }
                    }
                }
            }
        }.writeTo("$buildDir/libs/${project.name}-$version.pom")
    }
}
