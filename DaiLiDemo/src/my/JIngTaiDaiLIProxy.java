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
	 * 方法的格式固定
	 */
	@Override
	public void now() {
		Method method;
		try {
			method = SysNow.class.getMethod("now", new Class[]{});//创建方法
			h.invoke(this, method, new Object[]{});//生成invoke方法
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
