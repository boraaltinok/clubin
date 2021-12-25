package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.CreateEventForm;
import com.example.authenticationdemo.repositories.CreateEventFormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateEventFormService {
    CreateEventFormRepository eventFormRepository;

    public CreateEventFormService(CreateEventFormRepository createEventFormRepository){
        this.eventFormRepository = createEventFormRepository;
    }

    public List<CreateEventForm> getAllCreateEventForms() {
        return eventFormRepository.findAll();
    }
}
