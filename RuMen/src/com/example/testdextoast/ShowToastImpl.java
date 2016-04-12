package com.example.testdextoast;

import android.content.Context;
import android.widget.Toast;

public class ShowToastImpl implements IShowToast {

	@Override
	public void showMyToast(Context context) {
		Toast.makeText(context, "这是小朋第一个实现外部加载的程序", Toast.LENGTH_LONG).show();
	}

}
