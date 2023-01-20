package movie;

public class MovieManager {
	
	private final int MAX_SIZE = 100; // final : 더 이상 고칠 수 업는 상수
	
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
		return this.movieList;
	}
	
// 시리즈 영화가 아닌 영화들만의 배열을 리턴해주는 메소드
	public Movie[] getMovies() {
		Movie[] tmp = new Movie[this.size];
		int tmpsize = 0;
		for (int i = 0; this.movieList[i] != null; i++) {
			if (!(this.movieList[i] instanceof SeriesMovie)) { // instanceof를 사용하여 SeriesMovie인지 확인
				tmp[tmpsize++] = this.movieList[i];
			}
		}
		return tmp;
	}
	
	// 시리즈 영화들만의 배열을 리턴해주는 메소드
	public SeriesMovie[] getSeriesMovies() {
		SeriesMovie[] tmp = new SeriesMovie[this.size];
		int tmpsize = 0;
		for (int i = 0; this.movieList[i] != null; i++) {
			if (this.movieList[i] instanceof SeriesMovie ) { // instanceof를 사용하여 SeriesMovie가 아닌지 확인
				tmp[tmpsize++] = (SeriesMovie)this.movieList[i]; 
			}
		}
		return tmp;
	}
	
	// 이름으로 영화 찾기
	public static Movie searchByTitle(String title) {
		for (int i = 0; i<instance.size; i++) {
			if(MovieManager.getInstance().movieList[i] instanceof SeriesMovie) {// instanceof를 사용하여 SeriesMovie인지 확인
				if (MovieManager.getInstance().movieList[i].getTitle().equals(title)) {
					System.out.println("id = "+MovieManager.getInstance().movieList[i].getId());
					System.out.println("Title = "+MovieManager.getInstance().movieList[i].getTitle());
					System.out.println("Director = "+MovieManager.getInstance().movieList[i].getDirector());
					System.out.println("Genre = "+MovieManager.getInstance().movieList[i].getGenre());
					System.out.println("RunningTime = "+MovieManager.getInstance().movieList[i].getRunningTime());
					System.out.println("SeriesNumber = "+((SeriesMovie)MovieManager.getInstance().movieList[i]).getSeriesNum());
					System.out.println("Episode = "+((SeriesMovie)MovieManager.getInstance().movieList[i]).getEpisode());
					
					return MovieManager.getInstance().movieList[i];}
			}
			else {
				if (MovieManager.getInstance().movieList[i].getTitle().equals(title)) {
					System.out.println("id = "+MovieManager.getInstance().movieList[i].getId());
					System.out.println("Title = "+MovieManager.getInstance().movieList[i].getTitle());
					System.out.println("Director = "+MovieManager.getInstance().movieList[i].getDirector());
					System.out.println("Genre = "+MovieManager.getInstance().movieList[i].getGenre());
					System.out.println("RunningTime = "+MovieManager.getInstance().movieList[i].getRunningTime());
					
					return MovieManager.getInstance().movieList[i];}
			}
		}
		// 만약 찾기 못한 경우 다른 영화를 추천해주면서 해당 영화가 존재하지 않는다고 알려줌
		System.out.println("해당하는 영화가 존재하지 않습니다"); 
		if (instance.size > 0) {
			System.out.printf("이런 영화는 어떤가요? -> ");
			System.out.println(MovieManager.getInstance().movieList[0].getTitle());
		}
		return MovieManager.getInstance().movieList[0];
	}
	// 총 상영시간을 리턴하는 메서드
	public static double getRunningTimeAvg() {
		double avg = 0.0;
		for (int i = 0; i<instance.size; i++) {
			avg+=MovieManager.getInstance().movieList[i].getRunningTime();	
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
