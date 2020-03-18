package org.Poly.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.Poly.Json.JsonRendez_Vous1;
import org.Poly.dao.CongerRepository;
import org.Poly.dao.CreneauxRepository;
import org.Poly.dao.Dossier_patientRepository;
import org.Poly.dao.NotificationRepository;
import org.Poly.dao.RoleRepository;
import org.Poly.dao.UserRepository;
import org.Poly.dao.VisiteRepository;
import org.Poly.entities.Conger;
import org.Poly.entities.Creneaux;
import org.Poly.entities.Dossier_patient;
import org.Poly.entities.Notification;
import org.Poly.entities.Rendez_vous;
import org.Poly.entities.Role;
import org.Poly.entities.User;
import org.Poly.entities.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service
public class UserMetierImpl implements UserMetier {

	@Autowired
	private UserRepository userrepository;
	@Autowired
	private CreneauxRepository creaneauxrepository;
	@Autowired
	private VisiteRepository visiterepository;
	@Autowired
	private Dossier_patientRepository dossier_patientrepository;
	@Autowired
	private RoleRepository rolerepository;
	@Autowired
	private CongerRepository congerrepository;
	@Autowired
	private NotificationRepository notificationrepository;
	
	
	@Override
	@Transactional
	public Boolean saveUser(User us) {
		
               if(  us.getEmail()  !=null  )
               {
            	   Random randomno = new Random();
           		long num =   (long) Math.abs(randomno.nextInt());
           		long num1 =   (long) Math.abs(randomno.nextInt());   
            	   
		    String  d_email = "wevioo.pfe@gmail.com",
		            d_password = "wevioopfe",
		            d_host = "smtp.gmail.com",
		            d_port  = "465",
		            
		            m_to = us.getEmail(),
		            
		            
		            m_subject = "Activation du compte",
		            
		            		   
				     
		 		   // get next long value 
		 		   
		            		m_text = " Bonjour, \n"
				            		+ " Veuillez vous connectez sur http://localhost:4200/#/ pour modifier vos informations personnelles: \n\n login: "+num+" \n password: "+num1 
				            	+	" \n\n Bonne journée 🙂 "
				            	+	"  \n Cordialement ,  "  
				             ;
		            
		           

		  us.setLogin(""+num+"");
		  us.setPass(""+num1+"");
		        Properties props = new Properties();
		        props.put("mail.smtp.user", d_email);
		        props.put("mail.smtp.host", d_host);
		        props.put("mail.smtp.port", d_port);
		        props.put("mail.smtp.starttls.enable","true");
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.debug", "true");
		        props.put("mail.smtp.socketFactory.port", d_port);
		        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		        props.put("mail.smtp.socketFactory.fallback", "false");

		        SecurityManager security = System.getSecurityManager();

		        try
		        {
		        	  Session session = Session.getInstance(props,
		        	          new javax.mail.Authenticator() {
		        	            protected PasswordAuthentication getPasswordAuthentication() {
		        	                return new PasswordAuthentication("wevioo.pfe@gmail.com", "wevioopfe");
		        	            }
		        	          }); 
		            session.setDebug(true);
		            MimeMessage msg = new MimeMessage(session);
		            msg.setText(m_text);
		            msg.setSubject(m_subject);
		            msg.setFrom(new InternetAddress(d_email));
		            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
		            Transport.send(msg);
		            userrepository.save(us);
		        }
		        catch (Exception mex)
		        {
		            mex.printStackTrace();
		        } 
               }
		        return true;
		    }
/*
		 
		
		
		
		//
		final String username = "ahmed bouhlila";
        final String password = "bo725196520";
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        System.setProperty("http.proxyHost", "proxy.com");
        System.setProperty("http.proxyPort", "911");
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        System.out.println("aaaaaa");
        try {
        	System.out.println("bbb");
            Message message = new MimeMessage(session);
            System.out.println("cccc");
            message.setFrom(new InternetAddress("bouhlila.ahmed@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("ahmed.bouhlila@ensi-uma.tn"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    
		
		
		
		
		return true;
		
	/*	
		List<User> l =userrepository.findByLoginOrCin(us.getLogin(),us.getCin());
		     
		 Iterator<User> iterator = l.iterator();  
		  if ( iterator.hasNext() )
		  {  
			  
			  
			  return false;
			  
		  }
			  
		  else {	  
		
		
		
		 userrepository.save(us);
	    return true;
		  }
	
		
	}
 */
	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		
	/*	
		
List<User> list= new  ArrayList<User>();
		
		List<User> listuser=userrepository.findAll();
	
		
		Iterator<User> iterator = listuser.iterator();
		
		while ( iterator.hasNext() ) {
			User u = iterator.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        String date1 = sdf.format(u.getDate_naiss());	
		u.setDate_naiss();
		
		*/
		return userrepository.findAll();
	}

	
	
	@Override
	@Transactional
	public boolean createcreneau(Long id_medecin, int Hdebut, int Hfin, int Mdebut, int Mfin, int periode) {
		
		User us= userrepository.findOne(id_medecin) ;
		        
		
	Creneaux c=new Creneaux();
		c.setHdebut(Hdebut);
		c.setHfin(Hfin);
		c.setMdebut(Mdebut);
		c.setMfin(Mfin);
		c.setPeriode(periode);
		c.setUser(us);
		
		creaneauxrepository.save(c);
		
		
		return true;
	}

	@Override
	@Transactional
	public boolean createvisite(Long id_medecin, Long id_dossier_patient, String rapport) {
		User us= userrepository.findOne(id_medecin) ;
		       Dossier_patient dos= dossier_patientrepository.findOne(id_dossier_patient);
		
		Visite v=new Visite();
		
		v.setDate_debut(new Date ());
		v.setUser(us);
		v.setDossier_patient(dos);
		
		visiterepository.save(v);
		
		return true;
	}

	@Override
	public User load(User us) {
		
	
		
		User user= userrepository.findByLoginAndPass(us.getLogin(), us.getPass() ) ; 
		
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	@Transactional
	public List<User> getAllMedecin() {
		
		//role medecin 3 
		Long id_role=(long) 3;
	    Role role=rolerepository.findOne(id_role);
	
	
		return userrepository.findByRole(role);
		
		
	}

	
	
	
	@Override
	@Transactional
	public Boolean updateUser(User us) {
			userrepository.save(us);
		return true;
	}

	@Override
	@Transactional
	public void effacerUser(Long id_user) {
		userrepository.delete(id_user);
		
	}

	@Override
	@Transactional
	public List<JsonRendez_Vous1> prendreconger(Long id_medecin, String dateDebut, String dateFin) {
		
		User user=userrepository.findOne(id_medecin);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d=new Date();
		Date d1=new Date();
		try {
			d = sdf.parse(dateDebut);
			d1=sdf.parse(dateFin);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		
		
		List<JsonRendez_Vous1> list= new  ArrayList<JsonRendez_Vous1>();            
		 List<Creneaux>  	listCreneaux=creaneauxrepository.findByUser(user);
		 Iterator<Creneaux> iterator = listCreneaux.iterator();
		 
		 while ( iterator.hasNext() ) {
				Creneaux c = iterator.next();
				
				 int Hdebut=c.getHdebut();
				int Hfin=c.getHfin();
				 int Mdebut=c.getMdebut();
				 int Mfin=c.getHfin();	
			List<Rendez_vous> listrendez_vous=(List<Rendez_vous>) c.getRendez_vous();	
			 Iterator<Rendez_vous> iterator1=listrendez_vous.iterator();
			 while ( iterator1.hasNext() ) {
					Rendez_vous r = iterator1.next();
					
					
					
					
						 if ((d.compareTo( r.getJour()) * d1.compareTo(r.getJour() ) < 0)||(r.getJour().compareTo(d ) == 0) ||(r.getJour().compareTo(d1 ) == 0)  )	 		
			        	   {

				JsonRendez_Vous1 j=new JsonRendez_Vous1();	
		 j.setHdebut(Hdebut);
		 j.setHfin(Hfin);
		 j.setId_secretaire(r.getId_secretaire());
		 j.setId_patient(r.getPatient().getId_patient());
		 j.setIdRdv(r.getId_rendez_vous());
		 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-M-dd");
	        String date1 = sdf1.format(r.getJour());
			
			j.setJour(date1);
		 j.setMdebut(Mdebut);
		 j.setMfin(Mfin);
		 j.setNom_patient(r.getPatient().getNom_patient());
		 j.setPrenom_patient(r.getPatient().getPrenom_patient());
		 list.add(j); 
			        	   }
			 }
		 }
			
		
		 
		 Collections.sort(list, new Comparator<JsonRendez_Vous1>() {
			    public int compare(JsonRendez_Vous1 m1, JsonRendez_Vous1 m2) {
			        return m1.getJour().compareTo(m2.getJour());
			    }
			}); 
		 
		 
			return list;
		
		
		
		
		/*
		User user=userrepository.findOne(id_medecin);
		Conger c = new Conger();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		Date d1;
		try {
			d = sdf.parse(dateDebut);
			d1=sdf.parse(dateFin);
			c.setDateDebut(d);
			c.setDateFin(d1);	
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		c.setUser(user);
		congerrepository.save(c);
		*/
	
	}

	@Override
	@Transactional
	public Boolean validerconger(List<JsonRendez_Vous1> list, String dateDebut, String dateFin,Long id_medecin) {
		// TODO Auto-generated method stub
	
		User user=userrepository.findOne(id_medecin);
		Conger c = new Conger();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		Date d1;
		try {
			d = sdf.parse(dateDebut);
			d1=sdf.parse(dateFin);
			c.setDateDebut(d);
			c.setDateFin(d1);	
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		c.setUser(user);
		congerrepository.save(c);
		
		
		
		Iterator<JsonRendez_Vous1> iterator=list.iterator();
		while ( iterator.hasNext() ) {
			JsonRendez_Vous1 j = iterator.next();
		User u =	userrepository.findOne(j.getId_secretaire());
		Notification n = new Notification();
			n.setUser(u);
			n.setType("annulation");
			n.setIdrdv(j.getIdRdv());
			n.setJour(new Date());
		
			notificationrepository.save(n);
			
		}
			
		return true;
	}
	@Override
	public Boolean motdepassoublier(String login, String email) {
		// TODO Auto-generated method stub
		
	List<User> list = userrepository.findByLoginAndEmail(login, email);
	System.out.println("zzzzzz");
	System.out.println(list.size());
	if (list.size()!=1)
		 {return false;}
	
	 System.out.println("yyyyyyyyyy");
	 Iterator<User> iterator = list.iterator();
	 
	 User u = new User() ;
	 while ( iterator.hasNext() ) {
			 u = iterator.next();
	 
	 
	 }
	 
	 String  d_email = "wevioo.pfe@gmail.com",
	            d_password = "wevioopfe",
	            d_host = "smtp.gmail.com",
	            d_port  = "465",
	            
	            m_to = email,
	            
	            
	            m_subject = "Mot de passe oublier",
	            
	            		   
			     
	 		   // get next long value 
	 		    
	            m_text = "Bonjour "+u.getPrenom()+" "+u.getNom()+" votre mot de passe est: "+u.getPass()+" " 	+	" \n\n Bonne journée 🙂 "
		            	+	"  \n Cordialement ,  " ;

	
	        Properties props = new Properties();
	        props.put("mail.smtp.user", d_email);
	        props.put("mail.smtp.host", d_host);
	        props.put("mail.smtp.port", d_port);
	        props.put("mail.smtp.starttls.enable","true");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.debug", "true");
	        props.put("mail.smtp.socketFactory.port", d_port);
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.socketFactory.fallback", "false");

	        SecurityManager security = System.getSecurityManager();

	        try
	        {
	        	  Session session = Session.getInstance(props,
	        	          new javax.mail.Authenticator() {
	        	            protected PasswordAuthentication getPasswordAuthentication() {
	        	                return new PasswordAuthentication("wevioo.pfe@gmail.com", "wevioopfe");
	        	            }
	        	          }); 
	            session.setDebug(true);
	            MimeMessage msg = new MimeMessage(session);
	            msg.setText(m_text);
	            msg.setSubject(m_subject);
	            msg.setFrom(new InternetAddress(d_email));
	            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
	            Transport.send(msg);
	           
	        }
	        catch (Exception mex)
	        {
	            mex.printStackTrace();
	        } 
        
	        return true; 
		
		
		
		
		
	}
	@Override
	public User chargeruser(Long id_user) {
		
		return userrepository.findOne(id_user);
	}

	

}
