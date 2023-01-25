package com.ssafy.ws.step2;

public class Movie {
	int id;
	String title;
	String director;
	String genre;
	int runningTime;
	
	public Movie() {}
	
	public Movie(int id, String title, String director, String genre, int runningTime) {
		this.id = id; // this를 사용해서 인스턴스 멤버에 지역변수 대입
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}
}
