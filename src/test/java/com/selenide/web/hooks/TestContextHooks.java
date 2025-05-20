package com.selenide.web.hooks;

import com.selenide.web.context.TestContext;
import io.cucumber.java.Before;

public class TestContextHooks {
    private final TestContext context;

    public TestContextHooks(TestContext context) {
        this.context = context;
    }

    @Before("@web")
    public void resetSharedState() {
        context.reset();
    }
}
