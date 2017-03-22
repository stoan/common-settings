package com.housescent.commonsettings.web.controller.api;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

/**
 * Created by ADMIN on 2017/03/01.
 */
public class ClientControllerTest {

    @Rule
    public JUnitRestDocumentation restDocumentation =
            new JUnitRestDocumentation("target/generated-snippets");

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void getProperty() throws Exception {

    }

    @Test
    public void getSettings() throws Exception {

    }

}