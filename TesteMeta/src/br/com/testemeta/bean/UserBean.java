package br.com.testemeta.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.testemeta.entity.DepartmentEntity;
import br.com.testemeta.entity.PermissionEntity;
import br.com.testemeta.entity.UserEntity;
import br.com.testemeta.service.DepartmentService;
import br.com.testemeta.service.PermissionService;
import br.com.testemeta.service.UserService;


@ManagedBean
@RequestScoped
public class UserBean extends AbstractBean<UserEntity> {
	
	UserService service = new UserService();
	PermissionService pservice = new PermissionService();
	DepartmentService dservice = new DepartmentService();
	
	List<DepartmentEntity> departments = dservice.getAll();
	List<PermissionEntity> permissions = pservice.getAll();
	
	int department_id =0;
	List<String> permission_ids = new ArrayList<String>();
	
	
	
	public int getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}


	public List<String> getPermission_ids() {
		return permission_ids;
	}


	public void setPermission_ids(List<String> permission_ids) {
		this.permission_ids = permission_ids;
	}


	public List<DepartmentEntity> getDepartments() {
		return departments;
	}


	public void setDepartments(List<DepartmentEntity> departments) {
		this.departments = departments;
	}


	public List<PermissionEntity> getPermissions() {
		return permissions;
	}


	public void setPermissions(List<PermissionEntity> permissions) {
		this.permissions = permissions;
	}


	public UserBean() throws Exception {
		init();
	}
	
	
	@Override
	protected Class<UserEntity> entity() {
		return UserEntity.class;
	}

	@Override
	public String newPage() {
		
		return "userNew.xhtml";
	}


	@Override
	public String back() {
		return "user.xhtml";
	}

	@Override
	protected String update() throws Exception {
		
		try {
			service.update(newObject);
			

			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, newObject.getClass().getSimpleName()+" was updated!", 
							null));
			
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error "+e.getMessage(), null));
			
		}
			
		init();
			
		return "user.xhtml";
	}

	@Override
	public String remove() {
		try {
			service.remove(selected);
			
		
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, selected.getClass().getSimpleName()+" was removed!", 
							null));
			
			init();
		}catch(Exception e){

			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error "+e.getMessage(), 
							null));
		}
			
		
		return "";
	}

	@Override
	public String save() throws Exception {

		try {
			
			newObject.setDepartment(dservice.get(department_id));
			List<PermissionEntity> permissions = new ArrayList<PermissionEntity>();
			
			for(String permissionId : permission_ids) {
				PermissionEntity entity = pservice.get(Integer.valueOf(permissionId));
				permissions.add(entity);
			}
			newObject.setPermissions(permissions);
			if (newObject.getId() != 0) {
				return update();
			}
			
			service.save(newObject);
			
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, newObject.getClass().getSimpleName()+" was saved!", 
							null));
			
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error - "+e.getMessage(), 
							null));
		}
			
		init();
			
		return "user.xhtml";
	}

	@Override
	protected void init() throws Exception {
		data = service.getAll();
		for(UserEntity user : data) {
			if(user.getPermissions() != null) {
				System.out.println("qtPermission: "+user.getPermissions().size());
			}
			
		}
		newObject = new UserEntity();
		department_id =0;
		permission_ids = new ArrayList<String>();
		
	}
	
	
	@Override
	public String editPage() {
		try {
			newObject = (UserEntity) service.get(newObject.getId());
			department_id = 0;
			permission_ids = new ArrayList<String>();
			if(newObject.getDepartment() != null) {
				department_id = newObject.getDepartment().getId();
			}
			if(newObject.getPermissions() !=null) {
				for(PermissionEntity permission : newObject.getPermissions()) {
					permission_ids.add(String.valueOf(permission.getId()));
				}
			}
			
			
			
		} catch (final Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Error "+e.getMessage(), 
							null));
		}

		return "userNew.xhtml";
	}


	@Override
	public void onRowUpdate(RowEditEvent event) {
		// TODO Auto-generated method stub
		
	}
	
 
}
