package org.serratec.java2.backend.marketplace.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.java2.backend.marketplace.entidade.PedidoCompra;
import org.serratec.java2.backend.marketplace.service.DataNotFoundException;
import org.serratec.java2.backend.marketplace.service.PedidoCompraService;
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
@RequestMapping("/pedidocompra")
public class PedidoCompraController {
	
	@Autowired
	private PedidoCompraService pedidoCompraService;
	
	@GetMapping
	public List <PedidoCompra>buscaTodos(){
		return pedidoCompraService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public PedidoCompra buscaPorId(@PathVariable Integer id) throws DataNotFoundException{
		return pedidoCompraService.buscaPorId(id);
	}
	
	@PostMapping
	public PedidoCompra inclui(@Valid @RequestBody PedidoCompra pedidoCompra ) {
		return pedidoCompraService.incluiPedidoCompra(pedidoCompra);
	}
	
	@PutMapping("/{id}")
	public PedidoCompra atualiza(@PathVariable Integer id, @Valid @RequestBody PedidoCompra pedidoCompra ) throws DataNotFoundException {
		return pedidoCompraService.atualizaPedidoCompra(id, pedidoCompra);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity apaga(@PathVariable Integer id) throws DataNotFoundException {
		pedidoCompraService.apagaPedidoCompra(id);
		return ResponseEntity.ok().build();
	}

}
