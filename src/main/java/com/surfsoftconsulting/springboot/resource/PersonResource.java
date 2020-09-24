package com.surfsoftconsulting.springboot.resource;

import com.surfsoftconsulting.springboot.repository.Person;
import com.surfsoftconsulting.springboot.repository.PersonDAO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.OptionalLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/people")
public class PersonResource {

    private final PersonDAO peopleDAO;

    public PersonResource(PersonDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @RequestMapping(method = GET, path = "/{personId}")
    @Transactional
    public Person getPerson(@PathParam("personId") OptionalLong personId) {
        return findSafely(personId.getAsLong());
    }

    private Person findSafely(Long personId) {
        return peopleDAO.findById(personId).orElseThrow(() -> new RuntimeException("No such user."));
    }
}
