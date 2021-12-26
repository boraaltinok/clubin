package com.example.authenticationdemo.controllers;


import com.example.authenticationdemo.models.CreateClubForm;
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

    @PostMapping(value = "/addDeanOffice")
    public DeanOffice createDeanOffice(@RequestBody DeanOffice deanOffice) {
        return deanOfficeService.createDeanOffice(deanOffice);
    }

    @PostMapping("/answerCreateClubForm")
    public CreateClubForm answerCreateClubForm(@RequestBody CreateClubFormRequest request) {
        return deanOfficeService.answerCreateClubForm(request);
    }
}
