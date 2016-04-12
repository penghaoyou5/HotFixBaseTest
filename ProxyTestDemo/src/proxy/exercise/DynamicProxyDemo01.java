package proxy.exercise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo01 {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();    //1.����ί�ж���
        ProxyHandler handler = new ProxyHandler(realSubject);    //2.�������ô���������
        Subject proxySubject = (Subject)Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                                                        RealSubject.class.getInterfaces(), handler);    //3.��̬���ɴ������
        proxySubject.request();    //4.ͨ�����������÷���
        proxySubject.getClass().getModifiers();
        Integer.toBinaryString(proxySubject.getClass().getModifiers());
        String string = Modifier.toString( proxySubject.getClass().getModifiers());
        System.out.println(string);
        System.out.println(Modifier.PUBLIC&proxySubject.getClass().getModifiers());
        System.out.println(Modifier.toString( proxySubject.getClass().getModifiers()));
        
    }
}

/**
 * �ӿ�
 */
interface Subject{
    void request();
}

/**
 * ί����
 */
class RealSubject implements Subject{
    public void request(){
        System.out.println("====RealSubject Request====");
    }
}
/**
 * ������ĵ��ô�����
 */
class ProxyHandler implements InvocationHandler{
    private Subject subject;
    public ProxyHandler(Subject subject){
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("====before====");//����Ԥ����Ĺ�������Ȼ��Ҳ���Ը��� method �Ĳ�ͬ���в�ͬ��Ԥ������
        Object result = method.invoke(subject, args);
        System.out.println("====after====");
        return result;
    }
}