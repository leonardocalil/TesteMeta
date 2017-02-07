package br.com.testemeta.endpoint;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.testemeta.entity.UserEntity;
import br.com.testemeta.service.UserService;

@Path("/user")
public class Client {
	
		
	
	
	@POST
	@Path("Create")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean create(String json) {
		UserService service = new UserService();
		Gson gson = new Gson();
		UserEntity entity = gson.fromJson(json, UserEntity.class);

		try {
			service.save(entity);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}
	
	
	@GET
	@Path("Read/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserEntity get(@PathParam("id") String id) {
		
		UserService service = new UserService();
		UserEntity entity = null;
		try {
			entity = service.get(Integer.valueOf(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;

	}
	@GET
	@Path("All")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserEntity> all() {
		List<UserEntity> result = new ArrayList<UserEntity>();
		UserService service = new UserService();
		try {
			result = service.getAll();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	
	@POST
	@Path("Update")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean Update(String json) {
		UserService service = new UserService();
		Gson gson = new Gson();
		UserEntity entity = gson.fromJson(json, UserEntity.class);

		try {
			service.update(entity);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}
	@GET
	@Path("Delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@PathParam("id") String id) {
		UserService service = new UserService();
		try {
			service.remove(Integer.valueOf(id));
			return true;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
}
