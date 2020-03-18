package org.Poly.metier;

import java.util.List;

import org.Poly.entities.Medicaments;

public interface MedicamentsMetier {

	public Medicaments saveMedicaments(Medicaments me);
	public List<Medicaments> listMedicaments();
	
	public Boolean updateMedicaments(Medicaments me);
	public void effacerMedicaments(Long id_medicaments);
	
}
