package br.com.fiap.infrastructure.service.usuario;


import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface UsuarioGateway {
    @Gateway(requestChannel = "verificarUsuarioChannel", requestTimeout = 5000)
    Message<?> buscarUsuario(Long idUsuario);
}
