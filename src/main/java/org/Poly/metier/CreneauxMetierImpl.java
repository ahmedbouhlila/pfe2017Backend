package org.Poly.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.Poly.dao.CongerRepository;
import org.Poly.dao.CreneauxRepository;
import org.Poly.dao.UserRepository;
import org.Poly.entities.Conger;
import org.Poly.entities.Creneaux;
import org.Poly.entities.Rendez_vous;
import org.Poly.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreneauxMetierImpl implements CreneauxMetier {

	@Autowired
	private CreneauxRepository creneauxrepository;
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private CongerRepository congerrrepository;

	@Override
	public List<Creneaux> listCreneaux() {

		return creneauxrepository.findAll();
	}

	@Override
	@Transactional
	public List<Creneaux> listCreneauxMedecin(Long id_medecin, String date) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		try {
			d = sdf1.parse(date);
			c.setTime(d);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("aaaaaa");
		System.out.println(dayOfWeek);
		if (dayOfWeek == 1)
			return new ArrayList<Creneaux>();
		int periode = 0;

		if ((2 <= dayOfWeek) && (dayOfWeek <= 6)) {
			periode = 1;
		}

		User user = userrepository.findOne(id_medecin);
		List<Conger> list1 = congerrrepository.findByUser(user);

		Iterator<Conger> iterator2 = list1.iterator();
		while (iterator2.hasNext()) {
			Conger conger = iterator2.next();
			if (conger.getDateDebut().compareTo(d) * conger.getDateFin().compareTo(d) < 0) {
				return new ArrayList<Creneaux>();
			}

			if (conger.getDateDebut().compareTo(d) == 0) {
				return new ArrayList<Creneaux>();

			}

			if (conger.getDateFin().compareTo(d) == 0) {
				return new ArrayList<Creneaux>();
			}
		}
		List<Creneaux> list = creneauxrepository.findByUserAndPeriode(user, periode);

		Iterator<Creneaux> iterator = list.iterator();
		while (iterator.hasNext()) {
			Creneaux o = iterator.next();

			Iterator<Rendez_vous> l = o.getRendez_vous().iterator();
			while (l.hasNext()) {
				Rendez_vous r = l.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date1 = sdf.format(r.getJour());
				// r.getJour().toString()

				if (date1.equals(date)) {

					iterator.remove();

				}

			}

		}

		return list;

	}

	@Override
	public List<Creneaux> listCreneauxDuMedecin(Long id_medecin) {
		// TODO Auto-generated method stub

		User user = userrepository.findOne(id_medecin);
		return creneauxrepository.findByUser(user);

	}

	@Override
	public List<Creneaux> listCreneauxMed(Long id_medecin) {
		// TODO Auto-generated method stub
		User user = userrepository.findOne(id_medecin);
		return creneauxrepository.findByUser(user);
	}

}
