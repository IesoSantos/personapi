/**
 * 
 */
package com.ieso.personapi.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.ieso.personapi.entity.Person;
import com.ieso.personapi.entity.Phone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

	private Long id;
	@NotEmpty
	@Size(min = 2, max = 100)
	private String firstName;
	@NotEmpty
	@Size(min = 2, max = 100)
	private String lastName;
	@NotEmpty
	@CPF
	private String cpf;
	
	private String birthDate;
	@Valid
	@NotEmpty
	private List<PhoneDTO> phones;
	
	public static PersonDTO toDTO(Person person) {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(person.getId());
		personDTO.setFirstName(person.getFirstName());
		personDTO.setLastName(person.getLastName());
		personDTO.setCpf(person.getCpf());
		personDTO.setBirthDate(person.getBirthDate().toString());
		if(person.getPhones()!=null) {
			List<PhoneDTO> phones = new ArrayList<PhoneDTO>();
			for(Phone phone: person.getPhones()) {
				phones.add(PhoneDTO.toDTO(phone));
			}
			personDTO.setPhones(phones);
		}
		return personDTO;
	}
}
