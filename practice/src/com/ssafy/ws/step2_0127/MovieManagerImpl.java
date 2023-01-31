package com.ssafy.ws.step2_0127;
import java.util.ArrayList;
import java.util.List;
/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
// MovieManagermpl클래스는 IMovieManager인터페이스를 implement하여 구현
public class MovieManagerImpl implements IMovieManager {
	
	// private 내부 변수 설정
	private List<Movie> movieList = new ArrayList<>();
	
	// MovieManagerImpl 클래스 객체가 1개만 유지되도록 Singleton 디자인 패턴 적용
	private static IMovieManager instance = new MovieManagerImpl();
	// Singleton을 위한 private 접근제한자를 갖는 기본 생성자
	private MovieManagerImpl() {}
	// instance 접근은 getinstance 메서드로
	public static IMovieManager getInstance() {
		return instance;
	}
	
	// 영화를 리스트에 추가
	@Override
	public void add(Movie m) {
		movieList.add(m);
	}

	// 전체 리스트 반환
	@Override
	public List<Movie> getList() {
		return movieList;
	}
	
	// 이름으로 영화찾기
	// 만약 찾는 이름과 같다면 리턴할 리스트에 원소로 영화를 넣음
	// 하나도 찾지 못하면 null리턴, 찾았다면 리스트을 리턴
	@Override
	public List<Movie> searchByTitle(String title) {
		List<Movie> tmp = new ArrayList<>();
		for (int i = 0; i<movieList.size(); i++) {
			if (movieList.get(i).getTitle().equals(title)) tmp.add(movieList.get(i));
		}
		return tmp;
	}

	// Movie 자료형의 원소만 리턴하기
	// 만약 SeriesMovie자료형이 아니라면 (즉, 일반 Movie자료형이라면)리턴할 리스트에 원소로 영화를 넣음
	// 하나도 찾지 못하면 null리턴, 찾았다면 리스트를 리턴
	@Override
	public List<Movie> getMovies() {
		List<Movie> tmp = new ArrayList<>();
		for (int i = 0; i<movieList.size(); i++) {
			if (!(movieList.get(i) instanceof SeriesMovie)) tmp.add(movieList.get(i));
		}
		return tmp;
	}

	// Movie 자료형의 원소만 리턴하기
	// 만약 SeriesMovie자료형이라면 리턴할 리스트에 원소로 영화를 넣음
	// 하나도 찾지 못하면 null리턴, 찾았다면 리스트를 리턴
	@Override
	public List<SeriesMovie> getSeriesMovies() {
		List<SeriesMovie> tmp = new ArrayList<>();
		for (int i = 0; i<movieList.size(); i++) {
			if (movieList.get(i) instanceof SeriesMovie) tmp.add((SeriesMovie)(movieList.get(i)));
		}
		return tmp;
	}

	// 전체 상영시간 평균 반환
	// double형이므로 묵시적 형 변환 사용
	@Override
	public double getRunningTimeAvg() {
		double avg = 0.0;
		for (int i = 0; i<movieList.size(); i++) {
			avg += movieList.get(i).getRunningTime();
		}
		return avg/movieList.size();
	}

}
