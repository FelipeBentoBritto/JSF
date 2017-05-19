package br.com.felipe.jsf.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.felipe.jsf.model.AutorModel;
import br.com.felipe.jsf.repository.AutorRepository;
import br.com.felipe.jsf.util.Util;


@ManagedBean(name="autorController")
@RequestScoped
public class AutorController {

	private AutorModel autorModel = new AutorModel();
	
	private AutorRepository autorRepository = new AutorRepository();

	public AutorModel getAutorModel() {
		return autorModel;
	}

	public void setAutorModel(AutorModel autorModel) {
		this.autorModel = autorModel;
	}
	
	public void salvarNovoAutor() {
		
		autorRepository.salvarNovoRegistro(this.autorModel);
		
		this.autorModel = null;
		
		Util.mensagemInfo("Registro cadastrado com sucesso!");
	}
	
}
