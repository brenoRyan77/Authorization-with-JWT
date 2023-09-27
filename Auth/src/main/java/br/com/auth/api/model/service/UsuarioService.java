package br.com.auth.api.model.service;

import br.com.auth.api.model.dto.UsuarioDTO;

public interface UsuarioService {

    void registrar(UsuarioDTO payload) throws Exception;
}
