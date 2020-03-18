package org.Poly.metier;

import java.util.List;

import org.Poly.Json.JsonMessage;
import org.Poly.entities.Message;

public interface MessageMetier {

	
List<JsonMessage> discussions( Long id_user,  Long id_user1  )	;
Boolean envoiemessage( Message message );	
List []	demarage(Long id_user);

}
