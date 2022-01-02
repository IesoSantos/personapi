/**
 * 
 */
package com.ieso.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieso.personapi.entity.Person;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
