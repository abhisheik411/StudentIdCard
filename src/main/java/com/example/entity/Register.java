package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="register")
public class Register {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	private String name;
	private String email;
//	private String password;
	private long student_id;
	 private String collage;
	 private long phone;
	 private String branch;
	public Register(long id, String name, String email, long student_id, String collage, long phone, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.student_id = student_id;
		this.collage = collage;
		this.phone = phone;
		this.branch = branch;
	}
	public Register() {
		super();
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public long getStudent_id() {
		return student_id;
	}
	public String getCollage() {
		return collage;
	}
	public long getPhone() {
		return phone;
	}
	public String getBranch() {
		return branch;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}
	public void setCollage(String collage) {
		this.collage = collage;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", email=" + email + ", student_id=" + student_id
				+ ", collage=" + collage + ", phone=" + phone + ", branch=" + branch + "]";
	}


	
	
	
	
	
}
