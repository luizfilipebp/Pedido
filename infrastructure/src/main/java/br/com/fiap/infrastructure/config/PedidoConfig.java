package br.com.fiap.infrastructure.config;

import br.com.fiap.application.gateway.RetirarProdutoEstoqueGateway;
import br.com.fiap.application.gateway.VerificarEstoqueGateway;
import br.com.fiap.application.gateway.VerificarUsuarioGateway;
import br.com.fiap.application.gateway.pedido.BuscarPedidoGateway;
import br.com.fiap.application.gateway.pedido.CriarPedidoGateway;
import br.com.fiap.application.gateway.pedido.EditarPedidoGateway;
import br.com.fiap.application.usecaseimpl.VerificarEstoqueUseCaseImpl;
import br.com.fiap.application.usecaseimpl.VerificarUsuarioUseCaseImpl;
import br.com.fiap.application.usecaseimpl.estoque.RetirarProdutoEstoqueUseCaseImpl;
import br.com.fiap.application.usecaseimpl.pedido.BuscarPedidoUseCaseImpl;
import br.com.fiap.application.usecaseimpl.pedido.CancelarPedidoUseCaseImpl;
import br.com.fiap.application.usecaseimpl.pedido.CriarPedidoUseCaseImpl;
import br.com.fiap.usecase.VerificarUsuarioUseCase;
import br.com.fiap.usecase.estoque.RetirarProdutoEstoqueUseCase;
import br.com.fiap.usecase.estoque.VerificarEstoqueUseCase;
import br.com.fiap.usecase.pedido.BuscarPedidoUseCase;
import br.com.fiap.usecase.pedido.CancelarPedidoUseCase;
import br.com.fiap.usecase.pedido.CriarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoConfig {

    @Bean
    BuscarPedidoUseCase buscarPedidoUseCase(BuscarPedidoGateway buscarPedidoGateway) {
        return new BuscarPedidoUseCaseImpl(buscarPedidoGateway);
    }

    @Bean
    CancelarPedidoUseCase cancelarPedidoUseCase(BuscarPedidoGateway buscarPedidoGateway, EditarPedidoGateway editarPedidoGateway) {
        return new CancelarPedidoUseCaseImpl(buscarPedidoGateway, editarPedidoGateway);
    }

    @Bean
    CriarPedidoUseCase criarPedidoUseCase(CriarPedidoGateway criarPedidoGateway,
                                          VerificarUsuarioUseCase verificarUsuarioUseCase,
                                          VerificarEstoqueUseCase verificarEstoqueUseCase,
                                          RetirarProdutoEstoqueUseCase retirarProdutoEstoqueUseCase,
                                          BuscarPedidoUseCase buscarPedidoUseCase) {
        return new CriarPedidoUseCaseImpl(criarPedidoGateway, verificarUsuarioUseCase, verificarEstoqueUseCase, retirarProdutoEstoqueUseCase, buscarPedidoUseCase);
    }

    @Bean
    VerificarUsuarioUseCase verificarUsuarioUseCase(VerificarUsuarioGateway verificarUsuarioGateway) {
        return new VerificarUsuarioUseCaseImpl(verificarUsuarioGateway);
    }

    @Bean
    VerificarEstoqueUseCase verificarEstoqueUseCase(VerificarEstoqueGateway verificarEstoqueGateway) {
        return new VerificarEstoqueUseCaseImpl(verificarEstoqueGateway);
    }

    @Bean
    RetirarProdutoEstoqueUseCase retirarProdutoEstoqueUseCase(RetirarProdutoEstoqueGateway retirarProdutoEstoqueGateway) {
        return new RetirarProdutoEstoqueUseCaseImpl(retirarProdutoEstoqueGateway);
    }
}
