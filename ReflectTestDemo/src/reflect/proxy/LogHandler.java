package reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogHandler implements InvocationHandler { 
    private Logger logger = 
               Logger.getLogger(this.getClass().getName()); 
    private Object delegate; 

    // ��Ҫ��������
    public Object bind(Object delegate) { 
        this.delegate = delegate;
        // ���������ش������
        return Proxy.newProxyInstance(
                 delegate.getClass().getClassLoader(),
                 // Ҫ������Ľ���
                 delegate.getClass().getInterfaces(), 
                 this); 
    }

    // ����Ҫ���еķ�����������ǰ��������Ϊ
    public Object invoke(Object proxy, 
                         Method method, 
                         Object[] args) throws Throwable {
        Object result = null; 
        try { 
            logger.log(Level.INFO, 
                         "method starts..." + method.getName()); 
            result = method.invoke(delegate, args); 
            logger.log(Level.INFO, 
                         "method ends..." + method.getName()); 
        } catch (Exception e){ 
            logger.log(Level.INFO, e.toString()); 
        } 
        return result; 
    } 
}