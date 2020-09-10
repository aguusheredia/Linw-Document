/**
 * 
 */
package com.Linw.LinwDocument.model;

/**
 * @author AguusHeredia
 *
 */
public class Client {

	String cuit;
	String name;
	String label;

	
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuil) {
		this.cuit = cuil;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("Cliente: ").append(this.name).append("\n");
		sb.append("Cuit: ").append(this.cuit).append("\n");
		sb.append("Label: ").append(this.label).append("\n");
		return (sb.toString());
		
		
	}
	
	
}
