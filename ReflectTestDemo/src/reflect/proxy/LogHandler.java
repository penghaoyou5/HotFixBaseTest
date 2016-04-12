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

    // 绑定要代理的物件
    public Object bind(Object delegate) { 
        this.delegate = delegate;
        // 建立并传回代理物件
        return Proxy.newProxyInstance(
                 delegate.getClass().getClassLoader(),
                 // 要被代理的介面
                 delegate.getClass().getInterfaces(), 
                 this); 
    }

    // 代理要呼叫的方法，并在其前后增加行为
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