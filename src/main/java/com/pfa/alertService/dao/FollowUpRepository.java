package com.pfa.alertService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.alertService.entities.FollowUp;
@Repository
public interface FollowUpRepository extends JpaRepository<FollowUp, Long>{

}
