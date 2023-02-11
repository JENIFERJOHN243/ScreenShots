package task;

public class Area {

	public static void main(String[] args) {
		Shape t = new Triangle(20,30);
		t.area();
		t= new Rectangle(20,30);
		t.area();
	}
}
abstract class Shape{
	int base,height;
	Shape(int b,int h){
		this.base=b;
		this.height=h;
	}
	abstract void area();
}
class Triangle extends Shape{

	Triangle(int i, int j) {
		super(i,j);
	}

	public void area() {
		System.out.println("Triangle of an area: "+0.5*base*height);
	}
	
}
class Rectangle extends Shape{

	Rectangle(int i, int j) {
		super(i,j);
	}

	public void area() {
		System.out.println("Rectangle of an area: "+base*height);
	}
	
}
