package com.feg29.example.swagger.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import com.feb29.example.swagger.plugin.task.SwaggerGenerateTask;

public class SwaggerCodegenPlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.getTasks().create("swaggerGenerate", SwaggerGenerateTask.class, (task) -> { 
                                         
        });
    }
}
