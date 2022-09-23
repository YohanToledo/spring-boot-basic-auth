package com.yohan.auth.dto;

import java.util.List;


import com.yohan.auth.models.RoleModel;
import com.yohan.auth.models.UserModel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	    private Long userId;	    
	    private String username;	    	    
	    private String fullName; 
	    private String email;
	    
	    private List<RoleModel> roles;
		
		public UserDTO(Long userId, String username, String password, String fullName, String email,
				List<RoleModel> roles) {
			super();
			this.userId = userId;
			this.username = username;
			this.fullName = fullName;
			this.email = email;
			this.roles = roles;
		}

		public UserDTO(UserModel userModel) {
			super();
			this.userId = userModel.getUserId();
			this.username = userModel.getUsername();
			this.fullName = userModel.getFullName();
			this.email = userModel.getEmail();
			this.roles = userModel.getRoles();
		}

		public UserDTO() {
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<RoleModel> getRoles() {
			return roles;
		}

		public void setRoles(List<RoleModel> roles) {
			this.roles = roles;
		}
		
}
