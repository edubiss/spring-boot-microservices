package com.edubiss.equipe.confronto.confrontoservice.model.dto;

public class Equipe {

	public final static String EQUIPE_MANDANTE = "Mandante";
	public final static String EQUIPE_VISITANTE = "Visitante";

    private Long id;
    private String nome;
    private String logo;

	public Equipe() {
	}

	public Equipe(String nome) {
		this.nome = nome;
	}

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
    
}
