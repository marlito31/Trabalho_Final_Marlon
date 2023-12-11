package br.com.prog3.trabalhofinal.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.trabalhofinal.domain.Marca;
import br.com.prog3.trabalhofinal.service.MarcaService;

@RestController
@RequestMapping("/api/v1/marcas")
public class MarcaResource {

	@Autowired
	private MarcaService marcaService;
	
	@PostMapping
	public Marca save(@RequestBody Marca marca){
	 return marcaService.save(marca);
	}
	
	@GetMapping
	public List<Marca> findAll(){
		return marcaService.findAll();
	}
	@GetMapping(path = {"/{id}"})
	public Optional<Marca> findById(@PathVariable("id") Long id){
	return marcaService.findById(id);
	}
	
	@PutMapping(value="/{id}")
	public Marca update(@PathVariable("id") Long id, @RequestBody Marca marca) {
		Optional<Marca> optional = marcaService.findById(id);
		if(optional.isPresent()) {
			Marca c = optional.get();
			c.setSigla(marca.getSigla());
			c.setDescricao(marca.getDescricao());
			marcaService.update(c);
			return c;
	}else {
		throw new RuntimeException("Não foi possível alterar registro");
	}

	}
	@DeleteMapping(path ={"/{id}"})
	public void delete(@PathVariable("id") Long id) {
		marcaService.deleteById(id);
	}
}
