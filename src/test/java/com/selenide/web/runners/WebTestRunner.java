package com.selenide.web.runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameters({
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.selenide.web.hooks, com.selenide.web.steps"),
        @ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:features/web"),
        @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@web"),
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, summary")

})

public class WebTestRunner {

}
