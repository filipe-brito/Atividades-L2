package com.exercise1.exercise1.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class DimensoesRequest {
	@Min(1)
	@Max(50) // altura máxima
	private int altura;
	@Min(1)
	@Max(80) // largura máxima
	private int largura;
	@Min(1)
	@Max(60) // comprimento máxima
	private int comprimento;

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}

}
