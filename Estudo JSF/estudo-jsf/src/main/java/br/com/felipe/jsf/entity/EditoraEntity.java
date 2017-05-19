package br.com.felipe.jsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_editora")
@NamedQueries({
	@NamedQuery(name="EditoraEntity.findAll",query="SELECT e FROM EditoraEntity e"),
	@NamedQuery(name="EditoraEntity.byName", query="SELECT e FROM EditoraEntity e ORDER BY e.nome"),
	@NamedQuery(name="EditoraEntity.likeName", query="SELECT e FROM EditoraEntity e WHERE e.nome LIKE :nome ORDER BY e.nome")
})
public class EditoraEntity {

	@Id
	@GeneratedValue
	@Column(name="id_editora")
	private Integer codigo;
	
	@Column(name="nm_editora")
	private String nome;
	
	@Column(name="cnpj_editora")
	private String cnpj;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
}
