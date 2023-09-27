package br.com.auth.api.model.dto;

import br.com.auth.api.model.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDTOView {

    private String descricao;
    private Double preco;

    public static ProdutoDTOView fromEntity(Produto produto){

        var response = new ProdutoDTOView();

        response.setDescricao(produto.getDescricao());
        response.setPreco(produto.getPreco());

        return response;
    }
}
