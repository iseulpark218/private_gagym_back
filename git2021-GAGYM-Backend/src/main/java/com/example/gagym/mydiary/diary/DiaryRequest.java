package com.example.gagym.mydiary.diary;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaryRequest {
	private String memberName;
	private String diaryMorning;
	private String diaryLunch;
	private String diaryDinner;
	private String diaryRoutine;
	private String diaryRequest;
	private String trainerName;
	private String trainerFeedback;	
}