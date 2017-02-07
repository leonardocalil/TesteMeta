package br.com.testemeta.service;

import java.util.List;

import br.com.testemeta.dao.PermissionDAO;
import br.com.testemeta.entity.PermissionEntity;

public class PermissionService {

	PermissionDAO dao = new PermissionDAO();
	
	/**
	 * Get all from database
	 * @return
	 * @throws Exception 
	 */
	public List<PermissionEntity> getAll() throws Exception{
		
		List<PermissionEntity> entityList = null;
		try {
			entityList = dao.getAll();
		} catch (Exception e) {
			throw e;
		}
		
		return entityList;
	}
	
	
	/**
	 * Get by Code
	 * @param code
	 * @return
	 */
	public PermissionEntity get(int code) throws Exception{
		
		PermissionEntity entity = null;
		try{
			entity = dao.get(code);			
		} catch(Exception e){
			throw e;
		}
		
		return entity;
	}
	
	/**
	 * Insert on database
	 * @param entity
	 * @throws Exception
	 */
	public void save(PermissionEntity entity) throws Exception{
		
		try{
			dao.begin();
			dao.save(entity);
			dao.commit();
			
		} catch(Exception e){
			dao.rollback();
			throw e;
		}
		
	}/**
	 * Update on database
	 * @param entity
	 * @throws Exception
	 */
	public void update(PermissionEntity entity) throws Exception{
		try{
			
			dao.begin();
			dao.update(entity);
			dao.commit();			
		
		} catch(Exception e){
			e.printStackTrace();
			dao.rollback();
			throw e;
		}
		
	}
	
	/**
	 * Remove entity
	 * @param entity
	 * @throws Exception
	 */
	public void remove(PermissionEntity entity) throws Exception{
		
		try{
			dao.begin();
			dao.remove(entity);
			dao.commit();
		} catch(Exception e){
			dao.rollback();
			throw e;
		}
	}
	
}
