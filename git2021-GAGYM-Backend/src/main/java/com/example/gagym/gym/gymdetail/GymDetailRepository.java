package com.example.gagym.gym.gymdetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface GymDetailRepository extends JpaRepository<GymDetail, Long> {
	Page<GymDetail> findById(Pageable page, String gymCoNum);
}