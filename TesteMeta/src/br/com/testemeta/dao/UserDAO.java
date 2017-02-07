package br.com.testemeta.dao;

import br.com.testemeta.entity.AbstractEntity;
import br.com.testemeta.entity.UserEntity;

public class UserDAO extends AbstractDAO<UserEntity> {

	@Override
	protected Class<? extends AbstractEntity> entity() throws Exception {
		return UserEntity.class;
	}
}