package com.yohan.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yohan.auth.dto.UserDTO;
import com.yohan.auth.models.UserModel;
import com.yohan.auth.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserDTO findUserByUsername(String username) {
		Optional<UserModel> userModel = userRepo.findByUsername(username);
		if(userModel.isEmpty()) {
			return null;
		}
		return new UserDTO(userModel.get());
	}
	
	public UserDTO findById(Long id) {
		Optional<UserModel> userModel = userRepo.findById(id);
		if(userModel.isEmpty()) {
			return null;
		}
		return new UserDTO(userModel.get());	
	}
	
	public UserDTO create(UserModel user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserModel userModel = userRepo.save(user);
		return new UserDTO(userModel);
	}
	
}
