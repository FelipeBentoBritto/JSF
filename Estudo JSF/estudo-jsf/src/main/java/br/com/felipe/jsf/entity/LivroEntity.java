package br.com.felipe.jsf.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_livro")
@NamedQueries({
	@NamedQuery(name="LivroEntity.findAll",query="SELECT l from LivroEntity l")
})
public class LivroEntity {

	@Id
	@GeneratedValue
	@Column(name="id_livro")
	private Integer codigo;
	
	@Column(name="titulo_livro")
	private String titulo;
	
	@Column(name="isbn_livro")
	private String isbn;
	
	@Column(name="num_pag_livro")
	private Integer numeroPaginas;
	
	@Column(name="dt_cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name="descricao_livro")
	private String descricao;
	
	@OneToOne
	@JoinColumn(name="id_genero_cadastro")
	private GeneroEntity generoEntity;
	
	@OneToOne
	@JoinColumn(name="id_editora_cadastro")
	private EditoraEntity editoraEntity;
	
	@OneToOne
	@JoinColumn(name="id_autor_cadastro")
	private AutorEntity autorEntity;
	
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

	public GeneroEntity getGeneroEntity() {
		return generoEntity;
	}

	public void setGeneroEntity(GeneroEntity generoEntity) {
		this.generoEntity = generoEntity;
	}

	public EditoraEntity getEditoraEntity() {
		return editoraEntity;
	}

	public void setEditoraEntity(EditoraEntity editoraEntity) {
		this.editoraEntity = editoraEntity;
	}

	public AutorEntity getAutorEntity() {
		return autorEntity;
	}

	public void setAutorEntity(AutorEntity autorEntity) {
		this.autorEntity = autorEntity;
	}
	
	
	
}
