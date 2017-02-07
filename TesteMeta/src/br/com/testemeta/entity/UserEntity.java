package br.com.testemeta.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;


@Entity
public class UserEntity extends AbstractEntity{
	
	@TableGenerator(name="USER_GENERATOR",
            table="GENERATED_KEYS",
            pkColumnName="PK_COLUMN",
            valueColumnName="VALUE_COLUMN",
            pkColumnValue="USER_ID",
            allocationSize=1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="USER_GENERATOR")private int id;
	private String name;
	private String description;
	
	
	@ManyToOne
	private DepartmentEntity department;
	@ManyToMany(fetch=FetchType.EAGER)
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
