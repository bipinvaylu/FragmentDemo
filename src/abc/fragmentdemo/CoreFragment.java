package abc.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public abstract class CoreFragment extends Fragment //implements FragmentCallBack
{
	protected boolean mIsLandscape;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

//	@Override
//	public void notifyConfigurationChanged(boolean isLandscape) {
//		Log.d(getLogTag(), "[notifyConfigurationChanged] isLandscape: " + isLandscape);
//		mIsLandscape = isLandscape;
//	}
//
//	@Override
//	public void setOrientation(boolean isLandscape) {
//		Log.d(getLogTag(), "[setOrientation] isLandscape: " + isLandscape);
//		mIsLandscape = isLandscape;
//	}

	abstract public String getLogTag();
}
