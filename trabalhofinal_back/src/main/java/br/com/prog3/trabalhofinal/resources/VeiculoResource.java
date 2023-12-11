package br.com.prog3.trabalhofinal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.trabalhofinal.domain.Veiculo;
import br.com.prog3.trabalhofinal.service.VeiculoService;

@RestController
@RequestMapping("/api/v1/veiculos")
public class VeiculoResource {
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll(){
		List<Veiculo> veiculos = veiculoService.findAll();
	
		if(veiculos == null || veiculos.isEmpty()) {
			return new ResponseEntity<List<Veiculo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Veiculo>>(veiculos, HttpStatus.OK);
	}
	
	@PostMapping
	public Veiculo create(@RequestBody Veiculo veiculo){
		return veiculoService.save(veiculo);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long id){
	 return veiculoService.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Veiculo> update(@PathVariable("id") Long id, @RequestBody Veiculo veiculo) {
	 return veiculoService.findById(id).map(record -> {record.setPlaca(veiculo.getPlaca());
	 record.setCor(veiculo.getCor());
	 record.setAnoFabricacao(veiculo.getAnoFabricacao());
	 record.setAnoModelo(veiculo.getAnoModelo());
	 Veiculo updated = veiculoService.save(record);
	 return ResponseEntity.ok().body(updated);
	 }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id) {
	 return veiculoService.findById(id)
	 .map(record -> {
	 veiculoService.deleteById(id);
	 return ResponseEntity.ok().build();
	 }).orElse(ResponseEntity.notFound().build());
	}
	
}
