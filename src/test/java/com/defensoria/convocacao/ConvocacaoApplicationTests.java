package com.defensoria.convocacao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConvocacaoApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnAllUnidadesWhenListIsRequested() {
        ResponseEntity<String> response = restTemplate.getForEntity("/unidades", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
