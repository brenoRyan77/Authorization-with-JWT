package br.com.auth.api.model.enums;

public enum PerfilUsuario {

    ADMIN("admin"),
    USER("user");

    private String perfil;

    PerfilUsuario(String perfil){
        this.perfil = perfil;
    }

    public String getPerfil(){
        return this.perfil;
    }
}
