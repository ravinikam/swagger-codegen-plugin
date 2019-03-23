package org.ravinikam.swagger.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.UnknownTaskException;
import org.ravinikam.swagger.plugin.task.SwaggerGenerateTask;

public class SwaggerCodegenPlugin implements Plugin<Project> {
	public void apply(Project project) {
		project.getTasks().create("swaggerGenerate", SwaggerGenerateTask.class, (task) -> {
			try {
				project.getTasks().getByName("compileJava").dependsOn(task);
			} catch (UnknownTaskException e) {
				System.out.println("Missing java plugin!");
			}
		});
	}
}
