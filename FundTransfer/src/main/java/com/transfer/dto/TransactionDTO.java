package com.transfer.dto;

public class TransactionDTO {
	
	private long transectinId;
	private String date;
	private String transectionType;

	
	private AccountDTO account;

	public long getTransectinId() {
		return transectinId;
	}

	public void setTransectinId(long transectinId) {
		this.transectinId = transectinId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTransectionType() {
		return transectionType;
	}

	public void setTransectionType(String transectionType) {
		this.transectionType = transectionType;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

}
