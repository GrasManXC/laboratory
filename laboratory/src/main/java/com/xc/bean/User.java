package com.xc.bean;

public class User {
    private Integer userId;

    private String username;

    private String password;

    private String role;

    private String email;

    private String gender;



	public User(Integer userId, String username, String password, String role, String email, String gender) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.gender = gender;
	}

	public User() {
		super();
	}

    
	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", email=" + email + ", gender=" + gender + "]";
	}
    
	
    
}