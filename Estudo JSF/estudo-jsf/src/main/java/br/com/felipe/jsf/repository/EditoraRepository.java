package br.com.felipe.jsf.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import br.com.felipe.jsf.entity.EditoraEntity;
import br.com.felipe.jsf.model.EditoraModel;
import br.com.felipe.jsf.util.Util;

public class EditoraRepository {
	
	EditoraEntity editoraEntity = new EditoraEntity();
	
	EntityManager entityManager;
	
	public void salvarNovoRegistro(EditoraModel editoraModel) {
		entityManager = Util.jpaEntityManager();
		
		editoraEntity = new EditoraEntity();
		editoraEntity.setNome(editoraModel.getNome());
		editoraEntity.setCnpj(editoraModel.getCnpj());
		
		entityManager.persist(editoraEntity);
	}
	
	public List<EditoraModel> getEditoras() {
		List<EditoraModel> editoras = new ArrayList<EditoraModel>();
		
		entityManager = Util.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("EditoraEntity.findAll");
		
		@SuppressWarnings("unchecked")
		Collection<EditoraEntity> editorasEntity = (Collection<EditoraEntity>)query.getResultList();
		
		EditoraModel editoraModel = null;
		
		for (EditoraEntity editoraEntity : editorasEntity) {
			editoraModel = new EditoraModel();
			editoraModel.setCodigo(editoraEntity.getCodigo());
			editoraModel.setNome(editoraEntity.getNome());
			editoraModel.setCnpj(editoraEntity.getCnpj());
			
			editoras.add(editoraModel);
		}
		return editoras;
	}
	
	//LISTAR ORDENADA POR NOME
	public List<EditoraModel> getEditorasOrdenada() {
		List<EditoraModel> editoras = new ArrayList<EditoraModel>();
		
		entityManager = Util.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("EditoraEntity.byName");
		
		@SuppressWarnings("unchecked")
		Collection<EditoraEntity> editorasEntity = (Collection<EditoraEntity>)query.getResultList();
		
		EditoraModel editoraModel = null;
		
		for (EditoraEntity editoraEntity : editorasEntity) {
			editoraModel = new EditoraModel();
			editoraModel.setCodigo(editoraEntity.getCodigo());
			editoraModel.setNome(editoraEntity.getNome());
			editoraModel.setCnpj(editoraEntity.getCnpj());
			
			editoras.add(editoraModel);
		}
		return editoras;
	}
	
	
	//CONSULTA UM REGISTRO CADASTRADO PELO CÓDIGO PARA USAR NA EDIÇÃO
	private EditoraEntity getEditora(int codigo) {
		entityManager = Util.jpaEntityManager();
		
		return entityManager.find(EditoraEntity.class, codigo);
	}
	
	//ALETAR UM REGISTRO CADASTRADO NO BANCO DE DADOS
	public void alterarRegistro(EditoraModel editoraModel) {
		entityManager = Util.jpaEntityManager();
		
		EditoraEntity editoraEntity = this.getEditora(editoraModel.getCodigo());
		
		editoraEntity.setNome(editoraModel.getNome());
		editoraEntity.setCnpj(editoraModel.getCnpj());
		
		entityManager.merge(editoraEntity);
	}
	
	//EXCLUI UM REGISTRO DO BANCO DE DADOS

	public void excluirRegistro(int codigo) {
		entityManager = Util.jpaEntityManager();
		
		EditoraEntity editoraEntity = this.getEditora(codigo);
		
		entityManager.remove(editoraEntity);
	}

	public List<EditoraModel> getEditorasFiltro(String q) {
		List<EditoraModel> editorasFiltro = new ArrayList<>();
		
		entityManager = Util.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("EditoraEntity.likeName").setParameter("nome", "%"+q+"%");
		
		@SuppressWarnings("unchecked")
		Collection<EditoraEntity> editorasEntity = (Collection<EditoraEntity>)query.getResultList();
		
		EditoraModel editoraModel = null;
		
		for (EditoraEntity editoraEntity : editorasEntity) {
			editoraModel = new EditoraModel();
			editoraModel.setCodigo(editoraEntity.getCodigo());
			editoraModel.setNome(editoraEntity.getNome());
			editoraModel.setCnpj(editoraEntity.getCnpj());
			
			editorasFiltro.add(editoraModel);
		}
		return editorasFiltro;
	}
	
}
