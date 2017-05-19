package br.com.felipe.jsf.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.felipe.jsf.model.EditoraModel;
import br.com.felipe.jsf.repository.EditoraRepository;
import br.com.felipe.jsf.util.Util;

@ManagedBean(name="editoraController")
@RequestScoped
public class EditoraController {
	
	private EditoraModel editoraModel = new EditoraModel();
	
	private EditoraRepository editoraRepository = new EditoraRepository();

	public EditoraModel getEditoraModel() {
		return editoraModel;
	}

	public void setEditoraModel(EditoraModel editoraModel) {
		this.editoraModel = editoraModel;
	}
	
	//SALVA UM NOVO REGISTRO
	public void salvarNovaEditora() {
		editoraRepository.salvarNovoRegistro(this.editoraModel);
		
		this.editoraModel = null;
		
		Util.mensagemInfo("Registro cadastrado com sucesso!");
	}
	
	
	

}
