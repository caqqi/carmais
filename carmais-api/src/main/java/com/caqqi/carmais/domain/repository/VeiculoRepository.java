package com.caqqi.carmais.domain.repository;

import com.caqqi.carmais.domain.entidade.Marca;
import com.caqqi.carmais.domain.entidade.Modelo;
import com.caqqi.carmais.domain.entidade.Versao;
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

  private static final String ID = "ID";
  private static final String DATA_INSERT = "DATA_INSERT";
  private static final String DATA_UPDATE = "DATA_UPDATE";

  public List<Marca> marcas() {
    return jdbcTemplate.query(SQL_MARCAS, (rs, index) -> {
      var marca = new Marca();
      marca.setId(rs.getLong(ID));
      marca.setNome(rs.getString("NOME"));
      marca.setDataInsert(rs.getDate(DATA_INSERT));
      marca.setDataUpdate(rs.getDate(DATA_UPDATE));
      return marca;
    });
  }

  public List<Modelo> modelos() {
    return jdbcTemplate.query(SQL_MODELOS, (rs, rowNum) -> {
      var modelo = new Modelo();
      modelo.setId(rs.getLong(ID));
      modelo.setMarcaId(rs.getLong("MARCA_ID"));
      modelo.setNome(rs.getString("NOME"));
      modelo.setDataInsert(rs.getDate(DATA_INSERT));
      modelo.setDataUpdate(rs.getDate(DATA_UPDATE));
      return modelo;
    });
  }

  public List<Versao> versoes() {
    return jdbcTemplate.query(SQL_VERSAO, (rs, rowNum) -> {
      var versao = new Versao();
      versao.setId(rs.getLong(ID));
      versao.setModeloId(rs.getLong("MODELO_ID"));
      versao.setDescricao(rs.getString("DESCRICAO"));
      versao.setDataInsert(rs.getDate(DATA_INSERT));
      versao.setDataUpdate(rs.getDate(DATA_UPDATE));
      return versao;
    });
  }

}
