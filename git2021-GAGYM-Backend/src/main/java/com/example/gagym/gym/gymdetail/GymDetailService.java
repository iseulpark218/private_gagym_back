package com.example.gagym.gym.gymdetail;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;

@Service
public class GymDetailService {

	GymDetailRepository repo;

	public GymDetailService(GymDetailRepository repo) {
		this.repo = repo;
	}
	
	@CacheEvict(value="gymdetails", allEntries = true)
	
	//Dequeue
	@RabbitListener(queues = "service.gym.create1")

	public void getGymDetail(GymDetail gymDetail) {
		System.out.println(gymDetail);
		saveGymDetail(gymDetail);
	}

	public GymDetail saveGymDetail(GymDetail gymDetail) {
		GymDetail saveGymDetail = GymDetail
				.builder()
				.gymName(gymDetail.getGymName())
				.gymCoNum(gymDetail.getGymCoNum())
				.gymLocateSi(gymDetail.getGymLocateSi())
				.gymLocateGunGu(gymDetail.getGymLocateGunGu())
				.gymAddress(gymDetail.getGymAddress())
				.gymPhoneNum(gymDetail.getGymPhoneNum())
				.gymTime(gymDetail.getGymTime())
				.gymService(gymDetail.getGymService())
				.gymPhoto(gymDetail.getGymPhoto())
				.fileName(gymDetail.getFileName())
				.fileType(gymDetail.getFileType())
				.gym1DayPrice(gymDetail.getGym1DayPrice())
				.gym3DayPrice(gymDetail.getGym3DayPrice())
				.gym7DayPrice(gymDetail.getGym7DayPrice())		
				.gymMonthPrice(gymDetail.getGymMonthPrice())
				.gym3MonthPrice(gymDetail.getGym3MonthPrice())
				.gym6MonthPrice(gymDetail.getGym6MonthPrice())
				.gymYearPrice(gymDetail.getGymYearPrice())

				.build();	
		repo.save(saveGymDetail);

		return saveGymDetail;
	}
}