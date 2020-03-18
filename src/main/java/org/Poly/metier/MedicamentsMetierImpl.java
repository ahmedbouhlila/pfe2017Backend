package org.Poly.metier;

import java.util.List;

import org.Poly.dao.MedicamentsRepository;
import org.Poly.entities.Medicaments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class MedicamentsMetierImpl implements MedicamentsMetier {
	@Autowired
	private MedicamentsRepository medicamentsrepository;
	
	@Override
	public Medicaments saveMedicaments(Medicaments me) {
		// TODO Auto-generated method stub
		return medicamentsrepository.save(me);
	}

	@Override
	public List<Medicaments> listMedicaments() {
		// TODO Auto-generated method stub
		return   medicamentsrepository.findAll()  ;
	}

	@Override
	@Transactional
	public Boolean updateMedicaments(Medicaments me) {
		medicamentsrepository.save(me);
		return true;
	}

	@Override
	public void effacerMedicaments(Long id_medicaments) {
		medicamentsrepository.delete(id_medicaments);
	}
	
	
}
