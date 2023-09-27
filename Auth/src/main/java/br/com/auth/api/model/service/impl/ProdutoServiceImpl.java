package br.com.auth.api.model.service.impl;

import br.com.auth.api.model.dto.ProdutoDTO;
import br.com.auth.api.model.dto.ProdutoDTOView;
import br.com.auth.api.model.entity.Produto;
import br.com.auth.api.model.repositories.ProdutoRepository;
import br.com.auth.api.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void incluirProduto(ProdutoDTO payload) {

        Produto produto = new Produto();
        produto.setDescricao(payload.getDescricao());
        produto.setPreco(payload.getPreco());
        produtoRepository.save(produto);
    }

    @Override
    public List<ProdutoDTOView> listarTodos() {

        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoDTOView> listaRetorno = produtos.stream()
                .map(ProdutoDTOView::fromEntity).collect(Collectors.toList());

        return listaRetorno;
    }
}
