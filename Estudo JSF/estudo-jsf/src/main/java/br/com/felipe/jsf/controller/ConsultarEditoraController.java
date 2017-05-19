package br.com.felipe.jsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.felipe.jsf.model.EditoraModel;
import br.com.felipe.jsf.repository.EditoraRepository;

@ManagedBean(name="consultarEditoraController")
@ViewScoped
public class ConsultarEditoraController implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private EditoraModel editoraModel;
	
	private List<EditoraModel> editoras = new ArrayList<EditoraModel>();
	
	private EditoraRepository editoraRepository = new EditoraRepository();
	
	public List<EditoraModel> getEditoras() {
		return editoras;
	}
	
	public void setEditoras(List<EditoraModel> editoras) {
		this.editoras = editoras;
	}

	public EditoraModel getEditoraModel() {
		return editoraModel;
	}

	public void setEditoraModel(EditoraModel editoraModel) {
		this.editoraModel = editoraModel;
	}
	
	//CARREGA OS REGISTROS NA INICIALIZAÇÃO
	
	@PostConstruct
	public void init() {
		this.editoras = editoraRepository.getEditoras();
	}
	
	//CARREGA INFORMAÇÕES DO REGISTRO PARA SER EDITADO
	public void editar(EditoraModel editoraModel) {
		this.editoraModel = editoraModel;
	}
	
	//ATUALIZA O REGISTRO QUE FOI ALTERADO
	public void alterarRegistro() {
		this.editoraRepository.alterarRegistro(this.editoraModel);
		
		//RECARREGA OS REGISTROS
		this.init();
	}
	
	//EXCLUINDO UM REGISTRO
	public void excluirEditora(EditoraModel editoraModel) {
		//EXCLUI O REGISTRO DO BANCO DE DADOS
		this.editoraRepository.excluirRegistro(editoraModel.getCodigo());
		
		//REMOVENDO O REGISTRO DA LISTA E ATUALIZANDO O DATATABLE
		this.editoras.remove(editoraModel);
	}
		
	
}
