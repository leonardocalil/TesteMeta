package br.com.testemeta.service;

import java.util.List;

import br.com.testemeta.dao.UserDAO;
import br.com.testemeta.entity.UserEntity;

public class UserService {

	UserDAO dao = new UserDAO();
	
	/**
	 * Get all from database
	 * @return
	 * @throws Exception 
	 */
	public List<UserEntity> getAll() throws Exception{
		
		List<UserEntity> entityList = null;
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
	public UserEntity get(int code) throws Exception{
		
		UserEntity entity = null;
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
	public void save(UserEntity entity) throws Exception{
		
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
	public void update(UserEntity entity) throws Exception{
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
	public void remove(UserEntity entity) throws Exception{
		
		try{
			dao.begin();
			dao.remove(entity);
			dao.commit();
		} catch(Exception e){
			dao.rollback();
			throw e;
		}
	}
	public void remove(int id) throws Exception{
		
		UserEntity entity = dao.get(id);
		remove(entity);
		
	}
	
}
