package com.example.pedalboardDesigner.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository <Type, Long>{
	List<Type> findByName(String name);
}
