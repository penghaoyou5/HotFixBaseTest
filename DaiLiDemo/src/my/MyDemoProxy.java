package my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author SFXD
 *	��̬������  ʵ�����Ƕ�̬����ʵ�ֽӿڵ�Class�����Ķ���  ��  �������İ󶨶���
 */
public class MyDemoProxy implements InvocationHandler {

	private Object myInstance;
	public Object bindClass(SysNow sysNow){
		myInstance = sysNow;
		return Proxy.newProxyInstance(sysNow.getClass().getClassLoader(), sysNow.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String name = method.getName();
		System.out.println("qian "+name);
		Object result = method.invoke(myInstance, args);
		System.out.println("hou"+name);
		return result;
	}
	
}
