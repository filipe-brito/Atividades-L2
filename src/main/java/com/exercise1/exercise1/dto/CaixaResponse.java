package com.exercise1.exercise1.dto;

import java.util.List;

public class CaixaResponse {
	private String caixaId;
    private List<String> produtos;
    
    public String getCaixaId() {
		return caixaId;
	}
	public void setCaixaId(String caixaId) {
		this.caixaId = caixaId;
	}
	public List<String> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<String> produtos) {
		this.produtos = produtos;
	}

}
