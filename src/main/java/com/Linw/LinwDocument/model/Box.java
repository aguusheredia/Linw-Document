/**
 * 
 */
package com.Linw.LinwDocument.model;

import java.util.Date;

/**
 * @author AguusHeredia
 *
 */
public class Box {

	Client client;
	String label;
	String entry;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	
	@Override
	public String toString () {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Box: ").append(this.label).append("\n");
		sb.append("Cliente: ").append(this.client.getName()).append("\n");
		sb.append("Cuit: ").append(this.client.getCuit()).append("\n");
		sb.append("Ingreso: ").append(this.entry).append("\n");
		return sb.toString();
	}
	
	
	
	
}
