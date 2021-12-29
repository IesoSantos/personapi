/**
 * 
 */
package com.ieso.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ieso.personapi.entity.Person;

/**
 * @author Anderson dos Reis Santos
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
