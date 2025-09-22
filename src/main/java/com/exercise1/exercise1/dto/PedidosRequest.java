package com.exercise1.exercise1.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class PedidosRequest {
    @NotEmpty
    @Valid
    private List<PedidoRequest> pedidos;

	public List<PedidoRequest> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoRequest> pedidos) {
		this.pedidos = pedidos;
	}

}

