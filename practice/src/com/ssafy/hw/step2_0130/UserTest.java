package com.ssafy.hw.step2_0130;

import java.util.List;

public class UserTest {
	public static void main(String[] args) {
		// 기본 생성자를 통한 객체 생성
		User user1 = new User();
		user1.setId("user1");
		user1.setPassword("user1");
		user1.setName("김싸피");
		user1.setEmail("ssafy1@ssafy.com");
		user1.setAge(27);
		
		// 인자를 입력받는 생성자를 통한 객체 생성
		User user2 = new User("ssafy", "ssafy", "박싸피", "ssafy@ssafy.com", 28);
		
		// 기본 생성자를 통한 VipUser 객체 생성
		VipUser user3 = new VipUser();
		user3.setId("user3");
		user3.setPassword("q1w2e3r4");
		user3.setName("이갑갑");
		user3.setEmail("gapgap@ssafy.com");
		user3.setAge(77);
		user3.setGrade("골드");
		user3.setPoint(50);
		
		// 인자를 입력받는 생성자를 통한 VipUser 객체 생성
		VipUser user4 = new VipUser("user4", "1q2w3e4r", "이갑갑", "gapgap2@ssafy.com", 65, "플래티넘", 100);
		
		// UserManagerImpl 인스턴스를 받아와서 user를 add함
		UserManagerImpl um = UserManagerImpl.getInstance();
		um.add(user1);
		um.add(user2);
		um.add(user3);
		um.add(user4);
		
		// 전체 유저 리스트 출력
		System.out.println("전체 유저 리스트");
		List<User> totalUserList = um.getList();
		if (totalUserList == null) System.out.println("등록된 유저 없음");
		else{
			for (int i = 0; i<totalUserList.size(); i++) {
				System.out.println(totalUserList.get(i).toString());
			}
		}
		System.out.println("----------------");
		
		// 일반 유저 리스트 출력
		System.out.println("일반 유저 리스트");
		List<User> normalUserList = um.getUsers();
		if (normalUserList == null) System.out.println("등록된 유저 없음");
		else{
			for (int i = 0; i<normalUserList.size(); i++) {
				System.out.println(normalUserList.get(i).toString());
			}
		}
		System.out.println("----------------");
		
		// Vip유저 리스트 출력
		System.out.println("vip 유저 리스트");
		List<VipUser> vipUserList = um.getVipUsers();
		if (vipUserList == null) System.out.println("등록된 유저 없음");
		else{
			for (int i = 0; i<vipUserList.size(); i++) {
				System.out.println(vipUserList.get(i).toString());
			}
		}
		System.out.println("----------------");
		
		// 이름으로 찾기 : 김싸피 - 존재하는 이름
		System.out.println("이름으로 찾기 : 김싸피");
		// try-catch문으로 예외 처리
		// 예외 발생하지 않아 try문 계속 진행
		try {
			List<User> kimssafySearch = um.searchByName("김싸피");
			for (int i = 0; i<kimssafySearch.size(); i++){
				System.out.println(kimssafySearch.get(i).toString());
			 }
		} catch (NameNotFoundException e) {
			System.out.println("그런 이름을 갖는 유저가 없습니다 : "+e.getName());
		}
        System.out.println("----------------");
        
        // 이름으로 찾기 : 홍길동 - 존재하지 않는 이름
        System.out.println("이름으로 찾기 : 홍길동");
        // try-catch문으로 예외 처리
        // 예외 발생으로 catch문으로 jump한 후 예외처리
		try {
			List<User> hongGilDongSearch = um.searchByName("홍길동");
			for (int i = 0; i<hongGilDongSearch.size(); i++){
	            System.out.println(hongGilDongSearch.get(i).toString());
	        }
		} catch (NameNotFoundException e) {
			System.out.println("그런 이름을 갖는 유저가 없습니다 : "+e.getName());
		}
        System.out.println("----------------");

        // 유저 나이 평균 출력
        System.out.println("유저 나이 평균 : "+um.getAgeAvg()+"세");
        System.out.println("----------------");
        
        // 새 인스턴스 생성 후 기존 인스턴스와 같은지 비교
        UserManagerImpl um2 = UserManagerImpl.getInstance();
        System.out.println("두 인스턴스 동일여부 : "+(um==um2));
	}
}
