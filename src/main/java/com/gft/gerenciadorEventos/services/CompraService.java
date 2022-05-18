package com.gft.gerenciadorEventos.services;

import com.gft.gerenciadorEventos.entities.Casa;
import com.gft.gerenciadorEventos.entities.Compra;
import com.gft.gerenciadorEventos.repositoy.CasaRepository;
import com.gft.gerenciadorEventos.repositoy.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompraService {
	
	@Autowired	
	private CompraRepository compraRepository;
	
	
	//-----------------------------------------------------------------------
	public Compra salvarCompra(Compra compra) {
		
		return compraRepository.save(compra);
	}
	
	//-----------------------------------------------------------------------
	public List<Compra> listarCompra() {
			
			return compraRepository.findAll();
			
		}
	//-----------------------------------------------------------------------
	public Compra obterCompra(Long id) throws Exception {
		
		Optional<Compra> compra = compraRepository.findById(id);
		
		if(compra.isEmpty()) {
			throw new Exception("compra não encontrada!");
		}
		
		return compra.get();
			
	}
	//-----------------------------------------------------------------------
	public void excluirCompra(Long id) {
		
		compraRepository.deleteById(id);
	}
	

}
