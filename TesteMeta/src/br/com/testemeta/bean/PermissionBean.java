package br.com.testemeta.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.testemeta.entity.PermissionEntity;
import br.com.testemeta.service.PermissionService;


@ManagedBean
@SessionScoped
public class PermissionBean extends AbstractBean<PermissionEntity> {
	
	PermissionService service = new PermissionService();
		
	public PermissionBean() throws Exception {
		init();
	}
	
	
	@Override
	protected Class<PermissionEntity> entity() {
		return PermissionEntity.class;
	}

	@Override
	public String newPage() {
		return "permissionNew.xhtml";
	}


	@Override
	public String back() {
		return "permission.xhtml";
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
			
		return "permission.xhtml";
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
					new FacesMessage(FacesMessage.SEVERITY_WARN, "There are User(s) using this permission", 
							null));
		}
			
		
		return "";
	}

	@Override
	public String save() throws Exception {

		try {
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
			
		return "permission.xhtml";
	}

	@Override
	protected void init() throws Exception {
		data = service.getAll();
		newObject = new PermissionEntity();
	}
	
	
	@Override
	public String editPage() {
		try {
			newObject = (PermissionEntity) service.get(newObject.getId());
		} catch (final Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Error "+e.getMessage(), 
							null));
		}

		return "permissionNew.xhtml";
	}


	@Override
	public void onRowUpdate(RowEditEvent event) {
		// TODO Auto-generated method stub
		
	}
	
 
}
