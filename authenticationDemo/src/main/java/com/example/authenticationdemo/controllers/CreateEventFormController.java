package com.example.authenticationdemo.controllers;
import com.example.authenticationdemo.models.CreateEventForm;
import com.example.authenticationdemo.services.CreateEventFormService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CreateEventFormController {

    CreateEventFormService createEventFormService;

    public CreateEventFormController(CreateEventFormService createEventFormService){
        this.createEventFormService = createEventFormService;
    }

    @GetMapping ("/allCreateEventForms")
    public List<CreateEventForm> getAllCreateEventForms(){
        return createEventFormService.getAllCreateEventForms();
    }
}
