package com.anxpp.demo.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * 
 * @author anxpp.com
 *
 */
@Entity
@Table(name="DEMO_User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	public User(){}
	public User(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return "{id:" + id + ",name:" + name + "}";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
