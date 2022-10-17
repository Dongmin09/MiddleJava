package interfaceShape;

public class Circle extends Shape {

	private double radius;

	// 원의 반지름.
	public Circle(double radius) {

		this.radius = radius;
		name = "원";
	}

	//원의 넓이 공식 
	//인터페이스 Shape를 상속 받아서 바로 가져와서 사용.
	public double area() {

		return radius * radius * Math.PI;

	}

	//원의 둘레 공식
	//인터페이스 Shape를 상속 받아서 바로 가져와서 사용.
	public double perimeter() {

		return 2 * radius * Math.PI;

	}
}
