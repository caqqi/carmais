package com.caqqi.carmais.api;

import com.caqqi.carmais.domain.entidade.Marca;
import com.caqqi.carmais.domain.entidade.Modelo;
import com.caqqi.carmais.domain.entidade.Versao;
import com.caqqi.carmais.domain.repository.VeiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("Teste-Integracao")
@WebMvcTest(VeiculoController.class)
class VeiculoControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private VeiculoRepository veiculoRepository;

  private JacksonTester<List<Marca>> jsonMarca;
  private JacksonTester<List<Modelo>> jsonModelo;
  private JacksonTester<List<Versao>> jsonVersao;

  @BeforeEach
  public void setUpt() {
    JacksonTester.initFields(this, new ObjectMapper());
  }

  @Test
  @DisplayName("Deve retornar todas as Marcas")
  void deve_retonar_todas_as_marcas() throws Exception {
    final var response = mvc.perform(
      get("/v1/veiculos/marcas")
        .accept(APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(APPLICATION_JSON))
      .andReturn()
      .getResponse();

    System.out.println(response);
  }

  @Test
  @DisplayName("Deve retornar todas os Modelos")
  void deve_retonar_todos_os_modelos() throws Exception {
    var response = mvc.perform(
      get("/v1/veiculos/modelos")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(APPLICATION_JSON))
      .andReturn()
      .getResponse();
  }

  @Test
  @DisplayName("Deve retornar todas as Versões")
  void deve_retonar_todas_as_versoes() throws Exception {
    var response = mvc.perform(
      get("/v1/veiculos/versoes")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(APPLICATION_JSON))
      .andReturn()
      .getResponse();
  }
}
