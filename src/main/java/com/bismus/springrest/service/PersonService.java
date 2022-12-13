package com.bismus.springrest.service.entityService;


import com.bismus.springrest.exception.PersonByIdNotFoundException;
import com.bismus.springrest.exception.PersonByNameNotFoundException;
import com.bismus.springrest.exception.PersonTableIsEmptyException;
import com.bismus.springrest.model.Person;
import com.bismus.springrest.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll() {
        if (personRepository.findAll().isEmpty()) throw new PersonTableIsEmptyException();
        return personRepository.findAll();
    }

    public Person findById(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElseThrow(() -> new PersonByIdNotFoundException(id));
    }

    public List<Person> findByName(String name) {
        if (personRepository.findByName(name).isEmpty()) throw new PersonByNameNotFoundException(name);
        return personRepository.findByName(name);
    }

    @Transactional
    public void addNewPerson(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void updatePersonParam(int id, Person updatedPerson) {
        if (personRepository.findById(id).isPresent()) throw new PersonByIdNotFoundException(id);

        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

    @Transactional
    public void deletePerson(int id) {
        if (personRepository.findById(id).isPresent()) throw new PersonByIdNotFoundException(id);
        personRepository.deleteById(id);
    }

}
