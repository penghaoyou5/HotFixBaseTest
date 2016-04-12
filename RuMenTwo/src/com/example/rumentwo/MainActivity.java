package com.example.rumentwo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import dalvik.system.DexClassLoader;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void 加载外包(View view) {
		//获得外部jar包目录
		String outputJar = Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"output.jar";
		//获得内部要解压到的目录   
		File dir = getDir("dex1", MODE_PRIVATE);
		//根据两者获得类加载器对象
		DexClassLoader loader = new DexClassLoader(outputJar, dir.getAbsolutePath(), null, getClassLoader());
		//类加载器直接进行类的加载
		Class<?> loadClass = null;
		try {
			loadClass = loader.loadClass("com.example.testdextoast.ShowToastImpl");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			//获得类的实例进行方法调用
			Object newInstance = loadClass.newInstance();
			Method method = loadClass.getMethod("showMyToast", Context.class);
			method.invoke(newInstance, this);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


















//public void yuan() {
//	File dexOutputDir = getDir("dex1", 0);
//	String dexPath = Environment.getExternalStorageDirectory().toString() + File.separator + "output.jar";
//	DexClassLoader loader = new DexClassLoader(dexPath, dexOutputDir.getAbsolutePath(), null, getClassLoader());
//	try {
//		Class clz = loader.loadClass("com.example.testdextoast.ShowToastImpl");
//		IShowToast impl = (IShowToast) clz.newInstance();
//		impl.showMyToast(this);
//	} catch (Exception e) {
//		Log.d("TEST111", "error happened", e);
//	}
//}