package com.gft.gerenciadorEventos.repositoy;

import com.gft.gerenciadorEventos.entities.ItensCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensCompraRepository extends JpaRepository<ItensCompra, Long> {
}
