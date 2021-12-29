package com.example.authenticationdemo.controllers;

import com.example.authenticationdemo.models.*;

import com.example.authenticationdemo.repositories.ClubRepository;
import com.example.authenticationdemo.repositories.StudentRepository;
import com.example.authenticationdemo.repositories.UserRepository;
import com.example.authenticationdemo.requests.CreateClubFormRequest;
import com.example.authenticationdemo.services.CreateClubFormService;
import com.example.authenticationdemo.services.CreateEventFormService;
import com.example.authenticationdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String home() {
        return ("Welcome");
    }


    @GetMapping("/admin")
    public String currentAdminName(Principal principal){
        return "Welcome "+ principal.getName();
    }

    @GetMapping("/allStudents")
    public List<Student> displayAllStudents(){
        return studentService.displayAllStudents();
    }
    
    @GetMapping("/findSpecificStudent/student_id={id}")
    public Optional<Student> getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @DeleteMapping ("/deleteStudent/{student_id}")
    public String deleteStudent(@PathVariable int student_id){
        Optional<Student> student = studentService.getStudent(student_id);
        if(student.isPresent()){
            studentService.deleteStudent(student.get());
            return "deleted student's id : " + student_id;
        }
        else{
            return "Nothing is found to delete";
        }
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
    public void deleteAllStudents(){
        studentService.deleteAllStudents();
    }

    @PutMapping("registerToEvent/student_id={student_id}/event_id={event_id}")
    public Event registerToEvent(@PathVariable int student_id, @PathVariable int event_id){
        return studentService.registerToEvent(student_id, event_id);
    }

    // postmapping- createClubForm()
    @PostMapping("/createClubFormStudent")
    public CreateClubForm addCreateClubForm(@RequestBody CreateClubFormRequest createClubFormRequest ){
        return studentService.addCreateClubForm(createClubFormRequest);
    }
    @GetMapping("/getStudentEventNotifications/student_id={student_id}")
    public List<SpecificEventNotification> getStudentEventNotifications(@PathVariable int student_id){
        return studentService.getStudentEventNotifications(student_id);
    }

    @PutMapping("student/exitFromClub/student_id={student_id}")
    public Club exitFromClub(@PathVariable int student_id){
        return studentService.exitFromClub(student_id);
    }
}
