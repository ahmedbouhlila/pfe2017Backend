package org.Poly.metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.Poly.Json.JsonMessage;
import org.Poly.Json.JsonOrdonnancePharmacien;
import org.Poly.Json.JsonRendez_Vous2;
import org.Poly.dao.MedicamentsRepository;
import org.Poly.dao.MessageRepository;
import org.Poly.dao.UserRepository;
import org.Poly.entities.Message;
import org.Poly.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageMetierImpl implements MessageMetier{
	@Autowired
	private MessageRepository messagerepository;
	@Autowired
	UserRepository userrepository;
	
	@Override
	@Transactional
	public List<JsonMessage> discussions(Long id_user, Long id_user1) {
		List<JsonMessage>  list = new  ArrayList<JsonMessage>();
		
		List<Message> messagesenvoyer= new  ArrayList<Message>();
		List<Message> messagesrecu= new  ArrayList<Message>();
		User us=userrepository.findOne(id_user);
		
		User us1=userrepository.findOne(id_user1);
		messagesenvoyer=messagerepository.findByUserAndUserrecu(us, us1);
		messagesrecu=messagerepository.findByUserAndUserrecu(us1, us);
		
		Iterator<Message> iterator = messagesenvoyer.iterator();
		
		 while ( iterator.hasNext() ) {
			 Message message= iterator.next();
		
			 JsonMessage json=new JsonMessage();
		
			 json.setDate(message.getDate());
			 json.setMessage(message.getMessage());
			 json.setQui("me");
			 list.add(json);
			 
			 
		 }
		
			Iterator<Message> iterator1 = messagesrecu.iterator();
			
			 while ( iterator1.hasNext() ) {
				 Message message= iterator1.next();
			
				 JsonMessage json=new JsonMessage();
			
				 json.setDate(message.getDate());
				 json.setMessage(message.getMessage());
				 json.setQui("partner");
				 list.add(json);
				 
				 
			 }
		
			 if(list.size()>1){
			 Collections.sort(list, new Comparator<JsonMessage>() {
				    public int compare(JsonMessage m1, JsonMessage m2) {
				        return m1.getDate().compareTo(m2.getDate());
				    }
				}); 
			 }
		
		
		return list;
	}

	@Override
	@Transactional
	public Boolean envoiemessage(Message message) {
		
	User us=userrepository.findOne(message.getUser().getId_user());
		
		User us1=userrepository.findOne(message.getUserrecu().getId_user());
		
		Message m =new Message();
		m.setMessage(message.getMessage());
		m.setUser(us);
		m.setUserrecu(us1);
		m.setDate(new Date());
		
		messagerepository.save(m);
		
		return true;
	}

	@Override
	@Transactional
	public List[] demarage(Long id_user) {
		
		List<Long> list= new  ArrayList<Long>();
		List<Message> messages= new  ArrayList<Message>();
		List<JsonMessage> discussion= new  ArrayList<JsonMessage>();	
		User us=userrepository.findOne(id_user);
		messages=messagerepository.findByUser(us);
		
		if(messages.size()>0){
		discussion=this.discussions(id_user, messages.get(messages.size()-1).getUserrecu().getId_user() );
		
		list.add(messages.get(messages.size()-1).getUserrecu().getId_user());
		}
		
		return new List []{discussion,list  };
		
		
		
		
		
	}

}
