
package com.project.onthego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.onthego.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

   @Query(value="Select count(1) from User u where u.email=:email and u.password=:password")
    int findbyEmail(@Param("email") String email,@Param("password") String password);

   @Query(value="Select count(1) from User u where u.email=:email",nativeQuery=true)
   int validbyEmail(@Param("email") String email);
   
   @Query(value="Select * from User u where u.email=:email LIMIT 1",nativeQuery=true)
   User GetuserbyEmail(@Param("email") String email);
   
   @Query(value="Select * from User u where u.IsAdmin=1",nativeQuery=true)
   List<User> Getalladministrator();
}