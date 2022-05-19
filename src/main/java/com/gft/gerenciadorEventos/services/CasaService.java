package com.gft.gerenciadorEventos.services;

import com.gft.gerenciadorEventos.entities.Casa;
import com.gft.gerenciadorEventos.repositoy.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CasaService {
	
	@Autowired	
	private CasaRepository casaDeShowRepository;

	//-----------------------------------------------------------------------
	public Casa salvarCasaDeShow(Casa casaDeShow) {
		return casaDeShowRepository.save(casaDeShow);
	}
	
	//-----------------------------------------------------------------------
	public List<Casa> listarCasaDeShow() {
			return casaDeShowRepository.findAll();
	}
	//-----------------------------------------------------------------------
	public Casa obterCasaDeShow(Long id) throws Exception {
		Optional<Casa> casaDeShow = casaDeShowRepository.findById(id);
		
		if(casaDeShow.isEmpty()) {
			throw new Exception("casa de show não encontrada!");
		}
		return casaDeShow.get();
	}
	//-----------------------------------------------------------------------
	public void excluirCasaDeShow(Long id) {
		casaDeShowRepository.deleteById(id);
	}

}
