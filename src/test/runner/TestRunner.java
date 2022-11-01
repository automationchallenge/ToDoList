package test.runner;

@Runner((Cucumber.class))
@CucumberOptions(features = {"src/test/java/features"}, plugin = {"json:target/cucumber.json","pretty"},glue="steps")
public class TestRunner {

}
