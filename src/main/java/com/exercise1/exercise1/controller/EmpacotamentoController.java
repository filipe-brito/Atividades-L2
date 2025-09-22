package com.exercise1.exercise1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise1.exercise1.dto.PedidoResponse;
import com.exercise1.exercise1.dto.PedidosRequest;
import com.exercise1.exercise1.service.EmpacotamentoService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "*")  // permite requisições de qualquer origem
@RestController
public class EmpacotamentoController {

	private final EmpacotamentoService service;

	public EmpacotamentoController(EmpacotamentoService service) {
		this.service = service;
	}

	@PostMapping("/empacotar")
	public List<PedidoResponse> empacotar(@Valid @RequestBody PedidosRequest pedidosRequest) {
		return service.empacotarPedidos(pedidosRequest.getPedidos());
	}

}
