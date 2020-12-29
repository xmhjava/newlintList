package reflect;

public class proxytest {
private int age;

public proxytest(int age) {
	System.out.println("构造函数执行");
	this.age=age;
}

void aa() {
	System.out.println("==执行aa方法==");
}

}
