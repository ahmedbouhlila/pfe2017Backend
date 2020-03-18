package org.Poly.dao;

import java.util.List;

import org.Poly.entities.Creneaux;

import org.Poly.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreneauxRepository extends JpaRepository<Creneaux, Long> {

	List<Creneaux> findByUser(User user);

	List<Creneaux> findByUserAndPeriode(User user, int periode);

}
