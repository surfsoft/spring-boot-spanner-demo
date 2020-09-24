package com.surfsoftconsulting.springboot.repository;

import org.springframework.data.repository.CrudRepository;

public interface PersonDAO extends CrudRepository<Person, Long> {
}
