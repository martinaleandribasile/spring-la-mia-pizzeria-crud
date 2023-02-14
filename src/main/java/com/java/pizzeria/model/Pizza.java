package com.java.pizzeria.model;

import java.math.BigDecimal;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table()
public class Pizza {
	@Override
	public String toString() {
		return "Pizza-> " + nome + ",( " + descrizione + " ), " + prezzo + " euro";
	}
	@Id               // INDICA LA NOSTRA CHIAVE PRIMARIA
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	@NonNull
	@Column(nullable = false)
	private String nome;
	private String descrizione;
	@NonNull
	@Column(nullable = false)
	private BigDecimal prezzo;
	private String foto;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Integer getId() {
		return id;
	}
	
}
