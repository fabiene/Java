package org.serratec.java2.backend.marketplace.service;

import java.util.List;
import java.util.Optional;

import org.serratec.java2.backend.marketplace.entidade.Produto;
import org.serratec.java2.backend.marketplace.entidade.Usuario;
import org.serratec.java2.backend.marketplace.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	private Produto findById(Integer id)throws DataNotFoundException{
		Optional<Produto>produto = produtoRepositorio.findById(id);
		if(produto.isPresent()){
			return produto.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Produto buscaPorId (Integer id) throws DataNotFoundException{
		return findById(id);
	}
	
	public List<Produto> buscaTodos(){
		return produtoRepositorio.findAll();
	}
	
	@Transactional
	public Produto incluiProduto(Produto produto) {
		return produtoRepositorio.save(produto);
	}
	
	@Transactional
	public Produto atualizaProduto (Integer id, Produto produto ) throws DataNotFoundException {
		Produto produtoNovo = findById(id);
		produto.setNomeProduto(produtoNovo.getNomeProduto());
		produto.setDescricaoProduto(produtoNovo.getDescricaoProduto());
		produto.setNomeVendedor(produtoNovo.getNomeVendedor());
		produto.setQuantidadeProduto(produtoNovo.getQuantidadeProduto());
		produto.setDataFabricacao(produtoNovo.getDataFabricacao());
		return produtoRepositorio.save(produto);
	}
	
	@Transactional
	public void apagaProduto(Integer id) throws DataNotFoundException {
		Produto produto = findById(id);
		produtoRepositorio.delete(produto);
	}
}
