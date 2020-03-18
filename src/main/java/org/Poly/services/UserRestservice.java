package org.Poly.services;

import java.util.Date;
import java.util.List;

import org.Poly.Json.JsonRendez_Vous1;
import org.Poly.entities.User;
import org.Poly.metier.UserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestservice {
	@Autowired
	private UserMetier userMetier;

	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public Boolean saveUser( @RequestBody User us) {
		return userMetier.saveUser(us);
	}
	
	@RequestMapping(value="/modifierusers",method=RequestMethod.POST)
	public Boolean updateUser( @RequestBody User us) {
		return userMetier.updateUser(us);
	}
	
	

	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> listUser() {
		return userMetier.listUser();
	}

	
	
	
	@RequestMapping(value="/ajoutcreneaux",method=RequestMethod.PUT)
	public boolean createcreneau (@RequestParam Long id_medecin, 
			@RequestParam		int Hdebut, 
			@RequestParam	int Hfin, 
			@RequestParam			int Mdebut, 
			@RequestParam	int Mfin,
			@RequestParam	int periode)
	 {
		
		return userMetier.createcreneau(id_medecin, Hdebut, Hfin, Mdebut, Mfin,periode);
	}
	@RequestMapping(value="/ajoutvisite",method=RequestMethod.PUT)
	public boolean createvisite(@RequestParam Long id_medecin, 
			@RequestParam	Long id_dossier_patient, 
			@RequestParam		String rapport)
	
	{
		
		return userMetier.createvisite(id_medecin, id_dossier_patient, rapport);
	}
	//

		
		 @RequestMapping(value = "/effaceruser/{id_user}", method = RequestMethod.DELETE)
		    
		    public void deleteUser(@PathVariable Long id_user ) {
		
		userMetier.effacerUser(id_user);
	
	         }
	
	
	//
	@Secured({"ROLE_admin","ROLE_secretaire", "ROLE_medecin", "ROLE_pharmacien"})
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public User  login( @RequestBody User us) {

		
		
		return userMetier.load(us);
	}
	

	
	
	@Secured({"ROLE_admin","ROLE_secretaire"})
	@RequestMapping(value="/medecins",method=RequestMethod.GET)
	public List<User> listMedecin() {
		return userMetier.getAllMedecin();
	}


	@RequestMapping(value="/ajoutconger",method=RequestMethod.PUT)
	public List<JsonRendez_Vous1> createconger (@RequestParam Long id_medecin, 
			@RequestParam		String dateDebut,	
			@RequestParam		String dateFin)
	{
		
		
		return userMetier.prendreconger(id_medecin, dateDebut, dateFin);
	}
	
	
	@RequestMapping(value ="/validerconger/{dateDebut}/{dateFin}/{id_medecin}", method = RequestMethod.POST)
	public Boolean validerconger(@PathVariable String dateDebut,@PathVariable String dateFin,@PathVariable Long id_medecin,@RequestBody List<JsonRendez_Vous1> list){
	return userMetier.validerconger(list, dateDebut, dateFin, id_medecin);
	}
	
//	
	@RequestMapping(value="/motdepassoublier",method=RequestMethod.PUT)
	public Boolean forgetpassword (@RequestParam String login, 
			@RequestParam		String email)
	{
		
		
		return userMetier.motdepassoublier(login, email);
	}
	
	@RequestMapping(value="/profile",method=RequestMethod.PUT)
	public User getprofile (@RequestParam Long id_user)
	{
		
		
		return userMetier.chargeruser(id_user);
	}
	
	
	
}
