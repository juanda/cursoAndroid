package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";
	private static final String PAUSE_KEY = "pause";
	private static final String STOP_KEY = "stop";
	private static final String DESTROY_KEY = "destroy";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
	private  Integer mCreate  = 0;
	private  Integer mStart   = 0;
	private  Integer mResume  = 0;
	private  Integer mRestart = 0;
	private  Integer mPause = 0;
	private  Integer mStop = 0;
	private  Integer mDestroy = 0;
	
	private  static Integer mTotalCreate  = 0;
	private  static Integer mTotalStart   = 0;
	private  static Integer mTotalResume  = 0;
	private  static Integer mTotalRestart = 0;
	private  static Integer mTotalPause = 0;
	private  static Integer mTotalStop = 0;
	private  static Integer mTotalDestroy = 0;

	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc. 
	private TextView mTvCreate  = null;
	private TextView mTvStart   = null;
	private TextView mTvResume  = null;
	private TextView mTvRestart = null;
	private TextView mTvPause = null;
	private TextView mTvStop = null;
	private TextView mTvDestroy = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
		mTvCreate  = (TextView) findViewById(R.id.create);
		mTvStart   = (TextView) findViewById(R.id.start);
		mTvResume  = (TextView) findViewById(R.id.resume);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvPause = (TextView) findViewById(R.id.pause);
		mTvStop = (TextView) findViewById(R.id.stop);
		mTvDestroy = (TextView) findViewById(R.id.destroy);


		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				
				//TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method
				finish();

			
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			Log.i(TAG, "savedInstance != null");
			mCreate  = savedInstanceState.getInt(CREATE_KEY);
			mStart   = savedInstanceState.getInt(START_KEY);
			mResume  = savedInstanceState.getInt(RESUME_KEY);
			mRestart = savedInstanceState.getInt(RESTART_KEY);
			mPause = savedInstanceState.getInt(PAUSE_KEY);
			mStop = savedInstanceState.getInt(STOP_KEY);
			mDestroy = savedInstanceState.getInt(DESTROY_KEY);			

		}

		// TODO: Emit LogCat message
		
		Log.i(TAG, "Entered the onCreate method");


		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		mCreate++;
		mTotalCreate++;
		displayCounts();

	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onStart method");		

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mStart++;
		mTotalStart++;
		displayCounts();
		
	}

	@Override
	public void onResume() {
		super.onResume();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onResume method");	

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mResume++;
		mTotalResume++;
		displayCounts();

	}

	@Override
	public void onPause() {
		super.onPause();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onPause method");
		
		mPause++;
		mTotalPause++;
		displayCounts();
		

	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onStop method");
		
		mStop++;
		mTotalStop++;
		displayCounts();

	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onRestart method");


		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mRestart++;
		mTotalRestart++;
		displayCounts();	
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onDestroy method");
		
		mDestroy++;
		mTotalDestroy++;
		displayCounts();

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// TODO:
		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		Log.i(TAG, "Entered the onSaveInstanceState");
		savedInstanceState.putInt(CREATE_KEY, mCreate);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(PAUSE_KEY, mRestart);
		savedInstanceState.putInt(STOP_KEY, mRestart);
		savedInstanceState.putInt(DESTROY_KEY, mRestart);
		
		super.onSaveInstanceState(savedInstanceState);

	
	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate + ", total calls: " + mTotalCreate);
		mTvStart.setText("onStart() calls: " + mStart + ", total calls: " + mTotalStart);
		mTvResume.setText("onResume() calls: " + mResume + ", total calls: " + mTotalResume);
		mTvRestart.setText("onRestart() calls: " + mRestart + ", total calls: " + mTotalRestart);
		mTvPause.setText("onPause() calls: " + mPause + ", total calls: " + mTotalPause);
		mTvStop.setText("onStop() calls: " + mStop + ", total calls: " + mTotalStop);
		mTvDestroy.setText("onDestroy() calls: " + mDestroy + ", total calls: " + mTotalDestroy);
	
	}
}
