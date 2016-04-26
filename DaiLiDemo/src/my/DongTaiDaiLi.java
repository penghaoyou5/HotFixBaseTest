package my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
//实际要操作的类 
public class DongTaiDaiLi implements SysNow{

	public static void main(String[] args) {
		DongTaiDaiLi daiLi = new  DongTaiDaiLi();
		
		生成的动态代理(daiLi);
	}
	
	public static void 生成的动态代理(DongTaiDaiLi daiLi){
		JIngTaiInvocationHandler jIngTaiInvocationHandler = new JIngTaiInvocationHandler();
		SysNow bind = (SysNow) jIngTaiInvocationHandler.bind(daiLi);
		
		bind.now();
		
	}
	
	
	
	public static void 动态代理(DongTaiDaiLi daiLi){
		MyDemoProxy demoProxy = new MyDemoProxy();
		
		
		//将实际操作对象传入代理
		SysNow bindClass = (SysNow) demoProxy.bindClass(daiLi);
		bindClass.now();
	}
	
	
	

	@Override
	public void now() {
		System.out.println("My Is DongTaiDaiLi");
	}
	
}
