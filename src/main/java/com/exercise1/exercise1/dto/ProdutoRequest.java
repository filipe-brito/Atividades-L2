package com.exercise1.exercise1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequest {
	@NotBlank
	@JsonProperty("produto_id")
	private String produtoId;
	@NotNull
    private DimensoesRequest dimensoes;
    
	public String getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}
	public DimensoesRequest getDimensoes() {
		return dimensoes;
	}
	public void setDimensoes(DimensoesRequest dimensoes) {
		this.dimensoes = dimensoes;
	}
    
    
}
