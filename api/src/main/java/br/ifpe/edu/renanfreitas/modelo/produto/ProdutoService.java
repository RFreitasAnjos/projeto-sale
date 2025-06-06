package br.ifpe.edu.renanfreitas.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto){
        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado){
        Produto produto = repository.findById(id).get();
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setPreco(produtoAlterado.getPreco());
        
        repository.save(produto);
    }

    @Transactional
    public void delete(Long id){
        Produto produto = repository.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);

        repository.save(produto);
    }

    public List<Produto> listarTodos() { return repository.findAll(); }

    public Produto obterPorId(Long id) { return repository.findById(id).get(); }

}
