package org.serratec.java2.backend.marketplace.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.java2.backend.marketplace.entidade.Item;
import org.serratec.java2.backend.marketplace.entidade.Item;
import org.serratec.java2.backend.marketplace.service.DataNotFoundException;
import org.serratec.java2.backend.marketplace.service.ItemService;
import org.serratec.java2.backend.marketplace.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public List <Item>buscaTodos(){
		return itemService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Item buscaPorId(@PathVariable Integer id) throws DataNotFoundException{
		return itemService.buscaPorId(id);
	}
	
	@PostMapping
	public Item inclui(@Valid @RequestBody Item item) {
		return itemService.incluiItem(item);
	}
	
	@PutMapping("/{id}")
	public Item atualiza(@PathVariable Integer id, @Valid @RequestBody Item item ) throws DataNotFoundException {
		return itemService.atualizaItem(id, item);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity apaga(@PathVariable Integer id) throws DataNotFoundException {
		itemService.apagaItem(id);
		return ResponseEntity.ok().build();
	}
}
