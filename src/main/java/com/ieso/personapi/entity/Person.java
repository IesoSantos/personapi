/**
 * 
 */
package com.ieso.personapi.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ieso.personapi.dto.PersonDTO;
import com.ieso.personapi.dto.PhoneDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = true)
	private LocalDate birthDate;
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Phone> phones;
	
	public static Person toModel(PersonDTO personDTO) {
		Person person = new Person();
		person.setId(personDTO.getId());
		person.setFirstName(personDTO.getFirstName());
		person.setLastName(personDTO.getLastName());
		person.setCpf(personDTO.getCpf());
		person.setBirthDate(
				LocalDate.parse(
						personDTO.getBirthDate(), 
						DateTimeFormatter.ofPattern("ss/MM/yyyy")
						)
				);
		if(personDTO.getPhones()!=null) {
			List<Phone> phones = new ArrayList<Phone>();
			for(PhoneDTO dto:personDTO.getPhones()) {
				phones.add(Phone.toModel(dto));
			}
			person.setPhones(phones);
		}
		return person;
	}
}
