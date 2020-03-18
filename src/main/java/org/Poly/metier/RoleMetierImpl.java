package org.Poly.metier;

import java.util.List;

import org.Poly.dao.RoleRepository;
import org.Poly.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleMetierImpl implements RoleMetier {
	@Autowired
	private RoleRepository rolerepository;
	
	@Override
	public Role saveRole(Role ro) {
		// TODO Auto-generated method stub
		return rolerepository.save(ro);
	}

	@Override
	public List<Role> listRoles() {
		// TODO Auto-generated method stub
		return rolerepository.findAll();
	}

	

	
	}

	

	

