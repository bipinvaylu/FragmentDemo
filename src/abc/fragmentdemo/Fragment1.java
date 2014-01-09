package abc.fragmentdemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class Fragment1 extends Fragment
{
	public static final String TAG = "Fragment1";

	public Fragment1() {
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.d(TAG, "[onConfigurationChanged]");
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment1, null);
		view.findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((MainActivity) getActivity()).setFragment(Fragment1.this, new Fragment2());
			}
		});
		return view;
	}
}
