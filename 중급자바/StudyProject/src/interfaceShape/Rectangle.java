package interfaceShape;

public class Rectangle extends Shape {
	
	private double width;
	private double height;

	// 생성자
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
		name = "사각형";
	}

	// 메소드
	@Override
	// 사각형의 넓이
	// 인터페이스를 사용하여 리턴값으로 바로 돌려줌
	public double area() {
		return width * height;
	}

	@Override
	//사각형의 둘레
	// 인터페이스를 사용하여 리턴값으로 바로 돌려줌
	public double perimeter() {
		return 2 * (width + height);
	}
	

}
