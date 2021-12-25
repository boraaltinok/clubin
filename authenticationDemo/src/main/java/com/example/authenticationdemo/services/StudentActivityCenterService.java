package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.CreateClubForm;
import com.example.authenticationdemo.models.CreateEventForm;
import com.example.authenticationdemo.models.Student;
import com.example.authenticationdemo.models.StudentActivityCenter;
import com.example.authenticationdemo.repositories.StudentActivityCenterRepository;
import com.example.authenticationdemo.repositories.StudentRepository;
import com.example.authenticationdemo.requests.CreateClubFormRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentActivityCenterService {
    StudentActivityCenterRepository studentActivityCenterRepository;
    DeanOfficeService deanOfficeService;
    CreateClubFormService createClubFormService;
    CreateEventFormService createEventFormService;

    public StudentActivityCenterService(@Lazy StudentActivityCenterRepository studentActivityCenterRepository, DeanOfficeService deanOfficeService, @Lazy  CreateClubFormService createClubFormService, CreateEventFormService createEventFormService) {
        this.studentActivityCenterRepository = studentActivityCenterRepository;
        this.deanOfficeService = deanOfficeService;
        this.createClubFormService = createClubFormService;
        this.createEventFormService = createEventFormService;
    }

    public StudentActivityCenter getStudentActivityCenter(int sac_id) {
        return studentActivityCenterRepository.findById(sac_id).get();
    }

    public CreateClubForm addPendingCreateClubForm(CreateClubFormRequest request) {
        StudentActivityCenter studentActivityCenter = studentActivityCenterRepository.findById(request.getStudentActivityCenter_id()).orElse(null);
        if(studentActivityCenter != null){
            Optional<CreateClubForm> clubForm = createClubFormService.findById(request.getCreateClubForm_id());
            studentActivityCenter.addCreateClubForm(clubForm.get());
            return clubForm.get();
        }
        else{
            System.out.println("SAC IS EMPTY DEBUG ---------------");
            return null;
        }
    }

    public CreateClubForm answerCreateClubForm( CreateClubFormRequest request) {
        CreateClubFormRequest result = null;
        StudentActivityCenter sac = studentActivityCenterRepository.findById(request.getStudentActivityCenter_id()).orElse(null);
        Optional<CreateClubForm> clubForm = createClubFormService.findById(request.getCreateClubForm_id());
        if(sac != null && clubForm != null){
            System.out.println("11111111111111111111111111111111111111111111111111111");
                deanOfficeService.takeCreateClubForm(request,clubForm.get());
            System.out.println("222222222222222222222222222222222222222222");
                Set<CreateClubForm> createClubForms = sac.getCreateClubForms();
                createClubForms.remove(clubForm);
                sac.setCreateClubForms(createClubForms);
                return clubForm.get();
        }
        else{
            System.out.println("SAC OR FORM IS NULL TO BE ANSWERED ------");
            return null;
        }
    }

    public StudentActivityCenter addStudent(StudentActivityCenter studentActivityCenter) {
        return studentActivityCenterRepository.save(studentActivityCenter);
    }

    public List<CreateClubForm> seeAllCreateClubForms() {
        return createClubFormService.findAll();
    }
}
