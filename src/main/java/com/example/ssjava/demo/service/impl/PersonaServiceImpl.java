package com.example.ssjava.demo.service.impl;

import com.example.ssjava.demo.entity.PersonaEntity;
import com.example.ssjava.demo.repository.PersonaRepository;
import com.example.ssjava.demo.service.PersonaService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public List<PersonaEntity> getAllPerson() {
        return personaRepository.findAll();
    }

    @Override
    public PersonaEntity getPersonById(Integer idPerson) {
        return personaRepository.findById(Long.valueOf(idPerson)).orElse(null);
    }

    @Override
    public PersonaEntity createPerson(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @Override
    public PersonaEntity updatePerson(PersonaEntity persona) {
        return personaRepository.save(persona);
    }
}
