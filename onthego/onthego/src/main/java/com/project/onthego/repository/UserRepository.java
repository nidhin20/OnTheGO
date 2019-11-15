/**
 * 
 */
/**
 * @author Jithu
 *
 */
package com.project.onthego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.onthego.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

   //  void addUser();
   // User getUserByAuthItemListContains(AuthItem authItem);
}
