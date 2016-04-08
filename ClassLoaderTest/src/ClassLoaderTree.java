public class ClassLoaderTree {

	/**
	 * �����������   ���������Ϊ  ����������� ��չ������� ϵͳ�������
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