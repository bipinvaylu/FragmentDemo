package abc.fragmentdemo;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;

public class Fragment3 extends Fragment
{
	public static final String TAG = "Fragment3";

	protected boolean mIsPaused;

	public Fragment3() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "[onCreate]");
		mIsPaused = false;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.d(TAG, "[onConfigurationChanged]");
		super.onConfigurationChanged(newConfig);
		boolean isInLandscape = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE;
		Log.d(TAG, "[onConfigurationChanged] isInLandscape: " + isInLandscape);
		if(isInLandscape) {
			((MainActivity) getActivity()).getSupportFragmentManager().popBackStack();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG, "[onCreateView]");
		View view = inflater.inflate(R.layout.fragment3, null);
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
		mIsPaused = false;
	}

	@Override
	public void onPause() {
		super.onPause();
		mIsPaused = true;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG, "[onActivityCreated] mIsPaused: " + mIsPaused);
		if(mIsPaused) {
			Display display = ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE))
					.getDefaultDisplay();
			int rotation = display.getRotation();
			boolean isInLandscape = (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270);
			Log.d(TAG, "[onActivityCreated] isInLandscape: " + isInLandscape);
			if(isInLandscape) {
				((MainActivity) getActivity()).getSupportFragmentManager().popBackStack();
			}
		}
	}
}
