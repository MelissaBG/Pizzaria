import enums.*;
import model.Bebida;
import model.Comida;
import model.Item;
import model.Pedido;
import model.cliente.Cliente;
import model.cliente.Contato;
import model.cliente.Endereco;
import service.PedidoService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Setup
        PedidoService pedidoService = new PedidoService();

        // Pedido do Matheus
        Contato contatoMatheus = new Contato("3333-3333", "9999-9999", null);
        Endereco enderecoMatheus = new Endereco("Rua XPTO", "123", "90000-000", "RS", contatoMatheus);
        Cliente clienteMatheus = new Cliente("Matheus Brizola","111222333-44", enderecoMatheus);

        Comida pizzaMatheus = new Comida(1, new BigDecimal(25), TipoComida.PIZZA_SALGADA, TamanhoComida.FAMILIA);
        Bebida sucoMatheus = new Bebida(1, new BigDecimal(12.90), TipoBebida.SUCO_UVA);
        List<Item> itensMatheus = Arrays.asList(pizzaMatheus, sucoMatheus);

        Pedido pedidoMatheus = new Pedido (1, null, itensMatheus, null, clienteMatheus, MetodoPagamento.PIX);

        System.out.println(pedidoService.listarPedidos());
        System.out.println("Quantidade Pedidos da Pizzaria: " + pedidoService.buscarQuantidadePedidos());
        System.out.println("Quantidade Pedidos em Análise da Pizzaria: " + pedidoService.listarPedidosPorSituacao(SituacaoPedido.EM_ANALISE).size());

        pedidoService.realizarPedido(pedidoMatheus);

        System.out.println("Quantidade Pedidos da Pizzaria: " + pedidoService.buscarQuantidadePedidos());
    }
}
