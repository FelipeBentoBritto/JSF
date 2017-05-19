package br.com.felipe.jsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_genero")
@NamedQueries({
	@NamedQuery(name="GeneroEntity.findAll",query="SELECT g FROM GeneroEntity g"),
	@NamedQuery(name="GeneroEntity.byName", query="SELECT g FROM GeneroEntity g ORDER BY g.nome"),
	@NamedQuery(name="GeneroEntity.likeName", query="SELECT g from GeneroEntity g WHERE g.nome LIKE :nome ORDER BY g.nome")
})
public class GeneroEntity {

	@Id
	@GeneratedValue
	@Column(name="id_genero")
	private Integer codigo;
	
	@Column(name="nm_genero")
	private String nome;

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

	
	
}


