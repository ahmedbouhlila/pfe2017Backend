package org.Poly.dao;

import java.util.List;

import org.Poly.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
	List<Facture> findByIdsecretaireAndEtat(Long id_secretaire, String etat);

}
