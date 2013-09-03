package test.shuvo.androidpractice;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class DatePickerActivity extends Activity {
	private DatePicker datePicker;
	private int dayOfMonth, monthOfYear, year;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_date_picker);
		this.datePicker = (DatePicker) this.findViewById(R.id.datePicker);
		this.getCurrentDate();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.date_picker, menu);
		return true;
	}

	private void getCurrentDate() {
		Calendar currentCalendar = Calendar.getInstance();
		dayOfMonth = currentCalendar.get(Calendar.DAY_OF_MONTH);
		monthOfYear = currentCalendar.get(Calendar.MONTH);
		year = currentCalendar.get(Calendar.YEAR);
		this.datePicker.init(year, monthOfYear, dayOfMonth,
				onDateChangedListener);
	}

	private DatePicker.OnDateChangedListener onDateChangedListener = new DatePicker.OnDateChangedListener() {

		@Override
		public void onDateChanged(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			Toast.makeText(
					DatePickerActivity.this,
					"Month : " + (monthOfYear + 1) + ", Day : " + dayOfMonth
							+ ", Year : " + year, Toast.LENGTH_SHORT).show();
			;
		}
	};
}
