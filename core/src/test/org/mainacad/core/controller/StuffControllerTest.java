package org.mainacad.core.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mainacad.core.AppConfig;
import org.mainacad.core.controller.StuffController;
import org.mainacad.db.register.domain.Stuff;
import org.mainacad.db.register.service.StuffService;
import org.mockito.Answers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest (controllers = StuffController.class)

public class StuffControllerTest {


   //@Mock(answer = Answers.RETURNS_MOCKS)
    @MockBean
    StuffService stuffService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;


    List<Stuff> stuffs = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        doAnswer(invocation -> stuffs.add(new Stuff())).when(stuffService).saveStuff(new Stuff());


    }

    @Test
    public void stuffsExistWhenStuffsIsClicked() throws Exception {

        this.mockMvc
                .perform(get("/stuffs"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("stuffAttribute"));

        verify(stuffService).listStuff();

      //  Assert.assertEquals("stuffAttribute", stuffService.listStuff());
    }

    @Test
    public void createNoNewStuffWhenErrorsExist() throws Exception {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);

        this.mockMvc.perform(post("/stuffs/new")).andExpect(view().name("stuffForm"));

    }

    @Test
    public void createNewStuffWhenNoErrors() throws Exception {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        this.mockMvc.perform(post("/stuffs/new")).andExpect(view().name("stuffForm"));
    }

    @Test
    public void removeStuff() throws Exception {
        this.mockMvc.perform(get("stuffs/delete/0")).andExpect(view().name("stuffForm"));
        this.mockMvc.perform(delete("stuffs/delete/0")).
                andExpect(status().isOk());
    }


}