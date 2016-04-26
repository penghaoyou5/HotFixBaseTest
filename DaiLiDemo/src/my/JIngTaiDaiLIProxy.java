package my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JIngTaiDaiLIProxy extends Proxy implements SysNow{

	protected JIngTaiDaiLIProxy(InvocationHandler h) {
		super(h);
		this.h = h;
	}

	InvocationHandler h;
	

	public void test(){
//		Proxy.newProxyInstance(loader, interfaces, h)
	}

	/* (non-Javadoc)
	 * @see my.SysNow#now()
	 * �����ĸ�ʽ�̶�
	 */
	@Override
	public void now() {
		Method method;
		try {
			method = SysNow.class.getMethod("now", new Class[]{});//��������
			h.invoke(this, method, new Object[]{});//����invoke����
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
