package org.homecontrolweb.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Transaction {
	@Id
	@Column(columnDefinition="CHAR(36)")
	private String id;
	private String type;
	private BigDecimal value;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Calendar date;
	private String category;
	private String paymentMode;
	private boolean active;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Calendar dateModified;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Calendar getDateModified() {
		return dateModified;
	}
	
	public void setDateModified(Calendar dateModified) {
		this.dateModified = dateModified;
	}
	
	public void modified() {
		this.dateModified = Calendar.getInstance();
	}
				
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", type=" + type + ", value=" + value + ", date=" + date + ", category="
				+ category + ", paymentMode=" + paymentMode + "]";
	}
}
