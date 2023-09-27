package br.com.auth.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {

    @NotBlank(message = "A descrição do produto é obrigatório.")
    private String descricao;

    @NotNull(message = "O preço do produto é obrigatório.")
    private Double preco;
}
