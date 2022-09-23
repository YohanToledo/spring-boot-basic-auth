package com.yohan.auth.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yohan.auth.dto.UserDTO;
import com.yohan.auth.models.UserModel;
import com.yohan.auth.services.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping("/{username}")
	public ResponseEntity<UserDTO> findOne(@PathVariable String username) {
		UserDTO userDTO = userService.findUserByUsername(username);
		if(userDTO != null) {
			return ResponseEntity.ok(userDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping("/id")
	public ResponseEntity<UserDTO> findOne(@Param(value = "id") Long id) {
		UserDTO userDTO = userService.findById(id);
		if(userDTO != null) {
			return ResponseEntity.ok(userDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	//@PreAuthorize("permitAll()")
	@PostMapping("/create")
	public ResponseEntity<UserDTO> create(@RequestBody UserModel user) {
		UserDTO userDTO = userService.create(user);
		return ResponseEntity.ok(userDTO);
	}
	
}
