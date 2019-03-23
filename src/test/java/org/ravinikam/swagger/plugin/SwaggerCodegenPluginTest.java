package org.ravinikam.swagger.plugin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Set;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

import org.ravinikam.swagger.plugin.task.SwaggerGenerateTask;

class SwaggerCodegenPluginTest {

	File input = new File("src/test/resources/petstore.yaml");
	@Test
	void test() {
		Project project = ProjectBuilder.builder().build();
		//project.getPluginManager().apply("swagger-codegen");
		project.getPluginManager().apply(SwaggerCodegenPlugin.class);
		
		Task myTask = project.getTasks().getByName("swaggerGenerate");
		assertTrue(myTask instanceof SwaggerGenerateTask);		
		
		SwaggerGenerateTask generateTask = (SwaggerGenerateTask) myTask;
		generateTask.setVerbose(true);
		generateTask.setValidateSpec(false);
		generateTask.setInputSpec(input);
		generateTask.setGeneratorName("spring");
		generateTask.setOutputDir(new File("build"));
		generateTask.generate();	
	}

}
