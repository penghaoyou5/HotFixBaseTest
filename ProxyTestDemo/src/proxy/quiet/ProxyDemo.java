//package proxy.quiet;
//
///**
// * @author peng
// * ���Ծ�̬����
// */
//public class ProxyDemo {
//    public static void main(String args[]){
//        RealSubject subject = new RealSubject();
//        Proxy p = new Proxy(subject);
//        p.request();
//    }
//}
//
//interface Subject{
//    void request();
//}
//
//class RealSubject implements Subject{
//    public void request(){
//        System.out.println("request");
//    }
//}
//
//class Proxy implements Subject{
//    private Subject subject;
//    public Proxy(Subject subject){
//        this.subject = subject;
//    }
//    public void request(){
//        System.out.println("PreProcess");
//        subject.request();
//        System.out.println("PostProcess");
//    }
//}