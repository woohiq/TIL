package com.ssafy.ws.step2_0131;

import java.util.List;

public class MovieTest {
	public static void main(String[] args) throws TitleNotFoundException {
		// 인스턴스 생성
		System.out.println("MvManger 인스턴스를 생성하면서 movie.dat파일을 참조해서 영화 리스트를 가져옵니다");
		IMovieManager MvManager = MovieManagerImpl.getInstance(); 
		System.out.println("-------------");
		// 2개의 영화 생성
		// 기본 생성자로 만든 '나홀로집에' type : Movie
		Movie HomeAlone = new Movie();
		HomeAlone.setId(2023);
		HomeAlone.setTitle("HomeAlone");
		HomeAlone.setDirector("Chris Columbus");
		HomeAlone.setGenre("Comedy");
		HomeAlone.setRunningTime(103);
		// 인자를 줘서 만든 '이웃집 토토로' type : Movie
		Movie Totoro = new Movie(1988, "My Neighbor Totoro", "Miyazaki Hayao", "Animation", 88);
		// 기본 생성자로 만든 '해리포터:마법사의 돌', type : SeriesMovie
		SeriesMovie HarryPotter1 = new SeriesMovie();
		HarryPotter1.setId(1000);
		HarryPotter1.setTitle("해리포터");
		HarryPotter1.setDirector("크리스 콜롬버스");
		HarryPotter1.setGenre("판타지");
		HarryPotter1.setRunningTime(152);
		HarryPotter1.setSeriesNum(1);
		HarryPotter1.setEpisode("마법사의 돌");
		// 인자를 줘서 만든 '해리포터2:비밀의방', type:SeriesMovie
		SeriesMovie HarryPotter2 = new SeriesMovie(1111, "해리포터", "크리스 콜럼버스", "판타지", 161, 2, "비밀의 방");
		
		
		MvManager.add(HomeAlone); // add를 이용해서 인스턴스에 영화를 넣음
		MvManager.add(Totoro);
		MvManager.add(HarryPotter1);
		MvManager.add(HarryPotter2);
		
		//영화 리스트 저장
		//계속 실행하다 보면 영화 리스트가 계속 쌓이므로
		//실행시마다 영화 리스트가 늘어남
		MvManager.saveData();
		System.out.println("영화 리스트를 파일에 저장합니다");
		System.out.println("-------------");
		
		// getList 후 전체 영화 리스트
		System.out.println("전체 영화 리스트");
		List<Movie> MovieList = MvManager.getList(); 
		for (int i = 0;MovieList!=null && i<MovieList.size(); i++) { // 리스트를 받아 리스트가 null 값이 아닐 때까지 출력
			System.out.println(MovieList.get(i).toString());
		}
		System.out.println("-------------");
		// 시리즈물이 아닌 영화 출력
		System.out.println("시리즈물이 아닌 영화 리스트");
		List<Movie> NormalMovieList = MvManager.getMovies();
		for (int i = 0; NormalMovieList!=null && i<NormalMovieList.size(); i++) {
			System.out.println(NormalMovieList.get(i).toString());
		}
		System.out.println("-------------");
		// 시리즈물인 영화 출력
		System.out.println("시리즈물인 영화 리스트");
		List<SeriesMovie> SeriesMovieList = MvManager.getSeriesMovies();
		for (int i = 0; SeriesMovieList!=null && i<SeriesMovieList.size(); i++) { 
			System.out.println(SeriesMovieList.get(i).toString());
		}

		// 영화 제목으로 영화 검색 - 존재하는 영화 
		System.out.println("-------------");
		System.out.println("제목으로 영화 검색 : HomeAlone");
		try {
			List<Movie> SearchTest1 = MvManager.searchByTitle("HomeAlone"); // 존재하는 영화의 경우 try문 실행
			for (int i = 0;SearchTest1!=null && i<SearchTest1.size(); i++) {
				System.out.println(SearchTest1.get(i).toString()); // 예외 catch못한 경우 try문 이어서 실행
			}
		} catch (TitleNotFoundException e) {
			System.out.println("해당 영화가 존재하지 않습니다 : "+e.getTitle());
		} 
		System.out.println("-------------");
		
		// 영화 제목으로 영화 검색 - 존재하지 않는 영화
		System.out.println("제목으로 영화 검색 : 해리풔러");
		try {
			List<Movie> SearchTest2 = MvManager.searchByTitle("해리풔러"); // 존재하지 않는 영화의 경우 catch에서 예외잡기
			for (int i = 0; SearchTest2!=null && i<SearchTest2.size(); i++) { 
				System.out.println(SearchTest2.get(i).toString());
			}
		} catch (TitleNotFoundException e) {
			System.out.println("해당 영화가 존재하지 않습니다 : "+e.getTitle()); // catch한 경우 해당 영화가 존재하지 않다고 함
		}
		System.out.println("-------------");

		// 총 상영시간 평균 출력
		System.out.println("상영시간 평균 : "+MvManager.getRunningTimeAvg()+"분");
	}
}

