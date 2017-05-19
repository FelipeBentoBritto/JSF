package br.com.felipe.jsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.felipe.jsf.model.AutorModel;
import br.com.felipe.jsf.repository.AutorRepository;

@ManagedBean(name="consultarAutorController")
@ViewScoped
public class ConsultarAutorController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private AutorModel autorModel = new AutorModel();
	
	private List<AutorModel> autores = new ArrayList<AutorModel>();
	
	private AutorRepository autorRepository = new AutorRepository();

	public AutorModel getAutorModel() {
		return autorModel;
	}

	public void setAutorModel(AutorModel autorModel) {
		this.autorModel = autorModel;
	}

	public List<AutorModel> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorModel> autores) {
		this.autores = autores;
	}

	//CARREGA OS AUTORES NA INICIALIZAÇÃO
	@PostConstruct
	public void init() {
		//RETORNA OS AUTORES CADASTRADAS
		this.autores = autorRepository.getAutores();
	}
	
	public void editar(AutorModel autorModel) {
		//PEGA APENAS A PRIMEIRA LETRA DO SEXO PARA SETAR NO CAMPO(M OU F)
		autorModel.setSexo(autorModel.getSexo().substring(0,1));
		
		this.autorModel = autorModel;
	}
	
	//ATUALIZA O REGISTRO QUE FOI ALTERADO
	public void alterarRegistro() {
		this.autorRepository.alterarRegistro(this.autorModel);
		
		//RECARREGA OS REGISTROS
		this.init();
	}
	
	
	//EXCLUINDO UM REGISTRO
	//@param autor
	public void excluirAutor(AutorModel autorModel) {
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.autorRepository.excluirRegistro(autorModel.getCodigo());
		
		//REMOVENDO O REGISTRO DA LISTA
		//ASSIM QUE O REGISTRO É REMOVIDO DA LISTA O DATATABLE É ATUALIZADO
		this.autores.remove(autorModel);
	}
	

}
