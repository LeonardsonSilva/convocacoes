package com.defensoria.convocacao.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OrgaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnStatusCreatedWhenDataIsSaved() throws Exception {
        String orgaoJson = """
            {
                "nome": "5DP Família"
            }
        """;

        mockMvc.perform(MockMvcRequestBuilders.post("/orgaos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orgaoJson)
        ).andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
