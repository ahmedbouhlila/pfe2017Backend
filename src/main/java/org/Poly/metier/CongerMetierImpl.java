package org.Poly.metier;

import java.util.List;

import org.Poly.dao.CongerRepository;
import org.Poly.dao.CreneauxRepository;
import org.Poly.dao.UserRepository;
import org.Poly.entities.Conger;
import org.Poly.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CongerMetierImpl implements CongerMetier  {
	@Autowired
	private CongerRepository congerrepository;
	@Autowired
	private UserRepository userrepository;
	
	
	@Override
	@Transactional
	public List<Conger> listCongerMedecin(Long id_medecin) {
		// TODO Auto-generated method stub
		User u=userrepository.findOne(id_medecin);
		
		return congerrepository.findByUser(u) ;
	}

}
