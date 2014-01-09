package abc.fragmentdemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends ActionBarActivity
{
	public static final String TAG = "MainActivity";

	// public interface FragmentCallBack
	// {
	// public void setOrientation(boolean isLandscape);
	//
	// public void notifyConfigurationChanged(boolean isLandscape);
	// }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "[onCreate] BackstackCount: " + getSupportFragmentManager().getBackStackEntryCount());
		setFragment(null, new Fragment1());
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.d(TAG, "[onConfigurationChanged] BackstackCount: " + getSupportFragmentManager().getBackStackEntryCount());
		// for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
		// String name = getSupportFragmentManager().getBackStackEntryAt(i).getName();
		// Fragment fragment = getSupportFragmentManager().findFragmentByTag(name);
		// Log.d(TAG, "[onConfigurationChanged] fragment is : " + (fragment == null ? "null" : fragment.toString()));
		// ((FragmentCallBack) fragment)
		// .notifyConfigurationChanged(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE);
		// }
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void setFragment(Fragment parent, Fragment fragment) {
		Log.d(TAG, "[setFragment]");
		String name = fragment.getClass().getCanonicalName();
		getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, fragment, name)
				.addToBackStack(name).commit();
		// if(fragment instanceof FragmentCallBack) {
		// Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		// int rotation = display.getRotation();
		// ((FragmentCallBack) fragment).setOrientation(rotation == Surface.ROTATION_90
		// || rotation == Surface.ROTATION_270);
		// }
	}

	public void setDetailFragment(Fragment parent, Fragment child) {
		Log.d(TAG, "[setDetailFragment]");
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.detail_layout, child, "detailsFrag").disallowAddToBackStack();
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		ft.commit();
	}

	public void removeDetailFragment(Fragment parent) {
		Log.d(TAG, "[removeDetailFragment]");
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		Fragment fragment = getSupportFragmentManager().findFragmentByTag("detailsFrag");
		if(fragment != null)
			ft.remove(fragment);
		ft.commit();
	}

	@Override
	public void onBackPressed() {
		if(getSupportFragmentManager().getBackStackEntryCount() == 1)
			finish();
		else
			super.onBackPressed();
	}
}
