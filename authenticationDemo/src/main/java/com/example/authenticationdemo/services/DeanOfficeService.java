package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.Club;
import com.example.authenticationdemo.models.CreateClubForm;
import com.example.authenticationdemo.models.CreateEventForm;
import com.example.authenticationdemo.models.DeanOffice;
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
    //    ClubManagerService clubManagerService;

    UserService userService;

    public DeanOfficeService(@Lazy DeanOfficeRepository deanOfficeRepository, @Lazy StudentService studentService,@Lazy CreateClubFormService createClubFormService, ClubService clubService, UserService userService) {
        this.deanOfficeRepository = deanOfficeRepository;
        this.studentService = studentService;
        this.createClubFormService = createClubFormService;
        this.clubService = clubService;
        this.userService = userService;
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
                //take the student parameter and make it club manager and create the club.
                clubForm.get().setPassedFromSac(true);
                clubForm.get().setSuccesfull(true);
                deanOffice.deleteCreateClubForm(clubForm.get());
                Club club = new Club();
                club.setId(request.getClub_id());
                club.setName(request.getClubName());
                clubService.addClub(club);
                return clubForm.get();
        } else {
            System.out.println("CLUB FORM NULLLLLL");
            return null;
        }
    }

    public List<CreateClubForm> getAllCreateClubForms(int dean_id) {
        DeanOffice deanOffice = deanOfficeRepository.getById(dean_id);
        return List.copyOf(deanOffice.getCreateClubForms());
    }
}
