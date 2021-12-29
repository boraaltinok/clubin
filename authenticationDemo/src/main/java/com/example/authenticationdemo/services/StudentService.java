package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.*;
import com.example.authenticationdemo.repositories.ClubRepository;
import com.example.authenticationdemo.repositories.CreateClubFormRepository;
import com.example.authenticationdemo.repositories.EventRepository;
import com.example.authenticationdemo.repositories.StudentRepository;
import com.example.authenticationdemo.requests.CreateClubFormRequest;
import org.hibernate.event.service.spi.EventListenerRegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    CreateClubFormRepository createClubFormRepository;
    @Autowired
    UserService userService;
    @Autowired
    StudentActivityCenterService studentActivityCenterService;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> displayAllStudents() {
        List<Student> allStudents = studentRepository.findAll();
        return allStudents;

    }

    public Optional<Student> getStudent(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student;
    }

    public void deleteStudent(Student student) {
        /*List<CreateClubForm> forms = createClubFormRepository.findByStudentId(student.getId());
        for (CreateClubForm form: forms
        ) {
            createClubFormRepository.deleteById(form.getId());
        }
        Set<Club> clubs = new HashSet<>();
        Set<Event> events = new HashSet<>();
        student.setRegisteredClubs(clubs);
        student.setRegisteredEvents(events);

         */
        Set<Club> clubSet = new HashSet<>();
        Set<Event> events = new HashSet<>();
        events = student.getRegisteredEvents();

        student.setRegisteredEvents(events);
        student.setRegisteredClubs(clubSet);
        studentRepository.delete(student);
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Club joinToClub(int club_id, int student_id){
        Club selectedClub = clubRepository.findById(club_id).get();//finding the club
        Student student = studentRepository.findById(student_id).get();//finding the user
        selectedClub.registerStudentToClub(student);//adding user to the club members

        return clubRepository.save(selectedClub);//saving and returning the club
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    public Event registerToEvent(int student_id, int event_id) {
        Student student = studentRepository.findById(student_id).get();
        Event event = eventRepository.findById(event_id).get();

        event.registerStudentToEvent(student);
        student.registerToEvent(event);

        studentRepository.save(student);

        return eventRepository.save(event);


    }

    //createClubFormRequest has four properties, student_id, deanOffice_id, studentActivityCenter_id, isSuccessful = false
    public CreateClubForm addCreateClubForm(CreateClubFormRequest createClubFormRequest) {
        CreateClubForm clubForm = createClubFormRepository.findById(createClubFormRequest.getCreateClubForm_id()).orElse(null);
        if (clubForm == null) {
            //CreateClubForm createClubForm = new CreateClubForm();
//            Student student = (Student)userService.findById(createClubFormRequest);
            clubForm = new CreateClubForm();
            StudentActivityCenter studentActivityCenter = (StudentActivityCenter) userService.findById(createClubFormRequest.getStudentActivityCenter_id());
            DeanOffice deanOffice = (DeanOffice) userService.findById(createClubFormRequest.getDeanOffice_id());
            clubForm.setSuccesfull(false);
            clubForm.setPassedFromSac(false);
            clubForm.setClubName(createClubFormRequest.getClubName());
//            clubForm.setStudentId(createClubFormRequest.getStudent_id());
            Student student = getStudent(createClubFormRequest.getStudent_id()).orElse(null);
            clubForm.setId(createClubFormRequest.getCreateClubForm_id());
            clubForm.setStudent_id(student.getId());
            clubForm.setCreatorStudent(student);
            clubForm.setDeanOffice(deanOffice);
            clubForm.setStudentActivityCenter(studentActivityCenter);
            clubForm.setId(createClubFormRequest.getCreateClubForm_id());
            clubForm.setSac_id(createClubFormRequest.getStudentActivityCenter_id());
            clubForm.setDean_id(createClubFormRequest.getDeanOffice_id());
            clubForm.setDescription(createClubFormRequest.getDescription());
            clubForm.setContactInfo(createClubFormRequest.getContactInfo());
            createClubFormRepository.save(clubForm);
            //studentActivityCenterService.addPendingCreateClubForm(createClubFormRequest);
            return clubForm;
        } else {
            System.out.println("Club form is already on the list");
            return null;
        }
    }
    /*
    * Finds the student by student_id
    * Gets the all the clubs a student is registered to
    * Gets an event, finds its notification adds it on list and repeats until all notifications
    * */
    public List<SpecificEventNotification> getStudentEventNotifications(int student_id) {
        Student student = studentRepository.findById(student_id).orElse(null);
        Set<SpecificEventNotification> studentsAllNotifications = new HashSet<>();
        List<Event> studentRegisteredEvents =List.copyOf(student.getRegisteredEvents());

        for(int i = 0; i < studentRegisteredEvents.size(); i++){
            studentsAllNotifications.add(studentRegisteredEvents.get(i).getSpecificEventNotification());
        }
        return List.copyOf(studentsAllNotifications);
    }

    public Student updateStudentAccess(Student student){
        /*
        String newUserName = student.getName() +  "_old?";
        String newPassword = student.getPassword() + "_old?";
        student.setName(newUserName);
        student.setName(newPassword);
        studentRepository.save(student);
        return student;

         */
        studentRepository.deleteById(student.getId());
        return null;
    }
    public Club exitFromClub(int student_id) {
    //    Student student = studentRepository.findById(student_id).orElse(null);
        return null;
    }
}
