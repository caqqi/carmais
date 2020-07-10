package com.caqqi.carmais.veiculo.api;

import com.caqqi.carmais.veiculo.api.dto.MarcaDto;
import com.caqqi.carmais.veiculo.api.dto.ModeloDto;
import com.caqqi.carmais.veiculo.api.dto.VersaoDto;
import com.caqqi.carmais.veiculo.domain.service.VeiculoService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/veiculos")
public class VeiculoController {

  private final VeiculoService veiculoService;

  @Autowired
  public VeiculoController(VeiculoService veiculoService) {
    this.veiculoService = veiculoService;
  }

  @GetMapping("/modelos")
  public ResponseEntity<List<ModeloDto>> modelos() {
    final var modelos = veiculoService.modelos();
    return CollectionUtils.isNotEmpty(modelos)
      ? ResponseEntity.ok(modelos)
      : ResponseEntity.noContent().build();
  }

  @GetMapping("/versoes")
  public ResponseEntity<List<VersaoDto>> versoes() {
    final var versoes = veiculoService.versoes();
    return CollectionUtils.isNotEmpty(versoes)
      ? ResponseEntity.ok(versoes)
      : ResponseEntity.noContent().build();
  }

}
