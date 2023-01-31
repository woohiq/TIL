package com.ssafy.ws.step2_0130;
import java.util.List;
// 인터페이스 선언
public interface IMovieManager {
	// 추상 메서드 선언
	void add(Movie movie);
	List<Movie> getList();
	List<Movie> searchByTitle(String title) throws TitleNotFoundException; // 예외처리
	List<Movie> getMovies();
	List<SeriesMovie> getSeriesMovies();
	double getRunningTimeAvg();
}
