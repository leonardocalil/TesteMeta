package br.com.testemeta.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
@Entity
public class PermissionEntity extends AbstractEntity{
	@TableGenerator(name="PERMISSION_GENERATOR",
            table="GENERATED_KEYS",
            pkColumnName="PK_COLUMN",
            valueColumnName="VALUE_COLUMN",
            pkColumnValue="PERMISSION_ID",
            allocationSize=1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="PERMISSION_GENERATOR")	
	private int id;
	private String name;
	private String description;
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
