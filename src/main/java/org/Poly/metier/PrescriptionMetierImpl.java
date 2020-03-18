package org.Poly.metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.Poly.Json.JsonRendez_Vous1;
import org.Poly.dao.Prescription1Repository;
import org.Poly.entities.Creneaux;
import org.Poly.entities.Prescription1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrescriptionMetierImpl implements PrescriptionMetier{

	@Autowired
	public Prescription1Repository prescription1repository;
	
	@Override
	public List<Prescription1> listPrescription1() {
		// TODO Auto-generated method stub
		return prescription1repository.findAll();
	}

	@Override
	@Transactional
	public List<Prescription1> savelistPrescription1(List<Prescription1> l) {
		
		List<Prescription1> list= new  ArrayList<Prescription1>();       
		
		 Iterator<Prescription1> iterator = l.iterator();
		 
		 while ( iterator.hasNext() ) {
			 Prescription1 p = iterator.next();
				
		list.add(prescription1repository.save(p)); 
			 
		 }
		
		
		return list;
	}

	

}
