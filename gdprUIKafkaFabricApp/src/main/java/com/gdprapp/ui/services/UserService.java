package com.gdprapp.ui.services;


import com.gdprapp.ui.orm.model.UserItem;
import com.gdprapp.ui.orm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public void save(UserItem user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    public UserItem findByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean isValidUserEmailAndPass(UserItem requestedUser) {

        boolean result = false;
        UserItem searchedUser = userRepository.findByEmail(requestedUser.getEmail());



        if (searchedUser != null){
            boolean passwordToMatch = bCryptPasswordEncoder.matches(requestedUser.getPassword(),searchedUser.getPassword());
            if (passwordToMatch){

                result = true;
            }
        }
        return result;
    }

}
