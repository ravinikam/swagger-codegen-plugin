## Swagger-Codegen-Plugin
To generate code from swagger specifications

```
buildscript {
  repositories {
    mavenLocal()
    mavenCentral()
  }
  dependencies {
    classpath "org.ravinikam:swagger-codegen-plugin:0.1"
  }
}

apply plugin: 'org.ravinikam.swagger-codegen-plugin'
```