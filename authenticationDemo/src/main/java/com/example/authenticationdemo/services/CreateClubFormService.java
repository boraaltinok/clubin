package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.*;
import com.example.authenticationdemo.repositories.CreateClubFormRepository;
import com.example.authenticationdemo.repositories.StudentRepository;
import com.example.authenticationdemo.requests.CreateClubFormRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class CreateClubFormService {

    CreateClubFormRepository createClubFormRepository;
    StudentService studentService;
    StudentActivityCenterService studentActivityCenterService;
    DeanOfficeService deanOfficeService;
    UserService userService;


    public CreateClubFormService(CreateClubFormRepository createClubFormRepository, StudentService studentService,
                                 StudentActivityCenterService studentActivityCenterService,
                                 DeanOfficeService deanOfficeService, UserService userService) {
        this.createClubFormRepository = createClubFormRepository;
        this.studentService = studentService;
        this.studentActivityCenterService = studentActivityCenterService;
        this.deanOfficeService = deanOfficeService;
        this.userService = userService;
    }

    public List<CreateClubForm> getAllCreateClubForms() {
        return createClubFormRepository.findAll();
    }

    public List<CreateClubForm> getCreatedClubFormsByStudent(int student_id) {
        Student student = studentService.getStudent(student_id).get();
        return List.copyOf(student.getCreatedClubForm());
    }

    //createClubFormRequest has four properties, student_id, deanOffice_id, studentActivityCenter_id, isSuccessful = false
    public CreateClubForm addCreateClubForm(CreateClubFormRequest createClubFormRequest, int student_id){
        CreateClubForm clubForm = createClubFormRepository.findById(createClubFormRequest.getCreateClubForm_id()).orElse(null);
        if(clubForm == null){
            //CreateClubForm createClubForm = new CreateClubForm();
//            Student student = (Student)userService.findById(createClubFormRequest);
            clubForm = new CreateClubForm();
            StudentActivityCenter studentActivityCenter = (StudentActivityCenter)userService.findById(createClubFormRequest.getStudentActivityCenter_id());
            DeanOffice deanOffice = (DeanOffice)userService.findById(createClubFormRequest.getDeanOffice_id());
            clubForm.setSuccesfull(false);
            Student student = studentService.getStudent(student_id).orElse(null);
            clubForm.setCreatorStudent(student);
            clubForm.setDeanOffice(deanOffice);
            clubForm.setStudentActivityCenter(studentActivityCenter);
            clubForm.setId(createClubFormRequest.getCreateClubForm_id());
            createClubFormRepository.save(clubForm);
            studentActivityCenterService.addPendingCreateClubForm(createClubFormRequest);
            return clubForm;
        }
        else{
            System.out.println("Club form is already on the list");
            return null;
        }
    }


    public Optional<CreateClubForm> findById(int id){
        return createClubFormRepository.findById(id);
        /*CreateClubForm form = createClubFormRepository.findById(id).orElse(null);
        if(form != null){
            return form;
        }
        else{
            System.out.println("CreateClubForm is null ---------------------- DEBUG");
            return null;
        }

         */
    }

    public List<CreateClubForm> findAll(){
        return createClubFormRepository.findAll();
    }

    public CreateClubForm saveForm(CreateClubForm form){
        return createClubFormRepository.save(form);
    }

    public void deleteForm(int id){
        createClubFormRepository.deleteById(id);
    }
    /*public CreateClubForm addCreateClubForm(CreateClubFormRequest createClubFormRequest) {
    }

     */
}
