package reflect.proxy;

public class ProxyTest {

	public static void main(String[] args) {
		HelloSpeaker helloSpeaker = new HelloSpeaker();
		LogHandler logHandler = new LogHandler();
		
		//���ﻹ����תΪ��ڲ���Ϊʵ���ࣿ
		IHello bind = (IHello) logHandler.bind(helloSpeaker);
//		bind.hello();
		bind.toString();
	}
}
