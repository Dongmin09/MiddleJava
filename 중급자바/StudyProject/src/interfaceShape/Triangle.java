package interfaceShape;

public class Triangle extends Shape {

	private double side;

	public Triangle(double side) {

		this.side = side;
		name = "삼각형";

	}

	@Override
	// 삼각형의 넓이
	// 인터페이스 Shape를 상속 받아서 사용
	public double area() {

		return (Math.sqrt(3) / 4) * side * side;

	}
	
	@Override
	//삼각형의 둘레
	// 인터페이스 Shape를 상속 받아서 사용
	public double perimeter() {
		return 3 * side;
	}

}
