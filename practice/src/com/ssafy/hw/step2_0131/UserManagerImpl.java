package com.ssafy.hw.step2_0131;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
//MovieManagermpl클래스는 IMovieManager인터페이스를 implement하여 구현
public class UserManagerImpl implements IUserManager {

	// private 내부 변수 설정
	private List<User> userList = new ArrayList<>();
	
	// UserManagerImpl 클래스 객체가 1개만 유지되도록 Singleton 디자인 패턴 적용
	private static UserManagerImpl um = new UserManagerImpl();
	// Singleton을 위한 private 접근제한자를 갖는 기본 생성자
	private UserManagerImpl() {}
	// instance 접근은 getinstance 메서드로
	public static UserManagerImpl getInstance() {return um;}
	
	// 유저를 리스트에 추가
	@Override
	public void add(User user) {
		userList.add(user);
	}

	// 전체 리스트 반환
	@Override
	public List<User> getList() {
		return userList;
	}

	// User 자료형의 원소만 리턴하기
	// 먼저 리턴할 User 배열의 크기를 계산후 배열 생성
	// 만약 VipUser자료형이 아니라면 (즉, 일반User자료형이라면)리턴할 배열에 원소로 영화를 넣음
	// 하나도 찾지 못하면 null리턴, 찾았다면 배열을 리턴
	@Override
	public List<User> getUsers() {
		List<User> tmp = new ArrayList<>();
		for (int i = 0; i<userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) tmp.add(userList.get(i));
		}
		return tmp;
	}

	// VipUser 자료형의 원소만 리턴하기
	// 먼저 리턴할 VipUser 배열의 크기를 계산후 배열 생성
	// 만약 VipUser자료형이라면 리턴할 배열에 원소로 영화를 넣음
	// 하나도 찾지 못하면 null리턴, 찾았다면 배열을 리턴
	@Override
	public List<VipUser> getVipUsers() {
		List<VipUser> tmp = new ArrayList<>();
		for (int i = 0; i<userList.size(); i++) {
			if (userList.get(i) instanceof VipUser) tmp.add((VipUser)(userList.get(i)));
		}
		return tmp;
	}

	// 이름으로 유저찾기
	// 먼저 리턴할 User 배열의 크기를 계산후 배열 생성
	// 만약 찾는 이름과 같다면 리턴할 배열에 원소로 유저를 넣음
	// 하나도 찾지 못하면 예외처리, 찾았다면 배열을 리턴
	@Override
	public List<User> searchByName(String name) throws NameNotFoundException{
		List<User> tmp = new ArrayList<>();
		for (int i = 0; i<userList.size(); i++) {
			if (userList.get(i).getName().equals(name)) tmp.add(userList.get(i));
		}
		// 예외처리를 위한 변수 선언
		NameNotFoundException exception = new NameNotFoundException(name);
		// tmp배열의 size가 0 -> 일치하는 유저가 없다는 뜻이므로 예외처리 throw
		if (tmp.size() == 0) throw exception;
		return tmp;
	}

	// 전체 유저 나이 평균 반환
	// double형이므로 묵시적 형 변환 사용
	@Override
	public double getAgeAvg() {
		double summ = 0.0;
		for (int i = 0; i<userList.size(); i++) {
			summ += userList.get(i).getAge(); 
		}
		return summ/userList.size();
	}
	// 데이터를 저장
	// userList에 있는 정보를 writeObject를 이용해 User.dat에 저장
	// 만약 File이 없다 -> FileNotFoundException
	// 그 외 IOException 까지 예외처리
	@Override
	public void saveData() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("User.dat"))){
			for (User user : userList) {
				out.writeObject(user);
			}
		} catch (FileNotFoundException e) {
			System.out.println("해당 User.dat 파일이 존재하지 않습니다");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("그 외 예외가 일어났습니다");
		}
		
	}
	// 데이터를 로드
	// User.dat에 있는 정보를 readObject로 Object타입으로 읽고
	// User로 형 변환 한 뒤 userList에 저장
	// 파일 못찾는 FileNotFoundException
	// user.dat의 마지막 EOF까지 도달하면 EOFException
	// 나머지 입출력문제 IOException 예외처리
	@Override
	public void loadData() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("User.dat"))){
			Object obj;
			while ((obj = in.readObject())!= null) {
				userList.add((User)obj);
				System.out.println("불러온 정보 : "+obj.toString());
			}
		} catch (FileNotFoundException e) {
			System.out.println("해당 User.dat 파일이 존재하지 않습니다");
		} catch (EOFException e) {
			System.out.println("파일에서 User 클래스 정보를 전부 가져왔습니다");
		} catch (IOException e) {
			System.out.println("그 외 입출력 관련 예외가 일어났습니다");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾지 못했습니다");
		} catch (Exception e) {
			System.out.println("그 외 예외가 일어났습니다");
		}
		
	}
}
