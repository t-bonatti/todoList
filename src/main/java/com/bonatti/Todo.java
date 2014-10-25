package com.bonatti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_todo", sequenceName = "seq_todo", allocationSize = 1)
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_todo")
	private Long id;
	
	private Boolean done;
	
	private String description;

}
