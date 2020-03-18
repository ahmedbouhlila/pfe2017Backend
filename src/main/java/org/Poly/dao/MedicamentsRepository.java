package org.Poly.dao;

import org.Poly.entities.Medicaments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentsRepository extends JpaRepository<Medicaments, Long> {

	Medicaments findByNom(String nom);

}
