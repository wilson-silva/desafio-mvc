package com.gft.gerenciadorEventos.repositoy;

import com.gft.gerenciadorEventos.entities.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepository extends JpaRepository<Casa, Long>{
}
