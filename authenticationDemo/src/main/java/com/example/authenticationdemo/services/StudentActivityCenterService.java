package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.CreateClubForm;
import com.example.authenticationdemo.models.CreateEventForm;
import com.example.authenticationdemo.models.Student;
import com.example.authenticationdemo.models.StudentActivityCenter;
import com.example.authenticationdemo.repositories.StudentActivityCenterRepository;
import com.example.authenticationdemo.repositories.StudentRepository;
import com.example.authenticationdemo.requests.CreateClubFormRequest;
import com.example.authenticationdemo.requests.EventCreateRequest;
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


    public StudentActivityCenterService(@Lazy StudentActivityCenterRepository studentActivityCenterRepository, DeanOfficeService deanOfficeService,
                                        @Lazy  CreateClubFormService createClubFormService,
                                        CreateEventFormService createEventFormService) {
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
            clubForm.get().setPassedFromSac(false);
            clubForm.get().setSuccesfull(false);
            clubForm.get().setClubName(request.getClubName());
            clubForm.get().setStudentActivityCenter(studentActivityCenter);
            clubForm.get().setSac_id(request.getStudentActivityCenter_id());
            clubForm.get().setDean_id(request.getDeanOffice_id());
            clubForm.get().setStudent_id(request.getStudent_id());
            //clubForm.get().setCreatorStudent(studentService.getStudent(request.getStudent_id()).orElse(null));
            studentActivityCenter.addCreateClubForm(clubForm.get());
            return clubForm.get();
        }
        else{
            System.out.println("Student activity center is not available in the system" );
            return null;
        }
    }

    public CreateEventForm addPendingCreateEventForm(EventCreateRequest request){
        StudentActivityCenter studentActivityCenter = studentActivityCenterRepository.findById(request.getSac_id()).orElse(null);
        if(studentActivityCenter != null){
            Optional<CreateEventForm> eventForm = createEventFormService.getCreateEventForm(request.getId());
            studentActivityCenter.addCreateEventForm(eventForm.get());
            return eventForm.get();
        }
        else{
            System.out.println("Student activity center is not available in the system.");
            return null;
        }
    }

    public CreateEventForm answerCreateEvenForm(EventCreateRequest request){
        return null;
    }


    public CreateEventForm answerCreateEventFormByInt(int id){
        Optional<CreateEventForm> createEventForm = createEventFormService.getCreateEventForm(id);
        StudentActivityCenter sac = studentActivityCenterRepository.findById(createEventForm.get().getSac_id()).orElse(null);
        if(sac != null && createEventForm.isPresent()){
            if(!createEventForm.get().isPassedFromSac()){
                deanOfficeService.takeCreateEventForm(createEventForm.get());
                Set<CreateEventForm> createEventForms = sac.getCreateEventForms();
                createEventForm.get().setPassedFromSac(true);
                createEventForms.remove(createEventForm.get());
                sac.setCreateEventForms(createEventForms);
                return createEventForm.get();
            }
            else{
                System.out.println("Form is already reviewed by the StudentActivityCenter");
                return null;
            }
        }
        else{
            System.out.println("Student activity center is required ");
            return null;
        }
    }

    public CreateClubForm answerCreateClubFormById(int form_id){
        Optional<CreateClubForm> createEventForm = createClubFormService.findById(form_id);
        System.out.println(createEventForm.get().getSac_id() + " _________________________");
        StudentActivityCenter sac = studentActivityCenterRepository.findById(createEventForm.get().getSac_id()).orElse(null);
        if(sac != null && createEventForm.isPresent()){
            if(!createEventForm.get().isPassedFromSac()){
                deanOfficeService.takeCreateClubForm(createEventForm.get());
               /* Set<CreateClubForm> createEventForms = sac.getCreateClubForms();
                createEventForm.get().setPassedFromSac(true);
                createEventForms.remove(createEventForm.get());
                sac.setCreateClubForms(createEventForms);

                */
               createEventForm.get().setPassedFromSac(true);
               createClubFormService.saveForm(createEventForm.get());
                return createEventForm.get();
            }
            else{
                System.out.println("Form is already reviewed by the StudentActivityCenter");
                return null;
            }
        }
        else{
            System.out.println("Student activity center is required ");
            return null;
        }
    }

   /* public CreateClubForm answerCreateClubForm( CreateClubFormRequest request) {
        CreateClubFormRequest result = null;
        StudentActivityCenter sac = studentActivityCenterRepository.findById(request.getStudentActivityCenter_id()).orElse(null);
        Optional<CreateClubForm> clubForm = createClubFormService.findById(request.getCreateClubForm_id());
        if(sac != null && clubForm.isPresent()){
                deanOfficeService.takeCreateClubForm(clubForm.get());
                Set<CreateClubForm> createClubForms = sac.getCreateClubForms();
                clubForm.get().setPassedFromSac(true);
                createClubForms.remove(clubForm.get());
                sac.setCreateClubForms(createClubForms);
                //createClubFormService.deleteForm(request.getCreateClubForm_id());
                //createClubFormService.saveForm(clubForm.get());
                return clubForm.get();
        }
        else{
            System.out.println("Student activity center account is required");
            return null;
        }
    }

    */

    public StudentActivityCenter addStudent(StudentActivityCenter studentActivityCenter) {
        return studentActivityCenterRepository.save(studentActivityCenter);
    }

    public List<CreateClubForm> seeAllCreateClubForms() {
        return createClubFormService.findAll();
    }


    public List<CreateEventForm> seeAllEventForms() {
        return createEventFormService.getAllCreateEventForms();
    }
}
