package test08;

// 타입 파라미터에 제한을 건다
// Number의 자손들만 지정할 수 있도록
public class GenericBox<T extends Number> {
	// T는 타입처럼 사용 간으
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
