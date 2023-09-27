package br.com.auth.api.model.service.impl;

import br.com.auth.api.model.dto.UsuarioDTO;
import br.com.auth.api.model.entity.Usuario;
import br.com.auth.api.model.repositories.UsuarioRepository;
import br.com.auth.api.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public void registrar(UsuarioDTO payload) throws Exception {

        UserDetails details = repository.findByLogin(payload.getLogin());
        if(details != null){
            throw new Exception("Já existe um usuário com o mesmo Login");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(payload.getPassword());

        Usuario user = new Usuario();
        user.setLogin(payload.getLogin());
        user.setPassword(encryptedPassword);
        user.setPerfil(payload.getPerfil());

        repository.save(user);
    }
}
