package com.exercise1.exercise1.model;

public enum Caixa {
	CAIXA1("Caixa 1", 30, 40, 80), CAIXA2("Caixa 2", 50, 50, 40), CAIXA3("Caixa 3", 50, 80, 60);

	private final String id;
	private final int altura;
	private final int largura;
	private final int comprimento;
	private final int volume;

	Caixa(String id, int altura, int largura, int comprimento) {
		this.id = id;
		this.altura = altura;
		this.largura = largura;
		this.comprimento = comprimento;
		this.volume = altura * largura * comprimento;
	}

	public String getId() {
		return id;
	}

	public int getAltura() {
		return altura;
	}

	public int getLargura() {
		return largura;
	}

	public int getComprimento() {
		return comprimento;
	}

	public int getVolume() {
		return volume;
	}
	
}
