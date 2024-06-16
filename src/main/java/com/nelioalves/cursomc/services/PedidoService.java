package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.entities.Pedido;
import com.nelioalves.cursomc.repositories.PedidoRepository;
import com.nelioalves.cursomc.services.exceptions.ResourceNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repositorio;

	public Pedido findById(Integer id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));

	}

}
