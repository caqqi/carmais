package com.caqqi.carmais.veiculo.api;

import com.caqqi.carmais.veiculo.api.dto.MarcaComModeloDto;
import com.caqqi.carmais.veiculo.api.dto.MarcaDto;
import com.caqqi.carmais.veiculo.domain.repository.VeiculoRepository;
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
public class VeiculoMarcaController {

  private final VeiculoService veiculoService;
  private final VeiculoRepository veiculoRepository;

  @Autowired
  public VeiculoMarcaController(
    VeiculoService veiculoService,
    VeiculoRepository veiculoRepository) {
    this.veiculoService = veiculoService;
    this.veiculoRepository = veiculoRepository;
  }

  @GetMapping("/marcas")
  public ResponseEntity<List<MarcaDto>> marcas() {
    final var marcas = veiculoService.marcas();
    return CollectionUtils.isNotEmpty(marcas)
      ? ResponseEntity.ok(marcas)
      : ResponseEntity.noContent().build();
  }

  @GetMapping("/marcas-modelos")
  public ResponseEntity<List<MarcaComModeloDto>> marcasComModelos() {
    final var marcasComModelos = veiculoRepository.marcasComModelos();
    return CollectionUtils.isNotEmpty(marcasComModelos)
      ? ResponseEntity.ok(marcasComModelos)
      : ResponseEntity.noContent().build();
  }

}
