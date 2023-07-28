package com.example.entity;


import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Note {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
}
