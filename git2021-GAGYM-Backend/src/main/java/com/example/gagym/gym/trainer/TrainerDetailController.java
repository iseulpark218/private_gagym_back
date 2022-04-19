package com.example.gagym.gym.trainer;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.gagym.gym.gymdetail.GymDetail;

@RestController
public class TrainerDetailController {

	TrainerDetailRepository repo;

	public TrainerDetailController(TrainerDetailRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/gagym/detail/trainer")
//	@GetMapping(value = {"/gagym/detail","/gagym/detail/{id}"}) //test
	public List<TrainerDetail> getTrainerDetail() throws InterruptedException {
		return repo.findAll(Sort.by("id").descending());
	}

	// 1119 delete 임시
//	@DeleteMapping(value = "/gagym/detail/trainer/{id}")
//	public boolean removeTrainer(@PathVariable long id, HttpServletResponse res) throws InterruptedException {
//		Optional<TrainerDetail> trainerDetail = repo.findById(id);
//		if (trainerDetail.isEmpty()) {
//			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
//			return false;
//		}
//
//		repo.deleteById(id);
//
//		return true;
//	}
//	
}