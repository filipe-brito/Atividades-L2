package com.exercise1.exercise1.dto;

import java.util.List;

public class PedidoResponse {
	private Integer pedidoId;
    private List<CaixaResponse> caixas;
    
	public Integer getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}
	public List<CaixaResponse> getCaixas() {
		return caixas;
	}
	public void setCaixas(List<CaixaResponse> caixas) {
		this.caixas = caixas;
	}
    
}
