## Swagger-Codegen-Plugin
To generate api and models from swagger specifications

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
Task `swaggerGenerate` is depends on `compileJava`, so just do `./gradle build` once you add details as follows:

```
swaggerGenerate{
	generatorName = "spring"
	inputSpec = "$rootDir/petstore.yaml"
	outputDir = "$rootDir"
}
```
 

