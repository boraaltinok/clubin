package com.example.authenticationdemo.services;

import com.example.authenticationdemo.models.*;
import com.example.authenticationdemo.repositories.ClubRepository;
import com.example.authenticationdemo.repositories.EventRepository;
import com.example.authenticationdemo.repositories.StudentRepository;
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

    public void deleteStudent(int id) {
        Optional<Student> deletedStudent = studentRepository.findById(id);
        studentRepository.deleteById(id);
        studentRepository.delete(deletedStudent.get());
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
}
