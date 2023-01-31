package com.ssafy.ws.step2;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
// MovieManagermpl클래스는 IMovieManager인터페이스를 implement하여 구현
public class MovieManagerImpl implements IMovieManager {
	
	// private 내부 변수 설정
	private static final int MAX_SIZE = 100;
	private Movie[] movieList = new Movie[MAX_SIZE];
	private int size;
	
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
	public void add(Movie movie) {
		if (size == MAX_SIZE) System.out.println("리스트가 모두 찼습니다");
		else movieList[size++] = movie;
	}

	// 전체 리스트 반환
	@Override
	public Movie[] getList() {
		if (size == 0) return null;
		else{
			Movie[] tmp = new Movie[size];
			for (int i = 0; i<size; i++) {
				tmp[i] = movieList[i];
			}
			return tmp;
		}
	}
	
	// 이름으로 영화찾기
	// 먼저 리턴할 Movie 배열의 크기를 계산후 배열 생성
	// 만약 찾는 이름과 같다면 리턴할 배열에 원소로 영화를 넣음
	// 하나도 찾지 못하면 null리턴, 찾았다면 배열을 리턴
	@Override
	public Movie[] searchByTitle(String title) {
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i<size; i++) {
			if (movieList[i].getTitle().equals(title)) cnt++;
		}
		if (cnt==0) return null;
		Movie[] tmp = new Movie[cnt];
		for (int j = 0; j<size; j++) {
			if (movieList[j].getTitle().equals(title)) tmp[idx++] = movieList[j];
		}
		return tmp;
	}

	// Movie 자료형의 원소만 리턴하기
	// 먼저 리턴할 Movie 배열의 크기를 계산후 배열 생성
	// 만약 SeriesMovie자료형이 아니라면 (즉, 일반 Movie자료형이라면)리턴할 배열에 원소로 영화를 넣음
	// 하나도 찾지 못하면 null리턴, 찾았다면 배열을 리턴
	@Override
	public Movie[] getMovies() {
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i<size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) cnt++;
		}
		if (cnt==0) return null;
		Movie[] tmp = new Movie[cnt];
		for (int j = 0; j<size; j++) {
			if (!(movieList[j] instanceof SeriesMovie)) tmp[idx++] = movieList[j];
		}
		return tmp;
	}

	// SeriesMovie 자료형의 원소만 리턴하기
	// 먼저 리턴할 SeriesMovie 배열의 크기를 계산후 배열 생성
	// 만약 SeriesMovie자료형이라면 리턴할 배열에 원소로 영화를 넣음
	// 하나도 찾지 못하면 null리턴, 찾았다면 배열을 리턴
	@Override
	public SeriesMovie[] getSeriesMovies() {
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i<size; i++) {
			if (movieList[i] instanceof SeriesMovie) cnt++;
		}
		if (cnt==0) return null;
		SeriesMovie[] tmp = new SeriesMovie[cnt];
		for (int j = 0; j<size; j++) {
			if (movieList[j] instanceof SeriesMovie) tmp[idx++] = (SeriesMovie)(movieList[j]);
		}
		return tmp;
	}

	// 전체 상영시간 평균 반환
	// double형이므로 묵시적 형 변환 사용
	@Override
	public double getRunningTimeAvg() {
		double avg = 0.0;
		for (int i = 0; i<size; i++) {
			avg+=this.movieList[i].getRunningTime();	
		}
		return avg/size;
	}

}
