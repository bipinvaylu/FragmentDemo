package abc.fragmentdemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class Fragment3 extends Fragment
{
	public static final String TAG = "Fragment3";

	public Fragment3() {
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.d(TAG, "[onConfigurationChanged]");
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG, "[onCreateView]");
		View view = inflater.inflate(R.layout.fragment3, null);
		view.setBackgroundColor(android.R.color.holo_orange_dark);
		view.findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((MainActivity) getActivity()).setFragment(Fragment3.this, new Fragment4());
			}
		});
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d(TAG, "[onResume]");
	}
}
