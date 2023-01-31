package com.ssafy.hw.step2;
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
	// 하나도 찾지 못하면 null리턴, 찾았다면 배열을 리턴
	@Override
	public List<User> searchByName(String name) {
		List<User> tmp = new ArrayList<>();
		for (int i = 0; i<userList.size(); i++) {
			if (userList.get(i).getName().equals(name)) tmp.add(userList.get(i));
		}
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

}
