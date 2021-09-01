package com.edubiss.equipe.service.equipeservice.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

	@Column
    private String logo;


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}


	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Equipe)) {
			return false;
		}
		Equipe equipe = (Equipe) o;
		return Objects.equals(id, equipe.id) && Objects.equals(nome, equipe.nome) && Objects.equals(logo, equipe.logo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, logo);
	}


	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", nome='" + getNome() + "'" +
			", logo='" + getLogo() + "'" +
			"}";
	}


}
