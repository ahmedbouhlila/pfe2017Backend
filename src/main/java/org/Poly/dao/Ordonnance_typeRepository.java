package org.Poly.dao;

import java.util.List;

import org.Poly.entities.Ordonnance_type;
import org.Poly.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ordonnance_typeRepository extends JpaRepository<Ordonnance_type, Long> {

	List<Ordonnance_type> findByUser(User user);

}
