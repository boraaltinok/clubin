package com.example.authenticationdemo.sub;

import com.example.authenticationdemo.AllClubsRepository;
import com.example.authenticationdemo.ClubRepository;
import com.example.authenticationdemo.UserRepository;
import com.example.authenticationdemo.models.Club;
import com.example.authenticationdemo.models.MyUserDetails;
import com.example.authenticationdemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeResource{
    @Autowired
    UserRepository userRepository;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    AllClubsRepository allClubsRepository;

    MyUserDetailsService myUserDetailsService;
    @GetMapping("/")
    public String home() {
        return ("Welcome");
    }

    @GetMapping("/user")
    public String currentUserName(Principal principal){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        MyUserDetails myUserDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> curUser = userRepository.findById(myUserDetails.getId());



        return "DEAR " + curUser.get().getUserName() + " role : " + curUser.get().getRoles() + " FROM NOW ON YOUR PASSWORD IS KAKA";
    }
    @GetMapping("/admin")
    public String currentAdminName(Principal principal){
        return "Welcome "+ principal.getName();
    }
    @GetMapping("/allUsers")
    public List<User> displayAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }
    
    @GetMapping("/findSpecificUser/{id}")
    public Optional<User> getUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        return user;

    }
    @DeleteMapping ("/deleteSpecificUser/{id}")
    public String deleteUser(@PathVariable int id){
        Optional<User> deletedUser = userRepository.findById(id);
        userRepository.deleteById(id);
        return "deleted" + id ;
    }

    @RequestMapping("/addToClub/{cid}/{id}")//clubs id
    public String addUserToClub(@PathVariable int cid, @PathVariable int id){

        Optional<Club> selectedClub = allClubsRepository.findById(cid);//kulubü biliyoz
        selectedClub.get().setTotalMemberCount(5);
        allClubsRepository.save(selectedClub.get());
        //System.out.println(selectedClub.get().getTotalMemberCount());

        /*for(int i = 1; i <= selectedClub.get().getClubMembers().size(); i++){
            if(!(selectedClub.get().getClubMembers().get(i).getUserName().equals(null))) {
                System.out.println(selectedClub.get().getClubMembers().get(i).getUserName());
            }
        }*/
        /*Optional<User> addedUser = userRepository.findById(id);//useri biliyoz
        //selectedClub.get().getClubMembers().add(addedUser.get()); //user eklendi

        selectedClub.get().setTotalMemberCount(selectedClub.get().getTotalMemberCount() + 1);
        clubRepository.save(addedUser.get());
        allClubsRepository.save(selectedClub.get());*/
        return "a";
    }
}
