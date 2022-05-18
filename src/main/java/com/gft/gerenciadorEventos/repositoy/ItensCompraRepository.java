package com.gft.gerenciadorEventos.repositoy;

import com.gft.gerenciadorEventos.entities.Compra;
import com.gft.gerenciadorEventos.entities.ItensCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensCompraRepository extends JpaRepository<ItensCompra, Long> {
}
