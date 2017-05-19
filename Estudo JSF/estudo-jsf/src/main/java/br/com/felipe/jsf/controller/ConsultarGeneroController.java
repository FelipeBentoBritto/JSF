package br.com.felipe.jsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.felipe.jsf.model.GeneroModel;
import br.com.felipe.jsf.repository.GeneroRepository;

@ManagedBean(name="consultarGeneroController")
@ViewScoped
public class ConsultarGeneroController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private GeneroModel generoModel = new GeneroModel();
	
	private List<GeneroModel> generos = new ArrayList<GeneroModel>();
	
	private GeneroRepository generoRepository = new GeneroRepository();

	public GeneroModel getGeneroModel() {
		return generoModel;
	}

	public void setGeneroModel(GeneroModel generoModel) {
		this.generoModel = generoModel;
	}

	public List<GeneroModel> getGeneros() {
		return generos;
	}

	public void setGeneros(List<GeneroModel> generos) {
		this.generos = generos;
	}
	
	//CARREGA OS REGISTRNOS NA INICIALIZAÇÃO
	@PostConstruct
	public void init(){
		this.generos = generoRepository.getGeneros();
	}
	
	//CARREGA INFORMAÇÕES DE UM REGISTRO PARA SER EDITADO
	public void editar(GeneroModel generoModel) {
		this.generoModel = generoModel;
	}
	
	//ATUALIZA O REGISTRO QUE FOI ALTERADO
	public void alterarRegistro() {
		this.generoRepository.alterarRegistro(this.generoModel);
		
		this.init();
	}
	
	//EXCLUINDO UM REGISTRO
	public void excluirGenero(GeneroModel generoModel) {
		//EXCLUI O REGISTRO DO BANCO DE DADOS
		this.generoRepository.excluirRegistro(generoModel.getCodigo());
		
		//REMOVE O REGISTRO DA LISTA E ATUALIZA A DATATABLE
		this.generos.remove(generoModel);
	}

	
	
}
