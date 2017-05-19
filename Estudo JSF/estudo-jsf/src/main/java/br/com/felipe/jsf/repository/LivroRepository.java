package br.com.felipe.jsf.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.felipe.jsf.entity.AutorEntity;
import br.com.felipe.jsf.entity.EditoraEntity;
import br.com.felipe.jsf.entity.GeneroEntity;
import br.com.felipe.jsf.entity.LivroEntity;
import br.com.felipe.jsf.model.AutorModel;
import br.com.felipe.jsf.model.EditoraModel;
import br.com.felipe.jsf.model.GeneroModel;
import br.com.felipe.jsf.model.LivroModel;
import br.com.felipe.jsf.util.Classe;
import br.com.felipe.jsf.util.Util;

public class LivroRepository {

	LivroEntity livroEntity = new LivroEntity();
	
	private GeneroEntity generoEntity;
	private EditoraEntity editoraEntity;
	private AutorEntity autorEntity;
	
	EntityManager entityManager;
	
	public void salvarNovoRegistro(LivroModel livroModel) {
		
		
		entityManager = Util.jpaEntityManager();
		
		livroEntity = new LivroEntity();
		livroEntity.setDataCadastro(LocalDateTime.now());
		livroEntity.setTitulo(livroModel.getTitulo());
		livroEntity.setIsbn(livroModel.getIsbn());
		livroEntity.setNumeroPaginas(livroModel.getNumeroPaginas());
		livroEntity.setDescricao(livroModel.getDescricao());
		
		generoEntity = entityManager.find(GeneroEntity.class, livroModel.getGeneroModel().getCodigo());
		editoraEntity = entityManager.find(EditoraEntity.class, livroModel.getEditoraModel().getCodigo());
		autorEntity = entityManager.find(AutorEntity.class, livroModel.getAutorModel().getCodigo());
		
		livroEntity.setGeneroEntity(generoEntity);
		livroEntity.setEditoraEntity(editoraEntity);
		livroEntity.setAutorEntity(autorEntity);
		
		
		entityManager.persist(livroEntity);
		
		
	}
	
	public List<LivroModel> getLivros() {
		
		List<LivroModel> livros = new ArrayList<LivroModel>();
		
		entityManager = Util.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("LivroEntity.findAll");
		
		@SuppressWarnings("unchecked")
		Collection<LivroEntity> livrosEntity = (Collection<LivroEntity>)query.getResultList();
		
		LivroModel livroModel = null;
		
		for (LivroEntity livroEntity : livrosEntity) {
			livroModel = new LivroModel();
			livroModel.setCodigo(livroEntity.getCodigo());
			livroModel.setTitulo(livroEntity.getTitulo());
			livroModel.setDataCadastro(livroEntity.getDataCadastro());
			livroModel.setIsbn(livroEntity.getIsbn());
			livroModel.setNumeroPaginas(livroEntity.getNumeroPaginas());
			livroModel.setDescricao(livroEntity.getDescricao());
			
			AutorEntity autorEntity = livroEntity.getAutorEntity();
			EditoraEntity editoraEntity = livroEntity.getEditoraEntity();
			GeneroEntity generoEntity = livroEntity.getGeneroEntity();
			
			AutorModel autorModel = new AutorModel();
			EditoraModel editoraModel = new EditoraModel();
			GeneroModel generoModel = new GeneroModel();
			
			autorModel.setNome(autorEntity.getNome());
			editoraModel.setNome(editoraEntity.getNome());
			generoModel.setNome(generoEntity.getNome());
			
			livroModel.setAutorModel(autorModel);
			livroModel.setEditoraModel(editoraModel);
			livroModel.setGeneroModel(generoModel);
			
			livros.add(livroModel);
			
		}
		return livros;
		
	}
	
	public void alterarRegistro(LivroModel livroModel) {
		
		entityManager = Util.jpaEntityManager();
		
		LivroEntity livroEntity = this.getLivro(livroModel.getCodigo());
		
		
		livroEntity.setTitulo(livroModel.getTitulo());
		livroEntity.setIsbn(livroModel.getIsbn());
		livroEntity.setNumeroPaginas(livroModel.getNumeroPaginas());
		livroEntity.setDescricao(livroModel.getDescricao());

		System.out.println(livroModel.toString());
		
		generoEntity = entityManager.find(GeneroEntity.class, livroModel.getGeneroModel().getCodigo());
		editoraEntity = entityManager.find(EditoraEntity.class, livroModel.getEditoraModel().getCodigo());
		autorEntity = entityManager.find(AutorEntity.class, livroModel.getAutorModel().getCodigo());
		
		livroEntity.setGeneroEntity(generoEntity);
		livroEntity.setEditoraEntity(editoraEntity);
		livroEntity.setAutorEntity(autorEntity);
		
		entityManager.merge(livroEntity);
		
	}
	
	public LivroEntity getLivro(int codigo) {
		entityManager = Util.jpaEntityManager();
		
		return entityManager.find(LivroEntity.class, codigo);
	}
	
	public void excluirRegistro(int codigo){
		entityManager = Util.jpaEntityManager();
		
		LivroEntity livroEntity = this.getLivro(codigo);
		
		entityManager.remove(livroEntity);
	}

	
	
}
