package com.exercise1.exercise1.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise1.exercise1.dto.CaixaResponse;
import com.exercise1.exercise1.dto.PedidoRequest;
import com.exercise1.exercise1.dto.PedidoResponse;
import com.exercise1.exercise1.dto.ProdutoRequest;
import com.exercise1.exercise1.exceptions.DimensoesInvalidasException;
import com.exercise1.exercise1.model.Caixa;

@Service
public class EmpacotamentoService {

    private static final int MAX_ALTURA = 50;
    private static final int MAX_LARGURA = 80;
    private static final int MAX_COMPRIMENTO = 60;

    public List<PedidoResponse> empacotarPedidos(List<PedidoRequest> pedidos) {
        List<PedidoResponse> responses = new ArrayList<>();

        for (PedidoRequest pedido : pedidos) {
            PedidoResponse pedidoResp = new PedidoResponse();
            pedidoResp.setPedidoId(pedido.getPedidoId());

            List<CaixaResponse> caixas = new ArrayList<>();

            // Ordena produtos do maior volume para o menor
            List<ProdutoRequest> produtosOrdenados = new ArrayList<>(pedido.getProdutos());
            produtosOrdenados.sort(Comparator.comparingInt(p -> -calcularVolume(p)));

            for (ProdutoRequest produto : produtosOrdenados) {
                validarDimensoes(produto);

                Caixa caixaEscolhida = escolherCaixa(produto);
                if (caixaEscolhida == null) {
                    throw new DimensoesInvalidasException(
                            String.format("Produto '%s' não cabe em nenhuma caixa.", produto.getProdutoId()));
                }

                boolean colocado = false;

                // tenta colocar em uma caixa já aberta do mesmo tipo
                for (CaixaResponse caixa : caixas) {
                    if (caixa.getCaixaId().equals(caixaEscolhida.getId())) {
                        int volumeAtual = caixa.getProdutos().stream()
                                .mapToInt(pId -> {
                                    ProdutoRequest p = produtosOrdenados.stream()
                                            .filter(pr -> pr.getProdutoId().equals(pId))
                                            .findFirst().orElseThrow();
                                    return calcularVolume(p);
                                }).sum();

                        int volumeProduto = calcularVolume(produto);
                        if (volumeAtual + volumeProduto <= caixaEscolhida.getVolume()) {
                            caixa.getProdutos().add(produto.getProdutoId());
                            colocado = true;
                            break;
                        }
                    }
                }

                // se não coube em nenhuma já aberta, abre nova
                if (!colocado) {
                    CaixaResponse novaCaixa = new CaixaResponse();
                    novaCaixa.setCaixaId(caixaEscolhida.getId());
                    novaCaixa.setProdutos(new ArrayList<>());
                    novaCaixa.getProdutos().add(produto.getProdutoId());
                    caixas.add(novaCaixa);
                }
            }

            pedidoResp.setCaixas(caixas);
            responses.add(pedidoResp);
        }

        return responses;
    }

    private void validarDimensoes(ProdutoRequest produto) {
        int altura = produto.getDimensoes().getAltura();
        int largura = produto.getDimensoes().getLargura();
        int comprimento = produto.getDimensoes().getComprimento();

        if (altura > MAX_ALTURA || largura > MAX_LARGURA || comprimento > MAX_COMPRIMENTO) {
            throw new DimensoesInvalidasException(
                    String.format("Produto '%s' possui dimensões inválidas. Máx: %dx%dx%d",
                            produto.getProdutoId(), MAX_ALTURA, MAX_LARGURA, MAX_COMPRIMENTO));
        }
    }

    private Caixa escolherCaixa(ProdutoRequest produto) {
        int altura = produto.getDimensoes().getAltura();
        int largura = produto.getDimensoes().getLargura();
        int comprimento = produto.getDimensoes().getComprimento();

        for (Caixa c : Caixa.values()) {
            if (altura <= c.getAltura() && largura <= c.getLargura() && comprimento <= c.getComprimento()) {
                return c;
            }
        }
        return null; // não cabe em nenhuma
    }

    private int calcularVolume(ProdutoRequest produto) {
        return produto.getDimensoes().getAltura()
                * produto.getDimensoes().getLargura()
                * produto.getDimensoes().getComprimento();
    }
}
