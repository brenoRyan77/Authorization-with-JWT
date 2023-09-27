package br.com.auth.api.model.dto;

import br.com.auth.api.model.enums.PerfilUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @NotBlank(message = "O login é obrigatório.")
    private String login;

    @NotBlank(message = "A senha é obrigatório.")
    private String password;

    private PerfilUsuario perfil;
}
