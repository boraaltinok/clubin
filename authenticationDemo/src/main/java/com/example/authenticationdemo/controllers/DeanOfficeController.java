package com.example.authenticationdemo.controllers;


import com.example.authenticationdemo.models.CreateClubForm;
import com.example.authenticationdemo.models.CreateEventForm;
import com.example.authenticationdemo.models.DeanOffice;
import com.example.authenticationdemo.requests.CreateClubFormRequest;
import com.example.authenticationdemo.services.DeanOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DeanOfficeController {

    @Autowired
    DeanOfficeService deanOfficeService;

    //reach DeanOffice
    @GetMapping("/getAllCreateClubFormsInDeanOffice/dean_id={dean_id}")
    public List<CreateClubForm> getAllCreateClubForms(@PathVariable int dean_id) {
        return deanOfficeService.getAllCreateClubForms(dean_id);
    }

    //I didn't write like /deanOffice/deanOffice_id = {deanfOffice_id} because we only have one deanoffice.
    @GetMapping("/deanOffice/deanOffice_id = {deanOffice_id}")
    public DeanOffice getDeanOffice(@PathVariable int id) {
        return deanOfficeService.getDeanOffice(id);
    }

    @PostMapping("/addDeanOffice")
    public DeanOffice createDeanOffice(@RequestBody DeanOffice deanOffice) {
        return deanOfficeService.createDeanOffice(deanOffice);
    }

    @PostMapping("/answerCreateClubForm/form_id={form_id}")
    public CreateClubForm answerCreateClubForm(@PathVariable int form_id) {
        return deanOfficeService.answerCreateClubForm(form_id);
    }

    @PostMapping("/answerCreateEventForm/form_id={form_id}")
    public CreateEventForm answerCreateEventForm(@PathVariable int form_id){
        return deanOfficeService.answerCreateEventForm(form_id);
    }
}
