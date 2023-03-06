package com.subrutin.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
// {DIGUNAKAN JIKA ENTITY MEMILIKI BANYAK KOLOM}
//@DynamicUpdate
@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id = ?")
@Where(clause = "deleted=false")
public class Author{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name = "author_generator", sequenceName = "auhtor_id_seq")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@Column(name = "deleted", columnDefinition = "boolean default false")
	private Boolean deleted;
}
