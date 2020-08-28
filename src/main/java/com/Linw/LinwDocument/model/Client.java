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
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("Cliente: ").append(this.name).append("\n");
		sb.append("Cuil: ").append(this.cuit).append("\n");
		return (sb.toString());
		
		
	}
	
	
}
