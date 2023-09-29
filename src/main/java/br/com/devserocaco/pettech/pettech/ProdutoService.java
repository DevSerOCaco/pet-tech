package br.com.devserocaco.pettech.pettech;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Collection<Produto> findAll() {
        var produtos = produtoRepository.findAll();
        return produtos;
    }

    public Produto findById(UUID id){
        var produto = produtoRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
        return produto;
    }

    public Produto save(Produto produto) {
        produto = produtoRepository.save(produto);
        return produto;
    }


    public Produto update(UUID id, Produto produto) {
        try{
            Produto buscaProduto = produtoRepository.getOne(id);
            buscaProduto.setNome(produto.getNome());
            buscaProduto.setDescricao(produto.getDescricao());
            buscaProduto.setUrlDaImagem(produto.getUrlDaImagem());
            buscaProduto.setPreco(produto.getPreco());
            return buscaProduto;
        } catch(EntityNotFoundException e){
            throw new ControllerNotFoundException("Produto não Encontrado");
        }

    }

    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }
}
