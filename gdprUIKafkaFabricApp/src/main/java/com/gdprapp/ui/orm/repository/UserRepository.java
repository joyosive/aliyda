package com.gdprapp.ui.orm.repository;


import com.gdprapp.ui.orm.model.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserItem, Long> {

    public UserItem findByEmail(String email);

}