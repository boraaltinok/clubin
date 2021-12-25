package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.*;
import com.example.authenticationdemo.repositories.DeanOfficeRepository;
import com.example.authenticationdemo.requests.CreateClubFormRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.awt.desktop.UserSessionEvent;
import java.util.List;
import java.util.Optional;

@Service
public class DeanOfficeService {
    DeanOfficeRepository deanOfficeRepository;
    StudentService studentService;
    CreateClubFormService createClubFormService;
    ClubService clubService;
    ClubManagerService clubManagerService;
    //    ClubManagerService clubManagerService;

    UserService userService;

    public DeanOfficeService(@Lazy DeanOfficeRepository deanOfficeRepository, @Lazy StudentService studentService,@Lazy CreateClubFormService createClubFormService, ClubService clubService, UserService userService,
                                ClubManagerService clubManagerService) {
        this.deanOfficeRepository = deanOfficeRepository;
        this.studentService = studentService;
        this.createClubFormService = createClubFormService;
        this.clubService = clubService;
        this.userService = userService;
        this.clubManagerService = clubManagerService;
    }

    public DeanOffice getDeanOffice(int id) {
        return deanOfficeRepository.findById(id).get();
    }

    public DeanOffice createDeanOffice(DeanOffice deanOffice) {
        return deanOfficeRepository.save(deanOffice);
    }

    public CreateClubForm takeCreateClubForm(CreateClubFormRequest request, CreateClubForm clubForm) {
        DeanOffice deanOffice = deanOfficeRepository.getById(request.getDeanOffice_id());
        //CreateClubForm clubForm = createClubFormService.findById(request.getCreateClubForm_id());
        if (clubForm != null && deanOffice != null) {
            System.out.println("YETEERRRRRRRR :" + clubForm.getId());
            clubForm.setPassedFromSac(true);
            System.out.println("YETEERRRRRRRR :" + clubForm.getId());
            deanOffice.addCreateClubForms(clubForm);
            return clubForm;
        } else {
            return null;
        }
    }

    public CreateClubForm answerCreateClubForm(CreateClubFormRequest request) {
        DeanOffice deanOffice = deanOfficeRepository.getById(request.getDeanOffice_id());
        System.out.println("ILKKKK" + request.getCreateClubForm_id());
        System.out.println("------------------------31----------------------");
        Optional<CreateClubForm> clubForm = createClubFormService.findById(request.getCreateClubForm_id());
        System.out.println("IKINCIIIII");
        if (clubForm.isPresent() && deanOffice != null) {
            //find the attached student for createClubFormRequest
            Optional<Student> student = studentService.getStudent(request.getStudent_id());
                //take the student parameter and make it club manager and create the club.
            if(student.isPresent()) {
                clubForm.get().setPassedFromSac(true);
                clubForm.get().setSuccesfull(true);
                deanOffice.deleteCreateClubForm(clubForm.get());
                Club club = new Club();
                club.setId(request.getClub_id());
                club.setDescription(request.getDescription());
                club.setContactInfo(request.getContactInfo());
                club.setName(request.getClubName());
                studentService.deleteStudent(student.get().getId());
                ClubManager manager = new ClubManager();
                manager.setEmail(student.get().getEmail());
                manager.setMyClub(club);
                manager.setId(student.get().getId());
                manager.setPassword(student.get().getPassword());
                manager.setName(student.get().getName());
                manager.setSurname(student.get().getSurname());
                club.setClubManager(manager);
                clubService.addClub(club);

                //clubManagerService.createManager(manager);
                return clubForm.get();
            }
            else {
                    System.out.println("Student is null");
                    return null;
                }
            }
        else{
            System.out.println("Dean office or clubForm is null!!!!");
            return null;
        }
    }

    public List<CreateClubForm> getAllCreateClubForms(int dean_id) {
        DeanOffice deanOffice = deanOfficeRepository.getById(dean_id);
        return List.copyOf(deanOffice.getCreateClubForms());
    }
}
