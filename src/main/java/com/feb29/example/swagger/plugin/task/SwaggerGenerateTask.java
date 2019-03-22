package com.feb29.example.swagger.plugin.task;

import java.io.File;

import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;
import org.gradle.internal.logging.text.StyledTextOutputFactory;

import io.swagger.codegen.ClientOptInput;
import io.swagger.codegen.CodegenConfig;
import io.swagger.codegen.DefaultGenerator;
import io.swagger.codegen.config.CodegenConfigurator;

public class SwaggerGenerateTask extends DefaultTask {
	/**
	 * The verbosity of generation
	 */
	@Input
	private boolean verbose;

	/**
	 * Whether or not an input specification should be validated upon generation.
	 */
	@Input
	private boolean validateSpec;

	/**
	 * The name of the generator which will handle codegen. (see "swaggerGenerators"
	 * task)
	 */
	@Input
	private String generatorName;

	/**
	 * The output target directory into which code will be generated.
	 */
	@OutputDirectory
	private File outputDir;

	/**
	 * The Swagger specification location.
	 */
	@InputFile
	private File inputSpec;

	@TaskAction
	public void generate() {
		System.out.printf("%s, %s!\n", getOutputDir(), getGeneratorName());
		CodegenConfigurator codegenConfigurator = new CodegenConfigurator();
		codegenConfigurator.setInputSpec(getInputSpec().getAbsolutePath());
		codegenConfigurator.setLang(getGeneratorName());
		codegenConfigurator.setOutputDir(getOutputDir().getAbsolutePath());
		codegenConfigurator.addSystemProperty("apis", "");
		codegenConfigurator.addSystemProperty("models", "");

		try {
			new DefaultGenerator().opts(codegenConfigurator.toClientOptInput()).generate();
		} catch (Exception e) {
			throw new GradleException("Code generation failed.", e);
		}
	}

	/**
	 * @return the verbose
	 */
	public boolean isVerbose() {
		return verbose;
	}

	/**
	 * @param verbose the verbose to set
	 */
	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	/**
	 * @return the validateSpec
	 */
	public boolean isValidateSpec() {
		return validateSpec;
	}

	/**
	 * @param validateSpec the validateSpec to set
	 */
	public void setValidateSpec(boolean validateSpec) {
		this.validateSpec = validateSpec;
	}

	/**
	 * @return the generatorName
	 */
	public String getGeneratorName() {
		return generatorName;
	}

	/**
	 * @param generatorName the generatorName to set
	 */
	public void setGeneratorName(String generatorName) {
		this.generatorName = generatorName;
	}

	/**
	 * @return the outputDir
	 */
	public File getOutputDir() {
		return outputDir;
	}

	/**
	 * @param outputDir the outputDir to set
	 */
	public void setOutputDir(File outputDir) {
		this.outputDir = outputDir;
	}

	/**
	 * @return the inputSpec
	 */
	public File getInputSpec() {
		return inputSpec;
	}

	/**
	 * @param inputSpec the inputSpec to set
	 */
	public void setInputSpec(File inputSpec) {
		this.inputSpec = inputSpec;
	}

}
