/**
 * 
 */
package com.ieso.personapi.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieso.personapi.dto.PersonDTO;
import com.ieso.personapi.dto.response.MessageResponseDTO;
import com.ieso.personapi.entity.Person;
import com.ieso.personapi.exception.PersonNotFoundException;
import com.ieso.personapi.repository.PersonRepository;

import lombok.AllArgsConstructor;

/**
 * @author Anderson dos Reis Santos
 *
 */

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave = Person.toModel(personDTO);
		Person savedPerson = personRepository.save(personToSave);
		return createMessageResponse(savedPerson.getId(), "Created person with Id: ");
	}
	
	
	public List<PersonDTO> listAll(){
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream()
				//.map(personMapper::toDTO)
				.map(PersonDTO::toDTO)
				.collect(Collectors.toList());
	}


	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		return PersonDTO.toDTO(person);
		//
		//Optional<Person> optionalPerson =  personRepository.findById(id);
		//if(optionalPerson.isEmpty()) {
		//	throw new PersonNotFounException(id);
		//}
		//return personMapper.toDTO(optionalPerson.get());
		
	}

	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		personRepository.deleteById(id);;		
	}


	public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		verifyIfExists(id);
		Person personToUpdate = Person.toModel(personDTO);
		Person updatedPerson = personRepository.save(personToUpdate);
		return createMessageResponse(updatedPerson.getId(), "Updated person with Id: ");
	}
	
	
	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id)
		.orElseThrow(() -> new PersonNotFoundException(id) );
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message+id)
				.build();
	}
	
	
}
