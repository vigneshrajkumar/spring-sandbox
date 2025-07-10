package com.rajkumarv.sandbox.service;

import com.rajkumarv.sandbox.dto.PersonDto;
import com.rajkumarv.sandbox.model.Person;
import com.rajkumarv.sandbox.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDto> findAll() {
        return personRepository.findAll().stream()
                .map(p -> new PersonDto(p.getId(), p.getName()))
                .toList();
    }

    public Optional<PersonDto> findById(Long id) {
        return personRepository.findById(id)
                .map(p -> new PersonDto(p.getId(), p.getName()));
    }

    public PersonDto save(Long id, PersonDto personDto) {
        Person toSave = new Person(id, personDto.name());
        Person saved = personRepository.save(toSave);
        return new PersonDto(saved.getId(), saved.getName());
    }

    public boolean deleteById(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
