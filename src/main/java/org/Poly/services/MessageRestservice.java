package org.Poly.services;

import java.util.List;

import org.Poly.Json.JsonMessage;
import org.Poly.entities.Message;
import org.Poly.entities.Ordonnance_type;
import org.Poly.metier.MessageMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MessageRestservice {

	@Autowired
	private MessageMetier messageMetier;
	

	@RequestMapping(value="/chats",method=RequestMethod.PUT)
	public List<JsonMessage> disccusion (@RequestParam Long id_user, 
			@RequestParam		Long id_user1 
			)
	 {
		
		return messageMetier.discussions(id_user, id_user1) ;
	}
	
	@RequestMapping(value="/envoiemessage",method=RequestMethod.POST)
	public Boolean envoiemessage( @RequestBody Message message)
	{
		
	return messageMetier.envoiemessage(message)	;
		
	}
	
	@RequestMapping(value="/demarage",method=RequestMethod.PUT)
	public List[] demarage (@RequestParam Long id_user)
	{
		return messageMetier.demarage(id_user);
	}
	
	
			
}
