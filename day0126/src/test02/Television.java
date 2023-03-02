package test02;

public class Television implements HdmiOutput{

	@Override
	public void output() {
		System.out.println("텔레비전 화면에 출력합니다.");
	}

}
