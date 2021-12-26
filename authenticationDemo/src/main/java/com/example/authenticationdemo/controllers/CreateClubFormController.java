package com.example.authenticationdemo.controllers;

import com.example.authenticationdemo.models.CreateClubForm;
import com.example.authenticationdemo.requests.CreateClubFormRequest;
import com.example.authenticationdemo.services.CreateClubFormService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CreateClubFormController {
    CreateClubFormService createClubFormService;

    public CreateClubFormController(CreateClubFormService createClubFormService){
        this.createClubFormService  = createClubFormService;
    }
    //planned methods for CreateClubFormController
    //getAllCreatedClubForms
    //getOneCreatedClubFormsById
    //getOneCreatedClubFormsByStudent(int studentId)
    //createClubForm (CreateClubFormRequest createFormRequest)

    @GetMapping("/allCreateClubForms")
    public List<CreateClubForm> getAllCreateClubForms(){
        return createClubFormService.getAllCreateClubForms();
    }

    @GetMapping("/findCreatedFormsByStudent/student_id={student_id}")
    public List<CreateClubForm> getCreatedClubFormsByStudent(@PathVariable int student_id){
        return createClubFormService.getCreatedClubFormsByStudent(student_id);
    }

    @GetMapping("/createClubFormviaClub/student_id={student_id}")
    public CreateClubForm addCreateClubForm(CreateClubFormRequest createClubFormRequest, @PathVariable int student_id ){
        return createClubFormService.addCreateClubForm(createClubFormRequest, student_id);
    }
}
