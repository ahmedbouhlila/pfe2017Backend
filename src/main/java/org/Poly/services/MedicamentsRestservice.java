package org.Poly.services;

import java.util.List;

import org.Poly.entities.Medicaments;
import org.Poly.metier.MedicamentsMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentsRestservice {
	@Autowired
	private MedicamentsMetier medicamentsMetier;

	
	
	@RequestMapping(value="/medicaments",method=RequestMethod.POST)
	public Medicaments saveMedicaments(@RequestBody Medicaments me) {
		return medicamentsMetier.saveMedicaments(me);
	}


	@RequestMapping(value="/medicaments",method=RequestMethod.GET)	
	public List<Medicaments> listMedicaments() {
		return medicamentsMetier.listMedicaments() ;
	}
	

	
	@RequestMapping(value="/modifiermedicaments",method=RequestMethod.POST)
	public Boolean updateUser( @RequestBody Medicaments me) {
		return medicamentsMetier.updateMedicaments(me);
	}
@RequestMapping(value = "/effacermedicaments/{id_medicaments}", method = RequestMethod.DELETE)
    
    public void deleteMedicaments(@PathVariable Long id_medicaments ) {

medicamentsMetier.effacerMedicaments(id_medicaments);

     }
	
	
}
