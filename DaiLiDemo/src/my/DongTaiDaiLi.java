package my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
//ʵ��Ҫ�������� 
public class DongTaiDaiLi implements SysNow{

	public static void main(String[] args) {
		DongTaiDaiLi daiLi = new  DongTaiDaiLi();
		
		���ɵĶ�̬����(daiLi);
	}
	
	public static void ���ɵĶ�̬����(DongTaiDaiLi daiLi){
		JIngTaiInvocationHandler jIngTaiInvocationHandler = new JIngTaiInvocationHandler();
		SysNow bind = (SysNow) jIngTaiInvocationHandler.bind(daiLi);
		
		bind.now();
		
	}
	
	
	
	public static void ��̬����(DongTaiDaiLi daiLi){
		MyDemoProxy demoProxy = new MyDemoProxy();
		
		
		//��ʵ�ʲ������������
		SysNow bindClass = (SysNow) demoProxy.bindClass(daiLi);
		bindClass.now();
	}
	
	
	

	@Override
	public void now() {
		System.out.println("My Is DongTaiDaiLi");
	}
	
}
