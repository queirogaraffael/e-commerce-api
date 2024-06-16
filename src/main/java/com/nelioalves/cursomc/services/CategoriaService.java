package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.entities.Categoria;
import com.nelioalves.cursomc.model.dto.CategoriaDTO;
import com.nelioalves.cursomc.model.projection.CategoriaProjection;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.exceptions.ResourceNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositorio;

	public Categoria insert(Categoria categoria) {
		return repositorio.save(categoria);
	}

	public List<CategoriaDTO> findAll() {
		List<CategoriaProjection> categorias = repositorio.findAllBy();
		return categorias.stream().map(categoria -> new CategoriaDTO(categoria.getId(), categoria.getNome()))
				.collect(Collectors.toList());

	}

	public CategoriaDTO findById(Integer id) {

		CategoriaProjection categoria = repositorio.findProjectedById(id);
		if (categoria == null) {
			throw new ResourceNotFoundException(id);
		}
		return new CategoriaDTO(categoria.getId(), categoria.getNome());
	}

	public CategoriaDTO update(Integer id, Categoria categoriaUpdated) {
		Optional<Categoria> optionalCategoria = repositorio.findById(id);
		if (optionalCategoria.isPresent()) {
			Categoria categoria = optionalCategoria.get();
			categoria.setNome(categoriaUpdated.getNome());

			repositorio.save(categoria);

			return new CategoriaDTO(categoria.getId(), categoria.getNome());

		} else {
			return null;
		}
	}

}
