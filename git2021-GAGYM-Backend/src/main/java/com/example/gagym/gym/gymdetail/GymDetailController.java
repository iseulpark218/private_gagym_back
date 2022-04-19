package com.example.gagym.gym.gymdetail;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.gagym.mydiary.diary.Diary;

@RestController
public class GymDetailController {
	GymDetailRepository repo;
	public GymDetailController(GymDetailRepository repo) {
		this.repo = repo;
	}
	
	//Cache
	@Cacheable(value = "gymdetails"
			, condition="(#page + 1) * #size <= 10"
			, key = "#category+'-'+#page+'-'+#size") //1129임시주석
//	, key = "'all'")	
	@GetMapping(value="/gymdetails/{category}")

	public GymDetailPageResponse getGymDetailsByCategory(
		@PathVariable String category, 
		@RequestParam int page, 
		@RequestParam int size){
	
	if(category.equals("all")) {

		Page<GymDetail> gymdetailsPage = repo.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
		
		return GymDetailPageResponse.builder()
				.isLast(gymdetailsPage.isLast())
				.totalElements(gymdetailsPage.getTotalElements())
				.content(gymdetailsPage.getContent())
				.build();
	} else {

		Page<GymDetail> gymdetailsPage = repo.findById(PageRequest.of(page, size, Sort.by("id").descending()), category);

		return GymDetailPageResponse.builder()
				.isLast(gymdetailsPage.isLast())
				.totalElements(gymdetailsPage.getTotalElements())
				.content(gymdetailsPage.getContent())
				.build();
	}
}
	//Cache finish
	
	@GetMapping(value = {"/gagym/gym-list","/gagym/detail/{id}"})
	public List<GymDetail> getGymDetail() throws InterruptedException {
		return repo.findAll(Sort.by("id").descending());
	}
	
	// 1119 delete 임시
//	@DeleteMapping(value = "/gagym/gym-list/{id}")
//	public boolean removeGym(@PathVariable long id, HttpServletResponse res) throws InterruptedException {
//		Optional<GymDetail> gymDetail = repo.findById(id);
//		if (gymDetail.isEmpty()) {
//			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
//			return false;
//		}
//
//		repo.deleteById(id);
//
//		return true;
//	}
	
}