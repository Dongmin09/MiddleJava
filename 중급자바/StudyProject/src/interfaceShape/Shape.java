package interfaceShape;

// 추상 클래스를 이용하여 인터페이스 Comparable를 이용
public abstract class Shape implements Comparable<Shape> {

	String name;

	// 넓이를 지정해주는 메서드.
	public abstract double area();

	// 둘레를 지정해주는 메서드
	public abstract double perimeter();

	// 넓이 기준 정렬하기 (이 부분은 잘 몰라서 예전 숙제 참고햇어요....)
	public int compareTo(Shape o) {

		if (area() > o.area()) {
			return 1;
		}
		else if (area() < o.area()) {

			return -1;
		}
		else {
			return 0;
		}

	}

	@Override
	public String toString() {

		return String.format("도형의 종류 : %s , 둘레 : %.2fcm  ,  넓이 : %.2f㎠", name, perimeter(), area());

	}

}