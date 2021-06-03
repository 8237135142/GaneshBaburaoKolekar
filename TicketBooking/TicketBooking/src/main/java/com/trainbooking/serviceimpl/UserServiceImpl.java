package com.trainbooking.serviceimpl;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainbooking.dto.UserRequestDto;
import com.trainbooking.dto.UserResponseDto;
import com.trainbooking.exception.UserAlreadyExist;
import com.trainbooking.model.User;
import com.trainbooking.repository.UserRepository;
import com.trainbooking.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> allUsers()
	{
	
		return userRepository.findAll();
	}
	
	
	public UserResponseDto registerUser(UserRequestDto userRequestDto) throws UserAlreadyExist {
		
		User user=new User();
		BeanUtils.copyProperties(userRequestDto, user);
		
		try {
			List<User> userList=userRepository.findAll();
			for(User users : userList){
				if(!(users.getEmailId().equals(user.getEmailId())))
				{
					userRepository.save(user);
					
				}
				else
				{
					throw new UserAlreadyExist();
				}
			}
			
			
		} catch (ConstraintViolationException e) {
			throw new UserAlreadyExist("Email ID already exist...");
		}
		
		UserResponseDto userResponseDto = new UserResponseDto();
		BeanUtils.copyProperties(user, userResponseDto );
		
		return userResponseDto;
		
		
		
		
		/*List<User> users = userRepository.findAll();
		for(User user:users)
			if(user.getEmailId().equals(newUser.getEmailId()))
				return "User Already Exists";
			else
				 userRepository.save(newUser);
				return " User Registered";
			*/}
		
        
        
    
	
	public String editUserDetails(int userId, UserRequestDto userRequestDto)
	{
		User user = new User();
		BeanUtils.copyProperties(userRequestDto, user);
		 userRepository.save(user);
		 return "User Details Updated...";
	}

	public String deleteUser(int userId)
	{
		userRepository.deleteById(userId);
		return "User Details Deleted...";
	}
	
	public User login(String userName, String password)
	{
		User user = userRepository.findByUserNameAndPassword(userName, password);
		
		  
		  return user;
		
	}
	
	/*public boolean signIn(String userName, String password)
	{
		boolean flag=false;
		List<User> users=repository.findAll();
		for(User user:users)
		{
			if(user.getUserName().equals(userName) && user.getPassword().equals(password))
			{
				flag=true;
			}
		}
		return flag;
	}*/
}
