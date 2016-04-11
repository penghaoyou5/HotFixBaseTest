package com.example.fanbianyitest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import net.youmi.android.AdManager;
import net.youmi.android.spot.SpotManager;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {
	Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		setContentView(R.layout.activity_main);
//		AdManager.getInstance(Context context).init(String appId, String appSecret, boolean isTestModel);
		//初始化应用信息
		AdManager.getInstance(this).init("57745550f8ab0a98", "b6572018a1fa38d3", true);
	}
	
	private void initYouMi(){
		//预加载插屏广告数据
		SpotManager.getInstance(context).loadSpotAds();
		//设置横竖屏
		SpotManager.getInstance(context).setSpotOrientation(SpotManager.ORIENTATION_PORTRAIT);
		//展示插屏广告
		
	}
	 
}
