package br.com.felipe.jsf.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.felipe.jsf.entity.AutorEntity;
import br.com.felipe.jsf.model.AutorModel;
import br.com.felipe.jsf.util.Util;

public class AutorRepository {
	
	
	
	EntityManager entityManager;
	
	public void salvarNovoRegistro(AutorModel autorModel) {
		
		entityManager = Util.jpaEntityManager();
		
	 AutorEntity autorEntity = new AutorEntity();
	 autorEntity.setNome(autorModel.getNome());
	 autorEntity.setSexo(autorModel.getSexo());
	 
	 entityManager.persist(autorEntity);
		
	}
	
	//METODO PARA CONSULTAR AUTOR
	public List<AutorModel> getAutores() {
		List<AutorModel> autores = new ArrayList<AutorModel>();
		
		entityManager = Util.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("AutorEntity.findAll");
		
		@SuppressWarnings("unchecked")
		Collection<AutorEntity> autoresEntity = (Collection<AutorEntity>)query.getResultList();
		
		AutorModel autorModel = null;
		
		for (AutorEntity autorEntity : autoresEntity) {
			autorModel = new AutorModel();
					
			autorModel.setCodigo(autorEntity.getCodigo());
			autorModel.setNome(autorEntity.getNome());
			if(autorEntity.getSexo().equals("M")) {
				autorModel.setSexo("Masculino");
			} else {
				autorModel.setSexo("Feminino");
			}
			
			autores.add(autorModel);
		}
		
		return autores;
		
	}
	

	public List<AutorModel> getAutoresFiltro(String q) {
		List<AutorModel> autoresFiltro = new ArrayList<>();
		
		entityManager = Util.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("AutorEntity.likeName").setParameter("nome", "%"+q+"%");
		
		@SuppressWarnings("unchecked")
		Collection<AutorEntity> autoresEntity = (Collection<AutorEntity>)query.getResultList();
		
		AutorModel autorModel = null;
		
		for (AutorEntity autorEntity : autoresEntity) {
			autorModel = new AutorModel();
			
			autorModel.setCodigo(autorEntity.getCodigo());
			autorModel.setNome(autorEntity.getNome());
			if(autorEntity.getSexo().equals("M")) {
				autorModel.setSexo("Masculino");
			} else {
				autorModel.setSexo("Feminino");
			}
			
			autoresFiltro.add(autorModel);
		}
		
		return autoresFiltro;
		}

	//METODO PARA CONSULTAR AUTOR ORDENADOS POR NOME
	public List<AutorModel> getAutoresOrdenado() {
		List<AutorModel> autores = new ArrayList<AutorModel>();
		
		entityManager = Util.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("AutorEntity.byName");
		
		@SuppressWarnings("unchecked")
		Collection<AutorEntity> autoresEntity = (Collection<AutorEntity>)query.getResultList();
		
		AutorModel autorModel = null;
		
		for (AutorEntity autorEntity : autoresEntity) {
			autorModel = new AutorModel();
					
			autorModel.setCodigo(autorEntity.getCodigo());
			autorModel.setNome(autorEntity.getNome());
			if(autorEntity.getSexo().equals("M")) {
				autorModel.setSexo("Masculino");
			} else {
				autorModel.setSexo("Feminino");
			}
			
			autores.add(autorModel);
		}
		
		return autores;
		
	}
	
	//CONSULTA UMA PESSOA CADASTRADA PELO CÓDIGO
	//@param codigo
	//@return
	private AutorEntity getAutor(int codigo) {
		entityManager = Util.jpaEntityManager();
		
		return entityManager.find(AutorEntity.class, codigo);
	}

	//ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	//@param autorModel
	public void alterarRegistro(AutorModel autorModel) {
		
		entityManager = Util.jpaEntityManager();
		
		AutorEntity autorEntity = this.getAutor(autorModel.getCodigo());
		
		autorEntity.setNome(autorModel.getNome());
		autorEntity.setSexo(autorModel.getSexo());
		
		entityManager.merge(autorEntity);
		
	}

	public void excluirRegistro(Integer codigo) {
		entityManager = Util.jpaEntityManager();
		
		AutorEntity autorEntity = this.getAutor(codigo);
		
		entityManager.remove(autorEntity);
	}


	
	
	
}
