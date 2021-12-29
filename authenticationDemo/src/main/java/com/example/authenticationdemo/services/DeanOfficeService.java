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
    CreateEventFormService createEventFormService;
    UserService userService;
    EventService eventService;


    public DeanOfficeService(DeanOfficeRepository deanOfficeRepository,@Lazy StudentService studentService,
                             @Lazy CreateClubFormService createClubFormService, ClubService clubService,
                             @Lazy ClubManagerService clubManagerService, CreateEventFormService createEventFormService,
                             UserService userService,
                             EventService eventService) {
        this.deanOfficeRepository = deanOfficeRepository;
        this.studentService = studentService;
        this.createClubFormService = createClubFormService;
        this.clubService = clubService;
        this.clubManagerService = clubManagerService;
        this.createEventFormService = createEventFormService;
        this.userService = userService;
        this.eventService = eventService;
    }

    public DeanOffice getDeanOffice(int id) {
        return deanOfficeRepository.findById(id).get();
    }

    public DeanOffice createDeanOffice(DeanOffice deanOffice) {
        return deanOfficeRepository.save(deanOffice);
    }

    public CreateEventForm takeCreateEventForm(CreateEventForm form){
        DeanOffice deanOffice = deanOfficeRepository.getById(form.getDean_id());
        if(form != null && deanOffice != null ){
            form.setPassedFromSac(true);
            deanOffice.addCreateEventForms(form);
            return  form;
        }
        else{
            return null;
        }
    }

    public CreateClubForm takeCreateClubForm(CreateClubForm clubForm) {
        DeanOffice deanOffice = deanOfficeRepository.getById(clubForm.getDean_id());
        //CreateClubForm clubForm = createClubFormService.findById(request.getCreateClubForm_id());
        if (clubForm != null && deanOffice != null) {
            clubForm.setPassedFromSac(true);
            deanOffice.addCreateClubForms(clubForm);
            return clubForm;
        } else {
            return null;
        }
    }

    public CreateEventForm answerCreateEventForm(int form_id){
        Optional<CreateEventForm> createEventForm = createEventFormService.getCreateEventForm(form_id);
        DeanOffice deanOffice = deanOfficeRepository.getById(createEventForm.get().getDean_id());
        System.out.println(createEventForm.get().getBudget() + " ____ " + createEventForm.get().getId());
        if(createEventForm.isPresent() && deanOffice != null){
            if(createEventForm.get().isPassedFromSac()){
                createEventForm.get().setPassedFromSac(true);
                createEventForm.get().setSuccesfull(true);
                deanOffice.deleteCreateEventForm(createEventForm.get());
                Event event = new Event();
                event.setDependentClub(clubService.displaySpecificClub(createEventForm.get().getClub_id()).orElse(null));
                event.setId(createEventForm.get().getEvent_id());
                event.setCapacity(createEventForm.get().getCapacity());
                event.setStartingTime(createEventForm.get().getScheduledTime());
                event.setEndingTime(createEventForm.get().getEndDate());
                event.setBudget(createEventForm.get().getBudget());
                event.setOnline(createEventForm.get().isOnline());
                event.setGePoint(createEventForm.get().getGe_point());
                event.setName(createEventForm.get().getEventName());
                event.setDescription(createEventForm.get().getDescription());
                event.setPassed(false);
                eventService.createEvent(event);
                eventService.assignEventsNotification(event.getDependentClub().getId(), event.getId());

                return createEventForm.get();
            }
            else{
                System.out.println("Create event form firstly need to be revised by StudentActivityCenter");
                return null;
            }
        }
        else{
            System.out.println("Dean office is not exists");
            return null;
        }
    }

    public CreateClubForm answerCreateClubForm(int form_id) {
        Optional<CreateClubForm> clubForm = createClubFormService.findById(form_id);
        DeanOffice deanOffice = deanOfficeRepository.getById(clubForm.get().getDean_id());

        if (clubForm != null && deanOffice != null ) {
            if(clubForm.get().isPassedFromSac()){
                //find the attached student for createClubFormRequest
                Student student = studentService.getStudent(clubForm.get().getStudent_id()).orElse(null);
                //take the student parameter and make it club manager and create the club.
                if(student != null)  {
                    clubForm.get().setPassedFromSac(true);
                    clubForm.get().setSuccesfull(true);
                    deanOffice.deleteCreateClubForm(clubForm.get());
                    Club club = new Club();
                    club.setId(clubForm.get().getClub_id());
                    club.setName(clubForm.get().getClubName());
                    club.setDescription(clubForm.get().getDescription());
                    club.setContactInfo(clubForm.get().getContactInfo());
                    clubService.addClub(club);
                    ClubManager manager = new ClubManager();
                    manager.setEmail(student.getEmail());
                    manager.setMyClub(club);
                    manager.setId(student.getId() + 1);
                    manager.setPassword(student.getPassword());
                    manager.setName(student.getName());
                    manager.setSurname(student.getSurname());
                    club.setClubManager(manager);
                    clubManagerService.createManager(manager);
                    studentService.updateStudentAccess(student);
                    return clubForm.get();
                }
                else {
                    System.out.println("Student is null");
                    return null;
                }
            }
            else {
                System.out.println("Club form need to be evalueated by StudentActivityCenter.");
                return null;
            }
        }
        else{
            System.out.println("Dean office or clubForm is null");
            return null;
        }
    }

    public List<CreateClubForm> getAllCreateClubForms(int dean_id) {
        DeanOffice deanOffice = deanOfficeRepository.getById(dean_id);
        return List.copyOf(deanOffice.getCreateClubForms());
    }

    public List<CreateEventForm> getAllCreateEventForms(int dean_id) {
        return createEventFormService.getAllCreateEventForms();
    }
}
