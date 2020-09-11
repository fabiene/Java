package org.serratec.java2.backend.marketplace.service;

import java.util.List;
import java.util.Optional;

import org.serratec.java2.backend.marketplace.entidade.PedidoCompra;
import org.serratec.java2.backend.marketplace.entidade.Usuario;
import org.serratec.java2.backend.marketplace.repositorio.PedidoCompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoCompraService {
	@Autowired
	private PedidoCompraRepositorio pedidoCompraRepositorio;
	
	private PedidoCompra findById(Integer id)throws DataNotFoundException{
		Optional<PedidoCompra>pedidoCompra = pedidoCompraRepositorio.findById(id);
		if(pedidoCompra.isPresent()){
			return pedidoCompra.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public PedidoCompra buscaPorId (Integer id) throws DataNotFoundException{
		return findById(id);
	}
	
	public List<PedidoCompra> buscaTodos(){
		return pedidoCompraRepositorio.findAll();
	}
	
	@Transactional
	public PedidoCompra incluiPedidoCompra(PedidoCompra pedidoCompra) {
		return pedidoCompraRepositorio.save(pedidoCompra);
	}
	
	@Transactional
	public PedidoCompra atualizaPedidoCompra (Integer id, PedidoCompra pedidoCompra ) throws DataNotFoundException {
		PedidoCompra pedidoCompraNovo = findById(id);
		pedidoCompra.setDataPedido(pedidoCompraNovo.getDataPedido());
		return pedidoCompraRepositorio.save(pedidoCompra);
	}
	
	@Transactional
	public void apagaPedidoCompra(Integer id) throws DataNotFoundException {
		PedidoCompra pedidoCompra = findById(id);
		pedidoCompraRepositorio.delete(pedidoCompra);
	}
}
