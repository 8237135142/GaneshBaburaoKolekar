package com.transfer.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transactions implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tid;
	private Date date;
	private String transectionType;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "account_aid", nullable = false)
	private Account account;

	public long getTransectinId() {
		return tid;
	}

	public void setTransectinId(long tid) {
		this.tid = tid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTransectionType() {
		return transectionType;
	}

	public void setTransectionType(String transectionType) {
		this.transectionType = transectionType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Transactions(Date date, String transectionType, Account account) {
		this.date = date;
		this.transectionType = transectionType;
		this.account = account;
	}

	public Transactions() {
		// TODO Auto-generated constructor stub
	}

}
