package com.project.onthego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.onthego.model.UserMembership;
@Repository
public interface UserMembershipRepository extends JpaRepository<UserMembership, Integer> {

	@Query("select u from UserMembership u where u.Card_Id=?1")
	UserMembership findUserMembershipBycardid(int Cardid);
	@Query("select u from UserMembership u where u.User_Id=?1")
	List<UserMembership> findUserMembershipByuserid(int Userid);
}
