package com.subrutin.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
// {DIGUNAKAN JIKA ENTITY MEMILIKI BANYAK KOLOM}
//@DynamicUpdate
@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id = ?")
@Where(clause = "deleted=false")
public class Author extends AbstractBaseEntity {

	private static final long serialVersionUID = 4415917570527208430L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
	@SequenceGenerator(name = "author_generator", sequenceName = "author_id_sequence")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Address> addresses;

}
