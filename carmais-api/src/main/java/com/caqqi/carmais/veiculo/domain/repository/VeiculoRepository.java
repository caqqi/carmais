package com.caqqi.carmais.veiculo.domain.repository;

import com.caqqi.carmais.veiculo.api.dto.MarcaComModeloDto;
import com.caqqi.carmais.veiculo.domain.entidade.Marca;
import com.caqqi.carmais.veiculo.domain.entidade.Modelo;
import com.caqqi.carmais.veiculo.domain.entidade.Versao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.caqqi.carmais.veiculo.domain.entidade.Marca.SQL_MARCA_COM_MODELOS;
import static com.caqqi.carmais.veiculo.domain.entidade.Marca.SQL_TODAS_MARCAS;
import static com.caqqi.carmais.veiculo.domain.entidade.Modelo.SQL_TODOS_MODELOS;
import static com.caqqi.carmais.veiculo.domain.entidade.Versao.SQL_TODAS_VERSOES;

@Repository
public class VeiculoRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public VeiculoRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Marca> marcas() {
    return jdbcTemplate.query(SQL_TODAS_MARCAS, Marca::rowMapper);
  }

  public List<Modelo> modelos() {
    return jdbcTemplate.query(SQL_TODOS_MODELOS, Modelo::rowMapper);
  }

  public List<Versao> versoes() {
    return jdbcTemplate.query(SQL_TODAS_VERSOES, Versao::rowMapper);
  }

  public List<MarcaComModeloDto> marcasComModelos() {
    final var resultado = new ArrayList<MarcaComModeloDto>();
    final var query = jdbcTemplate.query(
      SQL_MARCA_COM_MODELOS,
      (ResultSetExtractor<Map<String, List<String>>>) rs -> {
        final var mapaResulSet = new HashMap<String, List<String>>();

        while (rs.next()) {
          final var marca = rs.getString("MARCA");
          final var modelo = rs.getString("MODELO");
          final var modelos = mapaResulSet.get(marca);

          if (Objects.isNull(modelos)) {
            mapaResulSet.put(marca, new ArrayList<>());
          } else {
            modelos.add(modelo);
          }
        }

        return mapaResulSet;
    });

    Objects.requireNonNull(query);
    query.forEach((k, v) -> resultado.add(new MarcaComModeloDto(k, v)));

    return resultado;
  }

}
