package com.example.authenticationdemo.sub;

import com.example.authenticationdemo.models.Student;
import com.example.authenticationdemo.repositories.StudentRepository;
import com.example.authenticationdemo.repositories.UserRepository;
import com.example.authenticationdemo.models.MyUserDetails;
import com.example.authenticationdemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentRepository studentRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Student> student = studentRepository.findByName(userName);

        student.orElseThrow(() -> new UsernameNotFoundException("Not found: "+ userName));
        return student.map(MyUserDetails::new).get();
    }
}
