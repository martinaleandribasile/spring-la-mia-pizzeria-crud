package com.java.pizzeria.model;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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
	@NotNull(message="Nome: campo obbligatorio")
	@NotEmpty(message = "Nome: campo obbligatorio")
	private String nome;
	private String descrizione;
	@NotNull(message="Prezzo: campo obbligatorio")
	@DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
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
	public void setPrezzo( BigDecimal prezzo) {
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
