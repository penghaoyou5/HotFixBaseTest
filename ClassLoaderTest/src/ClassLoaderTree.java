public class ClassLoaderTree {

	/**
	 * 测试类加载器   类加载器分为  引导类加载器 扩展类加载器 系统类加载器
	 * @param args
	 */
	public static void main(String[] args) {
		ClassLoader classLoader = ClassLoaderTree.class.getClassLoader();
		while (classLoader!=null) {
			System.out.println(classLoader.getClass().getName());
			classLoader = classLoader.getParent();
		}
	}
}