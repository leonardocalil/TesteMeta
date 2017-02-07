package br.com.testemeta.dao;

import br.com.testemeta.entity.AbstractEntity;
import br.com.testemeta.entity.PermissionEntity;

public class PermissionDAO extends AbstractDAO<PermissionEntity> {

	@Override
	protected Class<? extends AbstractEntity> entity() throws Exception {
		return PermissionEntity.class;
	}
}