package org.Poly.dao;

import java.util.List;

import org.Poly.entities.Conger;
import org.Poly.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongerRepository extends JpaRepository<Conger, Long> {

	List<Conger> findByUser(User user);

}
