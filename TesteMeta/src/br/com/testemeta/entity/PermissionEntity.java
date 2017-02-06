package br.com.testemeta.entity;

import java.util.List;

import javax.persistence.ManyToMany;

public class PermissionEntity {
	@ManyToMany
	private List<UserEntity> users;

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
}
