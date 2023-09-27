package br.com.auth.api.resource;

import br.com.auth.api.model.dto.ProdutoDTO;
import br.com.auth.api.model.dto.ProdutoDTOView;
import br.com.auth.api.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/produto")
@RestController
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity incluirProduto(@RequestBody @Valid ProdutoDTO payload){

        service.incluirProduto(payload);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity listarTodos(){
        List<ProdutoDTOView> retorno = service.listarTodos();
        return ResponseEntity.ok(retorno);
    }
}
