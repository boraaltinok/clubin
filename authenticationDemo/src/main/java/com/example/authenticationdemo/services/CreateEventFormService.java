package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.CreateEventForm;
import com.example.authenticationdemo.repositories.CreateEventFormRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateEventFormService {
    CreateEventFormRepository eventFormRepository;

    public CreateEventFormService(CreateEventFormRepository createEventFormRepository){
        this.eventFormRepository = createEventFormRepository;
    }

    public List<CreateEventForm> getAllCreateEventForms() {
        return eventFormRepository.findAll();
    }


    public Optional<CreateEventForm> getCreateEventForm(int id){
        return eventFormRepository.findById(id);
    }


    public CreateEventForm saveToRepo(CreateEventForm eventForm){
        return eventFormRepository.save(eventForm);
    }
}
