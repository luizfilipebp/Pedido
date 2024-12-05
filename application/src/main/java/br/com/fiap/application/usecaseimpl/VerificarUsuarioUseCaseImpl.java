package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.VerificarUsuarioGateway;
import br.com.fiap.usecase.VerificarUsuarioUseCase;

public class VerificarUsuarioUseCaseImpl implements VerificarUsuarioUseCase {

    private final VerificarUsuarioGateway verificarUsuarioGateway;

    public VerificarUsuarioUseCaseImpl(VerificarUsuarioGateway verificarUsuarioGateway) {
        this.verificarUsuarioGateway = verificarUsuarioGateway;
    }

    @Override
    public boolean verificarUsuario(Long idUsuario) {
        return verificarUsuarioGateway.verificarUsuario(idUsuario);
    }
}
