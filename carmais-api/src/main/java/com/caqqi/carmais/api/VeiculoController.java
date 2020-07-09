package com.caqqi.carmais.api;

import com.caqqi.carmais.api.dto.MarcaDto;
import com.caqqi.carmais.api.dto.ModeloDto;
import com.caqqi.carmais.api.dto.VersaoDto;
import com.caqqi.carmais.domain.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/veiculos")
public class VeiculoController {

  @Autowired
  private VeiculoRepository veiculoRepository;

  @GetMapping("/marcas")
  public ResponseEntity<List<MarcaDto>> marcas() {
    final var marcasDto = new ArrayList<MarcaDto>();
    veiculoRepository
      .marcas()
      .forEach(marca -> marcasDto.add(new MarcaDto(marca.getNome())));

    return ResponseEntity.ok(marcasDto);
  }

  @GetMapping("/modelos")
  public ResponseEntity<List<ModeloDto>> modelos() {
    final var modelosDto = new ArrayList<ModeloDto>();
    veiculoRepository
      .modelos()
      .forEach(modelo ->
        modelosDto.add(
          new ModeloDto(
            modelo.getMarcaId(),
            modelo.getNome()
          )
        ));
    return ResponseEntity.ok(modelosDto);
  }

  @GetMapping("/versoes")
  public ResponseEntity<List<VersaoDto>> versoes() {
    final var versoesDto = new ArrayList<VersaoDto>();
    veiculoRepository
      .versoes()
      .forEach(versao -> versoesDto.add(
        new VersaoDto(
          versao.getModeloId(),
          versao.getDescricao()
        )
      ));
    return ResponseEntity.ok(versoesDto);
  }

}
