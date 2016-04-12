package reflect.proxy;

public class ProxyTest {

	public static void main(String[] args) {
		HelloSpeaker helloSpeaker = new HelloSpeaker();
		LogHandler logHandler = new LogHandler();
		
		//这里还比需转为借口不能为实现类？
		IHello bind = (IHello) logHandler.bind(helloSpeaker);
//		bind.hello();
		bind.toString();
	}
}
