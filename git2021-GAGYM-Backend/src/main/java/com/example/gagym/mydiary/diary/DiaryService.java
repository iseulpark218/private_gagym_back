package com.example.gagym.mydiary.diary;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {
	private RabbitTemplate rabbit;
	DiaryRepository repo;
	
	private DiaryService(DiaryRepository repo, RabbitTemplate rabbit) {
		this.rabbit = rabbit;
		this.repo = repo;
	}

	//Enqueue
	public void sendDiary(Diary diary) {
		System.out.println(diary);
		rabbit.convertAndSend("service.diary.create", diary);
	}
	
	//Dequeue
	@RabbitListener(queues="service.diary.feedback")
	public void receiveDiary(Diary diary){
		saveDiary(diary); 
		System.out.println("-- service.diary.feedback --");
		System.out.println(diary);
	}
	
	public Diary saveDiary(Diary diary) {
		Diary saveDiary = Diary.builder()
				.memberName(diary.getMemberName())
				.diaryCreateTime(new Date().getTime())
				.diaryMorning(diary.getDiaryMorning())
				.diaryLunch(diary.getDiaryLunch())
				.diaryDinner(diary.getDiaryDinner())
				.diaryRoutine(diary.getDiaryRoutine())
				.diaryRequest(diary.getDiaryRequest())
				.trainerName(diary.getTrainerName())
				.trainerFeedback(diary.getTrainerFeedback())
				.build();
		repo.save(saveDiary);
		return saveDiary;
	}
	
}
