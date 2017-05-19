package br.com.felipe.jsf.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.felipe.jsf.util.Classe;

public class LivroModel extends Classe{

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String titulo;
	private String isbn;
	private Integer numeroPaginas;
	private LocalDateTime dataCadastro;
	private String descricao;
	private GeneroModel generoModel;
	private EditoraModel editoraModel;
	private AutorModel autorModel;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public GeneroModel getGeneroModel() {
		return generoModel;
	}
	public void setGeneroModel(GeneroModel generoModel) {
		this.generoModel = generoModel;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autorModel == null) ? 0 : autorModel.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((editoraModel == null) ? 0 : editoraModel.hashCode());
		result = prime * result + ((generoModel == null) ? 0 : generoModel.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((numeroPaginas == null) ? 0 : numeroPaginas.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroModel other = (LivroModel) obj;
		if (autorModel == null) {
			if (other.autorModel != null)
				return false;
		} else if (!autorModel.equals(other.autorModel))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (editoraModel == null) {
			if (other.editoraModel != null)
				return false;
		} else if (!editoraModel.equals(other.editoraModel))
			return false;
		if (generoModel == null) {
			if (other.generoModel != null)
				return false;
		} else if (!generoModel.equals(other.generoModel))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (numeroPaginas == null) {
			if (other.numeroPaginas != null)
				return false;
		} else if (!numeroPaginas.equals(other.numeroPaginas))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LivroModel [codigo=" + codigo + ", titulo=" + titulo + ", isbn=" + isbn + ", numeroPaginas="
				+ numeroPaginas + ", dataCadastro=" + dataCadastro + ", descricao=" + descricao + ", generoModel="
				+ generoModel + ", editoraModel=" + editoraModel + ", autorModel=" + autorModel + "]";
	}
	
	
	
	
	
	
}
