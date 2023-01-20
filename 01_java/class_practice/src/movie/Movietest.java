package movie;

public class Movietest {
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
		
		// 잘 생성되었는지 확인하기 위한 출력
		System.out.println("HomeAlone:"+HomeAlone.toString());
		System.out.println("Totoro:"+Totoro.toString());
		System.out.println("해리포터1:"+HarryPotter1.toString());
		System.out.println("해리포터2:"+HarryPotter2.toString());
		
		System.out.println("-------------");
		
		
		MovieManager MvManager = MovieManager.getInstance(); // 인스턴스 생성
		MvManager.add(HomeAlone); // add
		MvManager.add(Totoro);
		MvManager.add(HarryPotter1);
		MvManager.add(HarryPotter2);
		Movie[] MovieList = MvManager.getList(); // getList 후 출력
		for (int i = 0; MovieList[i] != null; i++) {
			System.out.printf("#%d movie in List = "+MovieList[i].getTitle()+"\n",i);
		}
		System.out.println("-------------");
		// 시리즈물이 아닌 영화 출력
		Movie[] NormalMovieList = MvManager.getMovies();
		for (int i = 0; NormalMovieList[i] != null; i++) {
			System.out.printf("#%d Not-Serial movie in List = "+NormalMovieList[i].getTitle()+"\n",i);
		}
		System.out.println("-------------");
		// 시리즈물인 영화 출력
		SeriesMovie[] SeriesMovieList = MvManager.getSeriesMovies();
		for (int i = 0; SeriesMovieList[i] != null; i++) {
			System.out.printf("#%d Serial movie in List = "+SeriesMovieList[i].getTitle()+", 에피소드 = %s\n",i,SeriesMovieList[i].getEpisode());
		}

		
		// 영화 제목으로 영화 검색
		System.out.println("-------------");
		MovieManager.searchByTitle("HomeAlone"); // 이미 존재하는 영화 : 시리즈 아닌 영화
		System.out.println("-------------");
		MovieManager.searchByTitle("해리포터"); // 이미 존재하는 영화 : 시리즈물
		System.out.println("-------------");
		MovieManager.searchByTitle("HomeAlone2"); // 존재하지 않는 영화
		System.out.println("-------------");
		// 총 상영시간 출력
		System.out.println("상영시간 평균 : "+MovieManager.getRunningTimeAvg()+"분");
		
	}
}

