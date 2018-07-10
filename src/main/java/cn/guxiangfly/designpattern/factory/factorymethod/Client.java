package cn.guxiangfly.designpattern.factory.factorymethod;

public class Client {
	public static void main(String[] args) {
		Car c1 = new AudiFactory().createCar();

		c1.run();
	}
}
