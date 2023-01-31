package com.ssafy.ws.step2_0131;

public class SeriesMovie extends Movie { // Movie 클래스를상속받음
	private int seriesNum;
	private String episode;
	
	public SeriesMovie() {}
	
	// 오버로딩
	public SeriesMovie(int id, String title, String director, String genre, int runningTime, int seriesNum, String episode) {
		super(id, title, director, genre, runningTime);
		this.seriesNum = seriesNum;
		this.episode = episode;
	}

	// getter와 setter 만들기
	public int getSeriesNum() {
		return seriesNum;
	}

	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	// 오버라이드 toString 선언
	@Override
	public String toString() {
		return "SeriesMovie [id=" + super.getId() + ", title=" + super.getTitle() + ", director=" + super.getDirector() + ", genre=" + super.getGenre() + ", runningTime="
				+ super.getRunningTime() + ", SeriesMovie=" + seriesNum + ", episode=" + episode + "]";
	}
}

