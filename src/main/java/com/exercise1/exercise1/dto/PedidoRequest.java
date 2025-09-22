package com.exercise1.exercise1.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public class PedidoRequest {

	@NotNull
	@JsonProperty("pedido_id")
	private Integer pedidoId;
	@NotNull
	private List<ProdutoRequest> produtos;

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public List<ProdutoRequest> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoRequest> produtos) {
		this.produtos = produtos;
	}

}
