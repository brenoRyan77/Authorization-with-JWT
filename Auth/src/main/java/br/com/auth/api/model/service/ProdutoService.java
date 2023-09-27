package br.com.auth.api.model.service;

import br.com.auth.api.model.dto.ProdutoDTO;
import br.com.auth.api.model.dto.ProdutoDTOView;

import java.util.List;

public interface ProdutoService {

    void incluirProduto(ProdutoDTO payload);

    List<ProdutoDTOView> listarTodos();
}
