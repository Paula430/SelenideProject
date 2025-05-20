package com.selenide.api.runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameters({
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.selenide.api.steps"),
        @ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:features/api"),
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, summary")
})
public class APIRunnerTest {}
