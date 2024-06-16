package com.nelioalves.cursomc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.entities.Categoria;
import com.nelioalves.cursomc.model.projection.CategoriaProjection;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	List<CategoriaProjection> findAllBy();

	CategoriaProjection findProjectedById(Integer id);
}
