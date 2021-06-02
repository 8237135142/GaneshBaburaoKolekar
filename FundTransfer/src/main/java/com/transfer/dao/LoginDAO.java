package com.transfer.dao;

import com.transfer.bo.UserBO;

public interface LoginDAO {
	public UserBO validate(String userName, String userPassword);
}
