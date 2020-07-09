package com.caqqi.carmais.domain.entidade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Marca extends Entidade {

  @NotNull
  @NotBlank
  @Size(min = 5, max = 100)
  private String nome;

  public Marca() { }

  public Marca(
    @NotNull
    @NotBlank
    @Size(min = 5, max = 100) String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public static Marca rowMapper(ResultSet rs, int index) throws SQLException {
    var marca = new Marca();
    marca.setId(rs.getLong(ID));
    marca.setNome(rs.getString("NOME"));
    marca.setDataInsert(rs.getDate(DATA_INSERT));
    marca.setDataUpdate(rs.getDate(DATA_UPDATE));
    return marca;
  }

}
