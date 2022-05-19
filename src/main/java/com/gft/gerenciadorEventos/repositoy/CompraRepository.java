package com.gft.gerenciadorEventos.repositoy;

import com.gft.gerenciadorEventos.entities.Compra;
import com.gft.gerenciadorEventos.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
