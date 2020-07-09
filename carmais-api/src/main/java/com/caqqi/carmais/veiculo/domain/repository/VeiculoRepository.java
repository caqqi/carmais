package com.caqqi.carmais.veiculo.domain.repository;

import com.caqqi.carmais.veiculo.domain.entidade.Marca;
import com.caqqi.carmais.veiculo.domain.entidade.Modelo;
import com.caqqi.carmais.veiculo.domain.entidade.Versao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VeiculoRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private static final String SQL_MARCAS = "SELECT * FROM MARCA";
  private static final String SQL_VERSAO = "SELECT * FROM VERSAO";
  private static final String SQL_MODELOS = "SELECT * FROM MODELO";

  public List<Marca> marcas() {
    return jdbcTemplate.query(SQL_MARCAS, Marca::rowMapper);
  }

  public List<Modelo> modelos() {
    return jdbcTemplate.query(SQL_MODELOS, Modelo::rowMapper);
  }

  public List<Versao> versoes() {
    return jdbcTemplate.query(SQL_VERSAO, Versao::rowMapper);
  }

}
