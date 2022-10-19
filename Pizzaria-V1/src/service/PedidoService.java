package service;

import enums.SituacaoPedido;
import model.Pedido;
import repository.PedidoRepository;
import java.util.List;

public class PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoService() {
        this.pedidoRepository = new PedidoRepository();
    }

    public void realizarPedido(Pedido pedido) {
        pedido.setSituacao(SituacaoPedido.EM_ANALISE);
        pedidoRepository.armazenarPedido(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.listarPedidos();
    }

    //public List<Pedido> listarPedidosEmAnalise() {
//        List<Pedido> pedidosEmAnalise = new ArrayList<>();
//        List<Pedido> todosPedidos = listarPedidos();
//
//        for (Pedido pedido: todosPedidos) {
//            if (pedido.getSituacao().equals(SituacaoPedido.EM_ANALISE)) {
//                pedidosEmAnalise.add(pedido);
//            }
//        }
//
//        return pedidosEmAnalise;
//        return listarPedidos()
//                .stream()
//                .filter(p -> p.getSituacao().equals(SituacaoPedido.EM_ANALISE))
//                .toList();
    //}

//    public List<Pedido> listarPedidosFinalizados() {
//        return listarPedidos()
//                .stream()
//                .filter(p -> p.getSituacao().equals(SituacaoPedido.FINALIZADO))
//                .toList();
//    }
//
//    public List<Pedido> listarPedidosEmPreparo() {
//        return listarPedidos()
//                .stream()
//                .filter(p -> p.getSituacao().equals(SituacaoPedido.EM_PREPARO))
//                .toList();
//    }
//
//    public List<Pedido> listarPedidosEmTransito() {
//        return listarPedidos()
//                .stream()
//                .filter(p -> p.getSituacao().equals(SituacaoPedido.EM_TRANSITO))
//                .toList();
//    }

    public List<Pedido> listarPedidosPorSituacao(SituacaoPedido situacao) {
        return listarPedidos()
                .stream()
                .filter(pedido -> pedido.getSituacao().equals(situacao))
                .toList();
    }

    public int buscarQuantidadePedidos() {
        return pedidoRepository.buscarTotalPedidos();
    }

}
