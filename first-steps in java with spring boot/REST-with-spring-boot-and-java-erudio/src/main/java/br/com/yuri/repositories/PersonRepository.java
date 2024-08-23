package br.com.yuri.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.yuri.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
