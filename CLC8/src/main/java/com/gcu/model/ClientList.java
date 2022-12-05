package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.gcu.model.accounts.ClientModel;

/**
 * Used for REST service
 * @author Jess Larson
 *
 */
@XmlRootElement(name="clients")
public class ClientList {
	
	private List<ClientModel> clientList = new ArrayList<ClientModel>();
	
	//Return a list of clients
	@XmlElement(name="client")
	private List<ClientModel> getclientList(){
		return this.clientList;
	}

	//Set list of client
	public void setClients(List<ClientModel> clients) {
		this.clientList = clients;
	}
	
	//Set an individual client by constructing a client and adding it to the list
	public List<ClientModel> setClient(ClientModel client){
		this.clientList.add(client);
		return this.clientList;
	}
	
}
