package org.Poly.services;

import java.util.List;

import org.Poly.entities.Role;
import org.Poly.metier.RoleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleRestservice {
	@Autowired
	private RoleMetier roleMetier;
	
	@RequestMapping(value="/roles",method=RequestMethod.POST)
	public Role saveRole(@RequestBody Role r) {
		return roleMetier.saveRole(r);
	}


	@RequestMapping(value="/roles",method=RequestMethod.GET)	
	public List<Role> listroles() {
		return roleMetier.listRoles();
	}
	
	
	
}
