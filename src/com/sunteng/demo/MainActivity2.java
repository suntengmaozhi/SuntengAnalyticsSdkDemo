/**
 ***************************************************************************** 
 * Copyright (C) 2011 -2014 Sunteng Corporation. All rights reserved File :
 * 2014-9-28
 * 
 * Description : MainActivity.java
 * 
 * Creation : 2014-9-28 Author : maozhi@sunteng.com History : Creation,
 * 2014-9-28, maozhi, Create the file
 ***************************************************************************** 
 */

package com.sunteng.demo;

import android.app.Activity;
import android.os.Bundle;

import com.sunteng.aynalyticsdemo.R;
import com.sunteng.statservice.StatService;

public class MainActivity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
	}

	@Override
	protected void onPause() {
	    super.onPause();
	    StatService.onPause(this);
	}

	@Override
	protected void onResume() {
	    super.onResume();
	    StatService.onResume(this);
	}
}