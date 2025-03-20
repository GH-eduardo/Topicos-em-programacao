package com.gerenciamento.produtos.controllers;

import com.gerenciamento.produtos.entities.Produto;
import com.gerenciamento.produtos.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Criar um novo produto")
    @PostMapping()
    public ResponseEntity<Produto> createProduto(@Valid @RequestBody Produto produto) {
        return produtoService.createProduto(produto);
    }

    @Operation(summary = "Ver a lista de todos os produtos")
    @GetMapping()
    public ResponseEntity<List<Produto>> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @Operation(summary = "Buscar um produto passando seu id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    @Operation(summary = "Atualizar um produto passando seu id")
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProdutoById(@Valid @RequestBody Produto produto, @PathVariable Long id) {
        return produtoService.updateProdutoById(produto, id);
    }

    @Operation(summary = "Deletar um produto passando seu id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProdutoById(@PathVariable Long id) {
        return produtoService.deleteProdutoById(id);
    }
}
