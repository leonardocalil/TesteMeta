package br.com.testemeta.entity;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class UserEntity {
	@ManyToOne
	private DepartmentEntity department;
	@ManyToMany
	private List<PermissionEntity> permissions;
	public DepartmentEntity getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
	public List<PermissionEntity> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<PermissionEntity> permissions) {
		this.permissions = permissions;
	}
	
	
}
