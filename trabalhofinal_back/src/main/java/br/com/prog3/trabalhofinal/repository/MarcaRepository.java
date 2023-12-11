package br.com.prog3.trabalhofinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.prog3.trabalhofinal.domain.Marca;



@Repository
public interface MarcaRepository extends CrudRepository<Marca, Long>{
	
}