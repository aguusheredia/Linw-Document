/**
 * 
 */
package com.Linw.LinwDocument.model;

/**
 * @author AguusHeredia
 *
 */
public class Client {

	String cuil;
	String name;

	
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
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
		sb.append("Cuil: ").append(this.cuil).append("\n");
		return (sb.toString());
		
		
	}
	
	
}
