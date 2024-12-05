package br.com.fiap.infrastructure.exemplo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;

@Configuration
public class EstoquePedidoConfig {
    @Bean
    MessageChannel estoquePedidoChannel() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setFailover(false);
        return directChannel;
    }

    @Bean
    public IntegrationFlow estoquePedidoFlow() {
        return IntegrationFlow.from("estoquePedidoChannel")
                .handle(Http.outboundGateway("http://localhost:8081/v1/estoque/{idProduto}")
                        .httpMethod(HttpMethod.GET)
                        .uriVariable("idProduto", "payload")
                        .expectedResponseType(EstoqueDTO.class))
                .log()
                .bridge()
                .get();
    }
}
