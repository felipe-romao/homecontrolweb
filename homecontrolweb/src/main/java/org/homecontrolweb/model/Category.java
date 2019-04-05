package org.homecontrolweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@Column(columnDefinition="CHAR(36)")
	private String id;
	private String description;
	private String typeMovement;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTypeMovement() {
		return typeMovement;
	}
	public void setTypeMovement(String typeMovement) {
		this.typeMovement = typeMovement;
	}
}
