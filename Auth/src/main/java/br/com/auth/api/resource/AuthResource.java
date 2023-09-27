package br.com.auth.api.resource;

import br.com.auth.api.model.dto.LoginDTO;
import br.com.auth.api.model.dto.LoginDTOView;
import br.com.auth.api.model.dto.UsuarioDTO;
import br.com.auth.api.model.entity.Usuario;
import br.com.auth.api.security.TokenService;
import br.com.auth.api.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO payload){

        var usernamePassword = new UsernamePasswordAuthenticationToken(
                payload.login(), payload.password());

        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginDTOView(token));
    }

    @PostMapping("/register")
    public ResponseEntity registrar(@RequestBody @Valid UsuarioDTO payload) throws Exception {

        try{
            usuarioService.registrar(payload);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
}
