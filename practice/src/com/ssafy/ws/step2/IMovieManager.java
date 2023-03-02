package com.ssafy.ws.step2;
// 인터페이스 선언
public interface IMovieManager {
	// 추상 메서드 선언
	void add(Movie movie);
	Movie[] getList();
	Movie[] searchByTitle(String title);
	Movie[] getMovies();
	SeriesMovie[] getSeriesMovies();
	double getRunningTimeAvg();
}
