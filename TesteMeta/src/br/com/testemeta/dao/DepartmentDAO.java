package br.com.testemeta.dao;

import br.com.testemeta.entity.AbstractEntity;
import br.com.testemeta.entity.DepartmentEntity;

public class DepartmentDAO extends AbstractDAO<DepartmentEntity> {

	@Override
	protected Class<? extends AbstractEntity> entity() throws Exception {
		return DepartmentEntity.class;
	}
}