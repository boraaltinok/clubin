package com.example.authenticationdemo.controllers;

import com.example.authenticationdemo.models.*;
import com.example.authenticationdemo.repositories.AllClubsRepository;
import com.example.authenticationdemo.repositories.ClubRepository;
import com.example.authenticationdemo.repositories.StudentRepository;
import com.example.authenticationdemo.repositories.UserRepository;
import com.example.authenticationdemo.services.StudentService;
import com.example.authenticationdemo.sub.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    /*@Autowired
    UserRepository userRepository;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    AllClubsRepository allClubsRepository;*/

    @GetMapping("/")
    public String home() {
        return ("Welcome");
    }

    /*@GetMapping("/user/{id}")
    public Optional<User> currentUserName(@PathVariable int id){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //MyUserDetails myUserDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //Optional<User> curUser = userRepository.findById(myUserDetails.getId());
        Optional<User> curUser = userRepository.findById(id);
        if(curUser !=null){
            return curUser;
        }
        else{
            return null;
        }
    }*/

    @GetMapping("/admin")
    public String currentAdminName(Principal principal){
        return "Welcome "+ principal.getName();
    }

    @GetMapping("/allStudents")
    public List<Student> displayAllStudents(){
        return studentService.displayAllStudents();
    }
    /*@GetMapping("/allClubs")
    public List<Club> displayAllClubs(){
        List<Club> allClubs = clubRepository.findAll();
        return allClubs;
    }*/
    
    @GetMapping("/findSpecificStudent/student_id={id}")
    public Optional<Student> getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @DeleteMapping ("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "deleted student's id : "+ id;
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }


    @PutMapping("joinToClub/club_id={club_id}/student_id={student_id}")
    public Club joinToClub( @PathVariable int club_id, @PathVariable int student_id){
        return studentService.joinToClub(club_id, student_id);
    }

    @DeleteMapping("/deleteAllStudents")
    public void deleteALlStudents(){
        studentService.deleteAllStudents();
    }

    @PutMapping("/registerToEvent/student_id={student_id}/event_id={event_id}")
    public Event registerToEvent(@PathVariable int student_id, @PathVariable int event_id){
        return studentService.registerToEvent(student_id, event_id);
    }

    @GetMapping("/getStudentEventNotifications/student_id={student_id}")
    public List<SpecificEventNotification> getStudentEventNotifications(@PathVariable int student_id){
        return studentService.getStudentEventNotifications(student_id);
    }



}
