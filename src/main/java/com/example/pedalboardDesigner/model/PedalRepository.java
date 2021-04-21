package com.example.pedalboardDesigner.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedalRepository extends CrudRepository <Pedal, Long>{
	List<Pedal> findByName(String name);
}
