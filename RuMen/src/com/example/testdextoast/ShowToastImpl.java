package com.example.testdextoast;

import android.content.Context;
import android.widget.Toast;

public class ShowToastImpl implements IShowToast {

	@Override
	public void showMyToast(Context context) {
		Toast.makeText(context, "����С���һ��ʵ���ⲿ���صĳ���", Toast.LENGTH_LONG).show();
	}

}
