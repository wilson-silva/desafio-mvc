package com.gft.gerenciadorEventos.repositoy;

import com.gft.gerenciadorEventos.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
