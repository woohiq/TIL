package com.ssafy.ws.step2;

public class MovieManager {
	
	private final int MAX_SIZE = 100; // final : 더 이상 고칠 수 없는 상수
	
	private Movie[] movieList = new Movie[MAX_SIZE];
	
	private int size = 0;
	

	// 일반 Movie 타입 전용 리스트 추가 메소드
	public void add(Movie movie) {
		this.movieList[this.size] = movie;
		this.size++;
	}
	
	// 시리즈 Movie 타입 전용 리스트 추가 메소드
	public void add(SeriesMovie movie) {
		this.movieList[this.size] = movie;
		this.size++;
	}
	
	// Movie 타입 배열 리턴 메소드
	public Movie[] getList() {
		return movieList;
	}
	
// 시리즈 영화가 아닌 영화들만의 배열을 리턴해주는 메소드
	public Movie[] getMovies() {
		int tmpsize = 0;
		for (int i = 0; i<size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) { // instanceof를 사용하여 SeriesMovie인지 확인
				tmpsize++;
			}
		}
		Movie[] tmp = new Movie[tmpsize];
		if (tmpsize == 0) return null;
		else tmpsize = 0;
		for (int i = 0; i<size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) { // instanceof를 사용하여 SeriesMovie인지 확인
				tmp[tmpsize++] = movieList[i];
			}
		}
		if (tmpsize == 0) return null;
		else return tmp;
	}
	
	// 시리즈 영화들만의 배열을 리턴해주는 메소드
	public Movie[] getSeriesMovies() {
		int tmpsize = 0;
		for (int i = 0; i<size; i++) {
			if (movieList[i] instanceof SeriesMovie) { // instanceof를 사용하여 SeriesMovie인지 확인
				tmpsize++;
			}
		}
		Movie[] tmp = new Movie[tmpsize];
		if (tmpsize == 0) return null;
		else tmpsize = 0;
		for (int i = 0; i<size; i++) {
			if (movieList[i] instanceof SeriesMovie) { // instanceof를 사용하여 SeriesMovie인지 확인
				tmp[tmpsize++] = movieList[i];
			}
		}
		if (tmpsize == 0) return null;
		else return tmp;
	}
	
	// 이름으로 영화 찾기
	public Movie[] searchByTitle(String title) {
		Movie[] tmp = new Movie[MAX_SIZE];
		int cnt = 0;
		for (int i = 0; i<instance.size; i++) {
			if (this.movieList[i].getTitle().contains(title)) { // contains를 이용해서 title이 포함되어 있는지 여부 확인
				tmp[cnt++] = this.movieList[i];
			}
		}
		// 만약 찾기 못한 경우 null 반환
		if (cnt == 0) return null;
		// 찾은 영화들을 searchedByTitle 배열에 넣어서 반환
		Movie[] searchedByTitle = new Movie[cnt];
		for (int j = 0; j<cnt; j++){
			searchedByTitle[j] = tmp[j];
		}
		return searchedByTitle;
	}
	// 총 상영시간을 리턴하는 메서드
	// double을 반환해야 하므로 double타입으로 형변환
	public double getRunningTimeAvg() {
		double avg = 0.0;
		for (int i = 0; i<instance.size; i++) {
			avg+=this.movieList[i].getRunningTime();	
		}
		return avg/instance.size;
	}
	//싱글턴
	//private로 자기자신 인스턴스 만들기
	//외부에서 생성하지 못하도록 private로 막기
	//유일한 인스턴스에 접근 가능한 getter 만들기
	private static MovieManager instance = new MovieManager();
	
	private MovieManager() {
	}
	public static MovieManager getInstance() {
		return instance;
	}
}


