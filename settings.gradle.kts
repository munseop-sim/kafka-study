plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
//plugins {
//    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
//}
rootProject.name="ms2709-kafka"
include("kafka-common")
include("kafka-consumer")
include("kafka-web-application")
