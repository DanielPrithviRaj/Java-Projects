package com.alert.serviceImpl;

import org.springframework.stereotype.Service;

import com.alert.entity.User;
import com.alert.repository.UserRepository;
import com.alert.serviceInterface.UserService;

@Service														//Step 1 @Service 
public class UserServiceImpl implements UserService {			//Step 2 Class declaration(implements service) 
	
		private final UserRepository userRepository;			//Step 3 Repository declaration
		
		public UserServiceImpl(UserRepository userRepository) { //Step 4 Constructor Injection
				this.userRepository = userRepository;
		}
		
		public User createUser(User user) {
			return userRepository.save(user);				//
		}
}
 