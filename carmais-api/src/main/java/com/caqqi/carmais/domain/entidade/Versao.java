package com.caqqi.carmais.domain.entidade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Versao extends Entidade {

  @NotNull
  private Long modeloId;

  @NotNull
  @NotBlank
  @Size(min = 5, max = 150)
  private String descricao;

  public Long getModeloId() {
    return modeloId;
  }

  public void setModeloId(Long modeloId) {
    this.modeloId = modeloId;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
