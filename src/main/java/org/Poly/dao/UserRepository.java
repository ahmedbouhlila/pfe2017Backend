package org.Poly.dao;

import java.util.List;

import org.Poly.entities.Role;
import org.Poly.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByLoginAndPass(String login, String pass);

	User findByLoginAndPassAndRole(String login, String pass, Role role);

	List<User> findByRole(Role role);

	List<User> findByLoginOrCin(String login, Long cin);

	List<User> findByLoginAndEmail(String login, String email);

}
