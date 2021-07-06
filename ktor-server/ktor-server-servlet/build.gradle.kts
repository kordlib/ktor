description = ""
val mockk_version: String by extra

kotlin.sourceSets {
    val jvmMain by getting {
        dependencies {
            api(project(":ktor-server:ktor-server-host-common"))
            api(project(":ktor-http:ktor-http-cio"))

            compileOnly("javax.servlet:javax.servlet-api:4.0.1")
        }
    }

    val jvmTest by getting {
        dependencies {
            api(project(":ktor-server", configuration = "testOutput"))
            implementation("io.mockk:mockk:$mockk_version")
            implementation("javax.servlet:javax.servlet-api:4.0.1")
        }
    }
}