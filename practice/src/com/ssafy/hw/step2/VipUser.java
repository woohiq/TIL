package com.ssafy.hw.step2;

public class VipUser extends User{ //  User 클래스를상속받음
	private String grade;
	private int point;
	// 기본 생성자
	public VipUser() {}
	// 오버로딩
	public VipUser(String id, String password, String name, String email, int age, String grade, int point) {
		super(id, password, name, email, age);
		this.grade = grade;
		this.point = point;
	}
	// getter와 setter 만들기
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	// 오버라이드 toString 선언
	@Override
	public String toString() {
		return "VipUser [id=" + this.getId() + ", password=" + this.getPassword() + ", name = " + this.getName() + ", email =" + this.getEmail() + ", age =" + this.getAge() + ", grade=" + grade + ", point=" + point + "]";
	}
	
	
}
