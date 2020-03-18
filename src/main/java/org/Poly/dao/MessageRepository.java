package org.Poly.dao;

import java.util.List;

import org.Poly.entities.Message;
import org.Poly.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findByUserAndUserrecu(User user, User userrecu);

	List<Message> findByUser(User user);

}
