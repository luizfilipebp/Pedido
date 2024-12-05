package br.com.fiap.infrastructure.service.usuario;

import br.com.fiap.application.gateway.VerificarUsuarioGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificarUsuarioGatewayImpl implements VerificarUsuarioGateway {

    private final UsuarioGateway buscarUsuarioGateway;

    @Override
    public boolean verificarUsuario(Long idUsuario) {
        return true;
//        return Objects.equals(buscarUsuarioGateway.buscarUsuario(idUsuario).getHeaders().get("http_status"), HttpStatus.OK);
    }
}
