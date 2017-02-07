package br.com.testemeta.bean;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import br.com.testemeta.entity.AbstractEntity;

/**
 * Classe que representa todos os crud do sistema.
 * 
 * 
 * @param <T>
 */
public abstract class AbstractBean<T extends AbstractEntity> {

	/**
	 * Toda classe que herdar esta classe, deve dizer quem eh seu dto.
	 * 
	 * @return
	 */
	protected abstract Class<T> entity();


	/**
	 * Representa os dados da grid.
	 * 
	 * 
	 */
	protected List<T> data;

	/**
	 * Representa uma linha selecionada.
	 */
	protected T selected;

	/**
	 * Representa um objeto novo sendo criado ou um objeto sendo alterado.
	 */
	protected T newObject;

	/**
	 * Representa o objeto de pesquisa
	 */
	protected T find;

	protected String size;


	protected abstract void init() throws Exception;

	/**
	 * Retorna uma p�gina de cadastro de um novo objeto.
	 * 
	 * @return
	 */
	public abstract String newPage() throws Exception ;

	/**
	 * Retorna uma p�gina de alteracao cadastro de um objeto existente.
	 * 
	 * @return
	 */
	public abstract String editPage() throws Exception;
	/**
	 * Sai da tela de cadastro e volta para a grid.
	 * 
	 * @return
	 */
	public abstract String back() throws Exception;

	/**
	 * Realiza a altera��o dos dados da grid.
	 * 
	 */
	protected abstract String update() throws Exception ;

	/**
	 * Realiza a remo��o de um item da grid.
	 * 
	 * @return
	 */
	public abstract String remove() throws Exception;

	/**
	 * Salva o objeto novo da tela de cadastro.
	 * 
	 * @return
	 */
	public abstract String save() throws Exception;

	
	public void setData(List<T> data) {
		this.data = data;
	}

	public List<T> getData() {
		return data;
	}

	public void setSelected(T selected) {
		this.selected = selected;
	}

	public T getSelected() {
		return selected;
	}

	public void setNewObject(T newObject) {
		this.newObject = newObject;
	}

	public T getNewObject() {
		return newObject;
	}

	public void setFind(T find) {
		this.find = find;
	}

	public T getFind() {
		return find;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSize() {
		return size;
	}
	
	public abstract void onRowUpdate(RowEditEvent event);
}