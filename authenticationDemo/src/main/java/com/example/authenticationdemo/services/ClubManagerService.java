package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.*;
import com.example.authenticationdemo.repositories.ClubManagerRepository;
import com.example.authenticationdemo.requests.EventCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ClubManagerService {
    @Autowired
    ClubManagerRepository clubManagerRepository;
    ClubService clubService;
    StudentActivityCenterService studentActivityCenterService;
    DeanOfficeService deanOfficeService;
    CreateEventFormService createEventFormService;


    public ClubManagerService(ClubService clubService,
                              StudentActivityCenterService studentActivityCenterService,
                              DeanOfficeService deanOfficeService,
                              CreateEventFormService createEventFormService) {
        this.clubService = clubService;
        this.studentActivityCenterService = studentActivityCenterService;
        this.deanOfficeService = deanOfficeService;
        this.createEventFormService = createEventFormService;
    }

    public ClubManager createManager(ClubManager manager) {
        return clubManagerRepository.save(manager);
    }


    public List<ClubManager> seeAllManagers() {
        return clubManagerRepository.findAll();
    }

    public CreateEventForm addEventToClub(EventCreateRequest eventCreateRequest) {
        Club club = clubService.displaySpecificClub(eventCreateRequest.getClub_id()).orElse(null);
        ClubManager clubManager = club.getClubManager();
        System.out.println("Club manager ID: " + clubManager.getId());
        if (club != null) {
            System.out.println("0000000000000000000");
            CreateEventForm createEventForm = createEventFormService.getCreateEventForm(eventCreateRequest.getForm_id()).orElse(null);
            createEventForm = new CreateEventForm();
            System.out.println("?==??====???");
            createEventForm.setPassedFromSac(false);
            System.out.println("11111111");
            createEventForm.setClubManager(clubManager);
            System.out.println("2222222");
            createEventForm.setSuccesfull(false);
            createEventForm.setOnline(false);
            createEventForm.setDean_id(eventCreateRequest.getDean_id());
            System.out.println("3333333");
            createEventForm.setSac_id(eventCreateRequest.getSac_id());
            createEventForm.setStudentActivityCenter(studentActivityCenterService.getStudentActivityCenter(eventCreateRequest.getSac_id()));
            createEventForm.setDeanOffice(deanOfficeService.getDeanOffice(eventCreateRequest.getDean_id()));
            System.out.println("4444444");
            createEventForm.setLocation(eventCreateRequest.getLocation());
            System.out.println("5555555");
            createEventForm.setDescription(eventCreateRequest.getDescription());
            System.out.println("66666666");
            createEventForm.setScheduledTime(eventCreateRequest.getDate());
            System.out.println("7777777");
            createEventForm.setId(eventCreateRequest.getForm_id());
            System.out.println("888888");
            createEventForm.setCapacity(eventCreateRequest.getCapacity());
            createEventForm.setEventName(eventCreateRequest.getEventName());
            createEventForm.setEvent_id(eventCreateRequest.getEvent_id());
            createEventForm.setBudget(eventCreateRequest.getBudget());
            createEventForm.setGe_point(eventCreateRequest.getGe_point());
            createEventForm.setEndDate(eventCreateRequest.getEndDate());
            System.out.println("!!!!!!!!!!!!!!!!123  " + createEventForm.getId());
            createEventFormService.saveToRepo(createEventForm);
            return createEventForm;
        } else {
            System.out.println("Exception in addEvenToClu in managerService");
            return null;
        }
    }

}
