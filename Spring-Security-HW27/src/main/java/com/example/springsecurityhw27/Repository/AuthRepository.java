package com.example.springsecurityhw27.Repository;


import com.example.springsecurityhw27.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<MyUser,Integer> {

    MyUser findUserByUsername(String username);

    MyUser findMyUserById(Integer id);


}
