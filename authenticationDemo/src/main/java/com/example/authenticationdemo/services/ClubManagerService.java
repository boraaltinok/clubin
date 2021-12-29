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
        ClubManager clubManager = clubManagerRepository.findById(club.getClubManager().getId()).orElse(null);
        if (club != null) {
            CreateEventForm createEventForm = createEventFormService.getCreateEventForm(eventCreateRequest.getForm_id()).orElse(null);
            createEventForm = new CreateEventForm();
            createEventForm.setPassedFromSac(false);
            createEventForm.setClubManager(clubManager);
            createEventForm.setSuccesfull(false);
            createEventForm.setOnline(false);
            createEventForm.setDean_id(eventCreateRequest.getDean_id());
            createEventForm.setSac_id(eventCreateRequest.getSac_id());
            createEventForm.setStudentActivityCenter(studentActivityCenterService.getStudentActivityCenter(eventCreateRequest.getSac_id()));
            createEventForm.setDeanOffice(deanOfficeService.getDeanOffice(eventCreateRequest.getDean_id()));
            createEventForm.setLocation(eventCreateRequest.getLocation());
            createEventForm.setDescription(eventCreateRequest.getDescription());
            createEventForm.setScheduledTime(eventCreateRequest.getDate());
            createEventForm.setId(eventCreateRequest.getForm_id());
            createEventForm.setCapacity(eventCreateRequest.getCapacity());
            createEventForm.setEventName(eventCreateRequest.getEventName());
            createEventForm.setEvent_id(eventCreateRequest.getEvent_id());
            createEventForm.setBudget(eventCreateRequest.getBudget());
            createEventForm.setGe_point(eventCreateRequest.getGe_point());
            createEventForm.setEndDate(eventCreateRequest.getEndDate());
            createEventFormService.saveToRepo(createEventForm);
            return createEventForm;
        } else {
            System.out.println("Exception in addEvenToClu in managerService");
            return null;
        }
    }

}
