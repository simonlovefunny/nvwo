1.何时使用：
	在不想增加很多子类的情况下拓展类，可以代替继承，缺点是多层装饰器比较复杂
2.如何使用
	shape接口和实现了它的实体类shapeEntity
	定义一个实现了shape接口的抽象类shapeDecorator，shape对象是它的实例变量，
	redShapeDecorator是实现了接口的实体类
	