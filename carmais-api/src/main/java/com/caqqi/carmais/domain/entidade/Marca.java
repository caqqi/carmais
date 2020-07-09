package com.caqqi.carmais.domain.entidade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Marca extends Entidade {

  @NotNull
  @NotBlank
  @Size(min = 5, max = 100)
  private String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
