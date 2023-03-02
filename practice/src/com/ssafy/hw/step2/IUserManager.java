package com.ssafy.hw.step2;
import java.util.List;
//인터페이스 선언
public interface IUserManager {
	// 추상 메서드 선언
	void add(User user);
	List<User> getList();
	List<User> getUsers();
	List<VipUser> getVipUsers();
	List<User> searchByName(String name);
	double getAgeAvg();
}
