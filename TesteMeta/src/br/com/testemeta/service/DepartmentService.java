package br.com.testemeta.service;

import java.util.List;

import br.com.testemeta.dao.DepartmentDAO;
import br.com.testemeta.entity.DepartmentEntity;

public class DepartmentService {

	DepartmentDAO dao = new DepartmentDAO();
	
	/**
	 * Get all from database
	 * @return
	 * @throws Exception 
	 */
	public List<DepartmentEntity> getAll() throws Exception{
		
		List<DepartmentEntity> entityList = null;
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
	public DepartmentEntity get(int code) throws Exception{
		
		DepartmentEntity entity = null;
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
	public void save(DepartmentEntity entity) throws Exception{
		
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
	public void update(DepartmentEntity entity) throws Exception{
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
	public void remove(DepartmentEntity entity) throws Exception{
		
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
