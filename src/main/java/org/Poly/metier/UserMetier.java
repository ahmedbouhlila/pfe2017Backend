package org.Poly.metier;

import java.util.Date;
import java.util.List;

import org.Poly.Json.JsonRendez_Vous1;
import org.Poly.entities.User;

public interface UserMetier {

	public Boolean motdepassoublier( String login, String email );
	public Boolean saveUser(User us);
	public List<User> listUser();
	public boolean createcreneau(Long id_medecin,int Hdebut , int Hfin, int Mdebut, int Mfin ,int periode );
	public boolean createvisite(Long id_medecin, Long id_dossier_patient , String rapport );
	public User load(User us);
	
	public List<User> getAllMedecin();
	public Boolean updateUser(User us);
	public void effacerUser(Long id_user);
	
	
	public List<JsonRendez_Vous1> prendreconger(Long id_medecin,String dateDebut,String dateFin);
	
	public Boolean validerconger(List<JsonRendez_Vous1> list,String dateDebut,String dateFin,Long id_medecin);
	public User chargeruser(Long id_user);
	
	
}
