package br.com.felipe.jsf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.felipe.jsf.model.GeneroModel;
import br.com.felipe.jsf.repository.GeneroRepository;
import br.com.felipe.jsf.util.Util;

@ManagedBean(name="generoController")
@RequestScoped
public class GeneroController {

	private GeneroModel generoModel = new GeneroModel();
	
	private GeneroRepository generoRepository = new GeneroRepository();

	public GeneroModel getGeneroModel() {
		return generoModel;
	}

	public void setGeneroModel(GeneroModel generoModel) {
		this.generoModel = generoModel;
	}

	//SALVAR UM NOVO REGISTRO
	
	public void salvarNovoGenero() {
		
		generoRepository.salvarNovoRegistro(this.generoModel);
		
		this.generoModel = null;

		Util.mensagemInfo("Registro cadastrado com sucesso!");
		
	}
	
	
	
	
}
