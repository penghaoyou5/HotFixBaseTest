package my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JIngTaiInvocationHandler implements InvocationHandler{
	
	Object object;
	
	public JIngTaiInvocationHandler(){
		
	}
	
	public Object bind(Object object){
		this.object = object;
		return new JIngTaiDaiLIProxy(this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("��̬ǰ��");
		Object invoke = method.invoke(object,args);
		System.out.println("��̬����");
		return invoke;
	}

}
