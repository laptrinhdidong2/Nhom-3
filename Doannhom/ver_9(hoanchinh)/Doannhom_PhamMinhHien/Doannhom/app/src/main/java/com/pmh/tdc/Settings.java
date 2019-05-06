package com.pmh.tdc;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.pmh.tdc.R;


// Class cài đặt bên góc phải - kế thừa Tham khảo activity
public class Settings extends PreferenceActivity {
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}
}
