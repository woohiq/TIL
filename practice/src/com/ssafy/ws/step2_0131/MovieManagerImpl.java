package com.ssafy.ws.step2_0131;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	// instance 생성에서 loadDate로 movie.dat에 있는 정보 불러오기
	public static IMovieManager getInstance() {
		((MovieManagerImpl) instance).loadData();
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
	// 하나도 찾지 못하면 예외처리, 찾았다면 리스트을 리턴
	// 예외처리를 위해 throws TitleNotFoundException구문 사용
	@Override
	public List<Movie> searchByTitle(String title) throws TitleNotFoundException {
		List<Movie> tmp = new ArrayList<>();
		for (int i = 0; i<movieList.size(); i++) {
			if (movieList.get(i).getTitle().equals(title)) tmp.add(movieList.get(i));
		}
		TitleNotFoundException except = new TitleNotFoundException(title);
		// 만약 이름과 같은 영화가 없음 -> 배열의 사이즈 0 -> 예외처리 throw
		if (tmp.size() == 0) throw except; 
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
	// 데이터를 로드
	// movie.dat에 있는 정보를 readObject로 Object타입으로 읽고
	// Movie로 형 변환 한 뒤 movieList에 저장
	// 파일 못찾는 FileNotFoundException
	// user.dat의 마지막 EOF까지 도달하면 EOFException
	// 나머지 입출력문제 IOException 예외처리
	private void loadData() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("movie.dat"))){
			Object obj;
			while ((obj = in.readObject()) != null) {
				movieList.add((Movie)obj);
				System.out.println("불러온 정보 : "+obj.toString());
			}
		} catch (FileNotFoundException e) {
			System.out.println("해당 movie.dat 파일이 존재하지 않습니다");
		} catch (EOFException e) {
			System.out.println("파일에서 Movie 클래스 정보를 전부 가져왔습니다");
		} catch (IOException e) {
			System.out.println("그 외 입출력 관련 예외가 일어났습니다");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다");
		} catch (Exception e) {
			System.out.println("그 외 예외가 일어났습니다");
		}
	}
	
	// 데이터를 저장
	// movieList에 있는 정보를 writeObject를 이용해 movie.dat에 저장
	// 만약 File이 없다 -> FileNotFoundException
	// 그 외 IOException 까지 예외처리
	@Override
	public void saveData() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("movie.dat"))){
			for (Movie movie : movieList) {
				out.writeObject(movie);
			}
		} catch (IOException e) {
			System.out.println("입출력 관련 예외가 일어났습니다");
		} catch (Exception e) {
			System.out.println("그 외 예외가 일어났습니다");
		}
	}
}
