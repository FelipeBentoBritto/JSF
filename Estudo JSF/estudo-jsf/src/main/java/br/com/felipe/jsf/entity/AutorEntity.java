package br.com.felipe.jsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_autor")
@NamedQueries({
	@NamedQuery(name="AutorEntity.findAll", query="SELECT a from AutorEntity a"),
	@NamedQuery(name="AutorEntity.byName", query="SELECT a FROM AutorEntity a ORDER BY a.nome"),
	@NamedQuery(name="AutorEntity.likeName",query="SELECT a from AutorEntity a WHERE a.nome LIKE :nome ORDER BY a.nome")
})
public class AutorEntity {

	@Id
	@GeneratedValue
	@Column(name="id_pessoa")
	private Integer codigo;
	
	@Column(name="nm_pessoa")
	private String nome;
	
	@Column(name="fl_sexo")
	private String sexo;
	
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
