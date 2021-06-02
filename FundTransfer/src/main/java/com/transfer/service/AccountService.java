package com.transfer.service;

public interface AccountService {

	public boolean fromAccount(long sourceAccNo, double amount);

	public boolean toAccount(long dedestAccNo, double amount);

	public boolean fundTrnasfer(long sourceAccNo, long dedestAccNo, double amount);

}
