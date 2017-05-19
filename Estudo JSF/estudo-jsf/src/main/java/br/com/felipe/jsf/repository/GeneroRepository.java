package br.com.felipe.jsf.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.felipe.jsf.entity.GeneroEntity;
import br.com.felipe.jsf.model.GeneroModel;
import br.com.felipe.jsf.util.Util;

public class GeneroRepository {

	GeneroEntity generoEntity = new GeneroEntity();
	
	EntityManager entityManager;
	
	public void salvarNovoRegistro(GeneroModel generoModel) {
		
		entityManager = Util.jpaEntityManager();
		
		generoEntity = new GeneroEntity();
		generoEntity.setNome(generoModel.getNome());
		
		entityManager.persist(generoEntity);
		
	}
	
	//METODO PARA CONSULTAR
	public List<GeneroModel> getGeneros() {
		List<GeneroModel> generos = new ArrayList<GeneroModel>();
		
		entityManager = Util.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("GeneroEntity.findAll");
		
		@SuppressWarnings("unchecked")
		Collection<GeneroEntity> generosEntity = (Collection<GeneroEntity>)query.getResultList();
		
		GeneroModel generoModel = null;
		
		for (GeneroEntity generoEntity : generosEntity) {
			
			generoModel = new GeneroModel();
			generoModel.setCodigo(generoEntity.getCodigo());
			generoModel.setNome(generoEntity.getNome());
			
			generos.add(generoModel);
			
		}
		
		return generos;
	}
	
	//LISTA ORDENADA POR NOME
	public List<GeneroModel> getGenerosOrdenado() {
		List<GeneroModel> generos = new ArrayList<GeneroModel>();
		
		entityManager = Util.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("GeneroEntity.byName");
		
		@SuppressWarnings("unchecked")
		Collection<GeneroEntity> generosEntity = (Collection<GeneroEntity>)query.getResultList();
		
		GeneroModel generoModel = null;
		
		for (GeneroEntity generoEntity : generosEntity) {
			
			generoModel = new GeneroModel();
			generoModel.setCodigo(generoEntity.getCodigo());
			generoModel.setNome(generoEntity.getNome());
			
			generos.add(generoModel);
			
		}
		
		return generos;
	}
	
	//CONSULTA UM REGISTRO CADASTRADO PELO CÓDIGO
	private GeneroEntity getGenero(int codigo) {
		entityManager = Util.jpaEntityManager();
		
		return entityManager.find(GeneroEntity.class, codigo);
	}
	
	//ALTERAR UM REGISTRO CADASTRADO NO BANCO DE DADOS
	public void alterarRegistro(GeneroModel generoModel) {
		entityManager = Util.jpaEntityManager();
		
		GeneroEntity generoEntity = this.getGenero(generoModel.getCodigo());
		
		generoEntity.setNome(generoModel.getNome());
		
		entityManager.merge(generoEntity);
	}
	
	//EXCLUI UM REGISTRO DO BANCO DE DADOS
	public void excluirRegistro(int codigo) {
		entityManager = Util.jpaEntityManager();
		
		GeneroEntity generoEntity = this.getGenero(codigo);
		
		entityManager.remove(generoEntity);
	}

	public List<GeneroModel> getGenerosFiltro(String q) {
		List<GeneroModel> generosFiltro = new ArrayList<>();
		
		entityManager = Util.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("GeneroEntity.likeName").setParameter("nome", "%"+q+"%");
		
		@SuppressWarnings("unchecked")
		Collection<GeneroEntity> generosEntity = (Collection<GeneroEntity>)query.getResultList();
		
		GeneroModel generoModel = null;
		
		for (GeneroEntity generoEntity : generosEntity) {
			
			generoModel = new GeneroModel();
			generoModel.setCodigo(generoEntity.getCodigo());
			generoModel.setNome(generoEntity.getNome());
			
			generosFiltro.add(generoModel);
			
		}
		
		return generosFiltro;
	}
	
}
