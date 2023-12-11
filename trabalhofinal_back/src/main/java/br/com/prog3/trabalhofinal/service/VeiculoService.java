package br.com.prog3.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.trabalhofinal.domain.Veiculo;
import br.com.prog3.trabalhofinal.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;

	public Veiculo save(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	public List<Veiculo> findAll(){
		return (List<Veiculo>) veiculoRepository.findAll();
	}
	
	public Optional<Veiculo> findById(Long id) {
		return veiculoRepository.findById(id);
	}
	
	public Veiculo update(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	public void deleteById(Long id) {
		veiculoRepository.deleteById(id);
	}
}
