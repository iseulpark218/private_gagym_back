package com.example.gagym.gym.trainer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gagym.gym.gymdetail.GymDetail;

@Repository
public interface TrainerDetailRepository extends JpaRepository<TrainerDetail, Long> {
	Page<GymDetail> findById(Pageable page, String gymCode);
}