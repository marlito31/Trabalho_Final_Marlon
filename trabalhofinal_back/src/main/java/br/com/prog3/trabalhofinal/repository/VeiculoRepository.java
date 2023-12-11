package br.com.prog3.trabalhofinal.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import br.com.prog3.trabalhofinal.domain.Veiculo;



@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Long>{
	
}
