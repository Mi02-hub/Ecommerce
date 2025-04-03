package com.senai.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.dto.CategoriaDTO;
import com.senai.ecommerce.dto.ProdutoDTO;
import com.senai.ecommerce.entities.Categoria;
import com.senai.ecommerce.entities.Produto;
import com.senai.ecommerce.repositories.CategoriaRepository;
import com.senai.ecommerce.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired 
    private ProdutoRepository repo;
    
    @Autowired 
    private CategoriaRepository categoriarepo;
    
    
    public List<ProdutoDTO> buscarTodos() {
        List<Produto> list = repo.findAll();
        return list.stream().map(ProdutoDTO::new).toList(); 
    }
    
    public Page<ProdutoDTO> buscarPagina(Pageable pagina) {
        Page<Produto> result = repo.findAll(pagina);
        return result.map(ProdutoDTO::new);
    }
    
    @Transactional
    public ProdutoDTO inserir(ProdutoDTO dto) {
       Produto produto = new Produto();
       produto.setNome(dto.getNome());
       produto.setDescricao(dto.getDescricao());
       produto.setPreco(dto.getPreco());
       produto.setImgUrl(dto.getImgUrl());
       for(CategoriaDTO cat : dto.getCategorias()) {
    	   
    	   Categoria categoria = categoriarepo.getReferenceById(cat.getId());
    	   produto.getCategorias().add(categoria);
       }
       produto = repo.save(produto);
    	return new ProdutoDTO(produto);
    }
}