package abc.fragmentdemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class Fragment2 extends Fragment
{
	public static final String TAG = "Fragment2";

	protected boolean mDualPanel;

	public Fragment2() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "[onCreate]");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.d(TAG, "[onActivityCreated]");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.d(TAG, "[onConfigurationChanged]");
		((MainActivity) getActivity()).removeDetailFragment(this);
		super.onConfigurationChanged(newConfig);
		LayoutInflater inflater = LayoutInflater.from(getActivity());
		populateViewForOrientation(inflater, (ViewGroup) getView());
	}

	protected void populateViewForOrientation(LayoutInflater inflater, ViewGroup viewGroup) {
		Log.d(TAG, "[populateViewForOrientation]");
		viewGroup.removeAllViewsInLayout();
		View view = inflater.inflate(R.layout.fragment2, viewGroup);
		initView(view);
		if(mDualPanel) {
			((MainActivity) getActivity()).setDetailFragment(Fragment2.this, new Fragment3());
		} else {
			((MainActivity) getActivity()).setFragment(Fragment2.this, new Fragment3());
		}
	}

	protected void initView(View view) {
		Log.d(TAG, "[initView]");
		View detailsFrame = view.findViewById(R.id.detail_layout);
		mDualPanel = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
		view.findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mDualPanel) {
					((MainActivity) getActivity()).setDetailFragment(Fragment2.this, new Fragment3());
				} else {
					((MainActivity) getActivity()).setFragment(Fragment2.this, new Fragment3());
				}
			}
		});
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG, "[onCreateView]");
		// removeDetailFragmentsFromStack();
		View view = inflater.inflate(R.layout.fragment2, container, false);
		initView(view);
		if(mDualPanel) {
			((MainActivity) getActivity()).setDetailFragment(Fragment2.this, new Fragment3());
		}
		return view;
	}

	@Override
	public void onResume() {
		Log.d(TAG, "[onResume]");
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}
}
