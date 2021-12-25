package com.example.authenticationdemo.controllers;


import com.example.authenticationdemo.models.CreateClubForm;
import com.example.authenticationdemo.models.Student;
import com.example.authenticationdemo.models.StudentActivityCenter;
import com.example.authenticationdemo.requests.CreateClubFormRequest;
import com.example.authenticationdemo.services.StudentActivityCenterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentActivityCenterController {
    StudentActivityCenterService studentActivityCenterService;

    public StudentActivityCenterController(StudentActivityCenterService studentActivityCenterService){
        this.studentActivityCenterService = studentActivityCenterService;
    }

    //getMapping
    @GetMapping("/studentActivityCenter/sac_id={sac_id}")
    public StudentActivityCenter getStudentActivityCenter(@PathVariable int sac_id){
        return studentActivityCenterService.getStudentActivityCenter(sac_id);
    }

    //adding waiting request to studentactivity center
    @PostMapping("/sac/addPendingCreateClubForm/sac_id={sac_id}/createForm_id={createForm_id}")
    public CreateClubForm addPendingCreateClubForm(@RequestBody CreateClubFormRequest request){
        return studentActivityCenterService.addPendingCreateClubForm(request);
    }

    @PutMapping("/sac/answerCreateClubForm")
    public CreateClubForm answerCreateClubForm(@RequestBody CreateClubFormRequest request){
        return studentActivityCenterService.answerCreateClubForm(request);
    }

    @PostMapping("/addStudentActivityCenter")
    public StudentActivityCenter addStudentActivityCenter(@RequestBody StudentActivityCenter studentActivityCenter){
        return studentActivityCenterService.addStudent(studentActivityCenter);
    }

    @GetMapping("sac/allCreateClubForms")
    public List<CreateClubForm> seeAllCreateClubForms(){
        return studentActivityCenterService.seeAllCreateClubForms();
    }

}
