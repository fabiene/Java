package org.serratec.java2.backend.marketplace.service;

import java.util.List;
import java.util.Optional;

import org.serratec.java2.backend.marketplace.entidade.Item;
import org.serratec.java2.backend.marketplace.entidade.Usuario;
import org.serratec.java2.backend.marketplace.repositorio.ItemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
	@Autowired
	private ItemRepositorio itemRepositorio;
	
	private Item findById(Integer id)throws DataNotFoundException{
		Optional<Item>item = itemRepositorio.findById(id);
		if(item.isPresent()){
			return item.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Item buscaPorId (Integer id) throws DataNotFoundException{
		return findById(id);
	}
	
	public List<Item> buscaTodos(){
		return itemRepositorio.findAll();
	}
	
	@Transactional
	public Item incluiItem(Item item) {
		return itemRepositorio.save(item);
	}
	
	@Transactional
	public Item atualizaItem (Integer id, Item item ) throws DataNotFoundException {
		Item itemNovo = findById(id);
		item.setQuantidadeItem(itemNovo.getQuantidadeItem());
		item.setProduto(itemNovo.getProduto());
		return itemRepositorio.save(item);
	}
		
	@Transactional
	public void apagaItem(Integer id) throws DataNotFoundException {
		Item item = findById(id);
		itemRepositorio.delete(item);
	}
}
