package org.buildnew.polymorphicrequest.web;

import org.buildnew.polymorphicrequest.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AnimalControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void initialize() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    public void givenDogAsRequst_shouldGreet() throws Exception {
        //given
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("dog-request.json").getFile());
        String request = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));

        //when
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/animals")
                .content(request)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo("Bow wow... I'm Dennis. I'm a cute St. Bernard");
    }

    @Test
    public void givenCatAsRequst_shouldGreet() throws Exception {
        //given
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("cat-request.json").getFile());
        String request = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));

        //when
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/animals")
                .content(request)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo("Meaow... I'm Maggie. I'm a cute Ragdoll");
    }

}
