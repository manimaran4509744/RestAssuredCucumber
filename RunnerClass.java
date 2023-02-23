package org.runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/FeatureFiles/restapiCrudOperation.feature",dryRun=false,glue={"org.stepDefinitionFiles"})
public class RunnerClass {
	
}
