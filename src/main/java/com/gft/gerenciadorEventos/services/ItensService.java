package com.gft.gerenciadorEventos.services;

import com.gft.gerenciadorEventos.entities.Casa;
import com.gft.gerenciadorEventos.entities.ItensCompra;
import com.gft.gerenciadorEventos.repositoy.CasaRepository;
import com.gft.gerenciadorEventos.repositoy.ItensCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItensService {
	
	@Autowired	
	private ItensCompraRepository itensCompraRepository;
	
	
	//-----------------------------------------------------------------------
	public ItensCompra salvarItem(ItensCompra itensCompra) {
		
		return itensCompraRepository.save(itensCompra);
	}
	
	//-----------------------------------------------------------------------
	public List<ItensCompra> listarItens() {
			
			return itensCompraRepository.findAll();
			
		}
	//-----------------------------------------------------------------------
	public ItensCompra obterItem(Long id) throws Exception {
		
		Optional<ItensCompra> item = itensCompraRepository.findById(id);
		
		if(item.isEmpty()) {
			throw new Exception("item não encontrada!");
		}
		
		return item.get();
			
	}
	//-----------------------------------------------------------------------
	public void excluirItem(Long id) {
		
		itensCompraRepository.deleteById(id);
	}
	

}
