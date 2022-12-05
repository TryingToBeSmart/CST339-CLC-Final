package com.gcu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ClientList;
import com.gcu.model.accounts.ClientModel;

@RestController
@RequestMapping("/service")
public class ClientsRestService {
	
	@Autowired
	RestServiceInterface service;
	
	//return list of all clients as JSON
	@GetMapping(path="/getClientListJson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<ClientModel> getClientListJson(){
		return service.getClients();
	}
	
	//return list of specific client as JSON
	@GetMapping(path="/getClientJson/{clientID}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ClientModel getClientJson(@PathVariable String clientID) {
		return service.getClient(clientID);
	}
	
	//return list of all clients as XML
	@GetMapping(path="/getClientListXml", produces= {MediaType.APPLICATION_XML_VALUE})
	public ClientList getClientListXml(){
		ClientList list	 = new ClientList();
		list.setClients(service.getClients());
		return list;
	}
	
	//return one specific client as XML
	@GetMapping(path="/getClientXml/{clientID}", produces= {MediaType.APPLICATION_XML_VALUE})
	public ClientList getClientXml(@PathVariable String clientID) {
		ClientList clientList = new ClientList();

		//construct client object using clientID
		ClientModel client = new ClientModel(service.getClient(clientID).getFirstName(),
				service.getClient(clientID).getLastName(), service.getClient(clientID).getAge(), 
				service.getClient(clientID).getWeight(), service.getClient(clientID).getHeight(),
				service.getClient(clientID).getUsername(), service.getClient(clientID).getPassword(),
				service.getClient(clientID).getAccountID());
		
		//pass client object to be added to the ClientList and return
		clientList.setClient(client);
		return clientList;
	}
}
