package com.ssafy.ws.step2;

public class MovieTest {
	public static void main(String[] args) {
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
		
		// 인스턴스 생성
		IMovieManager MvManager = MovieManagerImpl.getInstance(); 
		MvManager.add(HomeAlone); // add를 이용해서 인스턴스에 영화를 넣음
		MvManager.add(Totoro);
		MvManager.add(HarryPotter1);
		MvManager.add(HarryPotter2);
		// getList 후 전체 영화 리스트
		System.out.println("전체 영화 리스트");
		Movie[] MovieList = MvManager.getList(); 
		for (int i = 0;MovieList!=null && i<MovieList.length; i++) { // 리스트를 받아 리스트가 null 값이 아닐 때까지 출력
			System.out.println(MovieList[i].toString());
		}
		System.out.println("-------------");
		// 시리즈물이 아닌 영화 출력
		System.out.println("시리즈물이 아닌 영화 리스트");
		Movie[] NormalMovieList = MvManager.getMovies();
		for (int i = 0; NormalMovieList!=null && i<NormalMovieList.length; i++) {
			System.out.println(NormalMovieList[i].toString());
		}
		System.out.println("-------------");
		// 시리즈물인 영화 출력
		System.out.println("시리즈물인 영화 리스트");
		Movie[] SeriesMovieList = MvManager.getSeriesMovies();
		for (int i = 0; SeriesMovieList!=null && i<SeriesMovieList.length; i++) { 
			System.out.println(SeriesMovieList[i].toString());
		}

		
		// 영화 제목으로 영화 검색
		System.out.println("-------------");
		System.out.println("제목으로 영화 검색 : HomeAlone");
		Movie[] SearchTest1 = MvManager.searchByTitle("HomeAlone"); // 이미 존재하는 영화 : 시리즈 아닌 영화 (제목으로 검색)
		for (int i = 0;SearchTest1!=null && i<SearchTest1.length; i++) {
			System.out.println(SearchTest1[i].toString());
		}
		System.out.println("-------------");
		System.out.println("제목 일부로 영화 검색 : 해리");
		Movie[] SearchTest2 = MvManager.searchByTitle("해리"); // 이미 존재하는 영화 : 시리즈 영화 (제목의 일부로 검색)
		for (int i = 0; SearchTest2!=null && i<SearchTest2.length; i++) { // 시리즈 영화의 경우 에피소드가 있으므로 에피소드도 출력
			System.out.println(SearchTest2[i].toString());
		}
		System.out.println("-------------");

		// 총 상영시간 평균 출력
		System.out.println("상영시간 평균 : "+MvManager.getRunningTimeAvg()+"분");
		
	}
}

