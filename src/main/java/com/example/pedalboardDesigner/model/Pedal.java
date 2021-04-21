package com.example.pedalboardDesigner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pedal {
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "type")
	private Type type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String brand;
	private int voltage;
	
	public Pedal() {}

	public Pedal(String name, String brand, int voltage, Type type) {
		super();
		this.type = type;
		this.name = name;
		this.brand = brand;
		this.voltage = voltage;
	}

	@Override
	public String toString() {
		return "Pedal [type=" + type + ", name=" + name + ", brand=" + brand + ", voltage=" + voltage
				+ "]";
	}

}
