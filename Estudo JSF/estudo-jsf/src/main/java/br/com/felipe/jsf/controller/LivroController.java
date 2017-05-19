package br.com.felipe.jsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.felipe.jsf.model.AutorModel;
import br.com.felipe.jsf.model.EditoraModel;
import br.com.felipe.jsf.model.GeneroModel;
import br.com.felipe.jsf.model.LivroModel;
import br.com.felipe.jsf.repository.AutorRepository;
import br.com.felipe.jsf.repository.EditoraRepository;
import br.com.felipe.jsf.repository.GeneroRepository;
import br.com.felipe.jsf.repository.LivroRepository;
import br.com.felipe.jsf.util.Util;

@ManagedBean(name="livroController")
@ViewScoped
public class LivroController implements Serializable{

	private static final long serialVersionUID = 1L;

	private LivroModel livroModel = new LivroModel();
	
	private LivroRepository livroRepository = new LivroRepository();
	
	private List<LivroModel> livros = new ArrayList<LivroModel>();
	
	private GeneroModel generoModel;
	private EditoraModel editoraModel;
	private AutorModel autorModel;
	
	private AutorModel autorComplete = new AutorModel();
	private EditoraModel editoraComplete = new EditoraModel();
	private GeneroModel generoComplete = new GeneroModel();
	
	private AutorRepository autorRepository = new AutorRepository();
	private EditoraRepository editoraRepository = new EditoraRepository();
	private GeneroRepository generoRepository = new GeneroRepository();
	
	private List<AutorModel> autoresNovo = new ArrayList<>(); 
	private List<EditoraModel> editorasNovo = new ArrayList<>();
	private List<GeneroModel> generosNovo = new ArrayList<>();
	
	
/*	public List<SelectItem> getAutores() {
		if(autores == null) {
			autores = new ArrayList<SelectItem>();
			
			AutorRepository autorRepository = new AutorRepository();
			
			List<AutorModel> listaAutores = autorRepository.getAutoresOrdenado();
			
			if(listaAutores != null && !listaAutores.isEmpty()) {
				SelectItem item;
				
				for (AutorModel autorModel : listaAutores) {
					item = new SelectItem(autorModel, autorModel.getCodigo().toString());
					autores.add(item);
				}
			}
		}
		return autores;
	}
*/
		
	//CARREGA OS REGISTROS NA INICIALIZAÇÃO
		@PostConstruct
		public void init() {
			//RETORNAS OS REGISTROS
			this.livros = livroRepository.getLivros();
		}
		
		public List<AutorModel> completeTextAutor(String query) {
			autoresNovo = autorRepository.getAutoresFiltro(query);
			return autoresNovo;
	    }
		public List<EditoraModel> completeTextEditora(String query) {
			editorasNovo = editoraRepository.getEditorasFiltro(query);
			return editorasNovo;
	    }
		public List<GeneroModel> completeTextGenero(String query) {
			generosNovo = generoRepository.getGenerosFiltro(query);
			return generosNovo;
	    }
		
		public void editar(LivroModel livroModel) {
			
			
			this.livroModel = livroModel;
			
		}
		
		//ATUALIZA O REGISTRO QUE FOI ALTERADO
		public void alterarRegistro() {
			
			
			this.livroModel.setAutorModel(livroModel.getAutorModel());
			this.livroModel.setEditoraModel(livroModel.getEditoraModel());
			this.livroModel.setGeneroModel(livroModel.getGeneroModel());
			
			
			this.livroRepository.alterarRegistro(this.livroModel);
			
			
			
			//RECARREGA REGISTROS
			this.init();
		}
		
		//EXCLUINDO UM REGISTRO
		public void excluirLivro(LivroModel livroModel) {
			//EXCLUIR O REGISTRO DO BD
			this.livroRepository.excluirRegistro(livroModel.getCodigo());
			
			//REMOVENDO O REGISTRO A ATUALIZANDO A LISTA E DATATABLE
			this.livros.remove(livroModel);
		}

	//SALVA UM NOVO REGISTRO
	public void salvarNovoLivro() {
		
		livroModel.setAutorModel(autorComplete);
		livroModel.setEditoraModel(editoraComplete);
		livroModel.setGeneroModel(generoComplete);
		
		System.out.println("Cadastro: " + livroModel.toString());
		
		livroRepository.salvarNovoRegistro(this.livroModel);
		
		
		
		Util.mensagemInfo("Registro cadastrado com sucesso!");
		
		this.livroModel = new LivroModel();
		this.editoraModel = new EditoraModel();
		this.autorModel = new AutorModel();
		this.generoModel = new GeneroModel();
		
	}
	
	public void selectAutor() {
		autorComplete = livroModel.getAutorModel();
		System.out.println("Sel Autor");
	}
	
	public void selectEditora() {
		editoraComplete = livroModel.getEditoraModel();
		System.out.println("Sel Editora");
	}
	
	public void selectGenero() {
		generoComplete = livroModel.getGeneroModel();
		System.out.println("Sel Genero");
	}
	
	public EditoraModel getEditoraModel() {
		return editoraModel;
	}

	public void setEditoraModel(EditoraModel editoraModel) {
		this.editoraModel = editoraModel;
	}

	public AutorModel getAutorModel() {
		return autorModel;
	}

	public void setAutorModel(AutorModel autorModel) {
		this.autorModel = autorModel;
	}
	
	public GeneroModel getGeneroModel() {
		return generoModel;
	}

	public void setGeneroModel(GeneroModel generoModel) {
		this.generoModel = generoModel;
	}

	public LivroModel getLivroModel() {
		return livroModel;
	}

	public void setLivroModel(LivroModel livroModel) {
		this.livroModel = livroModel;
	}

	public List<LivroModel> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroModel> livros) {
		this.livros = livros;
	}
	
	public List<AutorModel> getAutoresNovo() {
		return autoresNovo;
	}

	public void setAutoresNovo(List<AutorModel> autoresNovo) {
		this.autoresNovo = autoresNovo;
	}

	
	
	
}
	
	
