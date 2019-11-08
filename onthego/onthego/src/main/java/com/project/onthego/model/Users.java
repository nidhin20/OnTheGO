

package com.project.onthego.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Users {
	   @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="User_Id")
		private String id;
	
    	@Column(name="User_Nm")
	    private String name;
    	
    	@Column(name="Email")
	    private String email;
    	
    	@Column(name="Phone_Num")
	    private String phoneno;
    	
    	@Column(name="DOB")
    	private Date DOB;


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPhoneno() {
			return phoneno;
		}


		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
		}


		public Date getDOB() {
			return DOB;
		}


		public void setDOB(Date dOB) {
			DOB = dOB;
		}
    	
    	
		
}