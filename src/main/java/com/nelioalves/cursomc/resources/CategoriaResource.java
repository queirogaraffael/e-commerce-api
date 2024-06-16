package com.nelioalves.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.entities.Categoria;
import com.nelioalves.cursomc.model.dto.CategoriaDTO;
import com.nelioalves.cursomc.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@PostMapping
	public ResponseEntity<Categoria> insert(@RequestBody Categoria categoria) {
		Categoria novaCategoria = service.insert(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> categorias = service.findAll();
		return ResponseEntity.ok(categorias);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id) {
		CategoriaDTO categoria = service.findById(id);
		return ResponseEntity.ok(categoria);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody Categoria categoriaUpdated) {

		CategoriaDTO categoria = service.update(id, categoriaUpdated);
		return ResponseEntity.ok(categoria);
	}

}