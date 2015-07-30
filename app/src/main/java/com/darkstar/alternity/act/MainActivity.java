package com.darkstar.alternity.act;

import android.app.DialogFragment;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
	ArrayList<String> listItems = new ArrayList<>();
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_main);
		adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
		setListAdapter(adapter);

		getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(MainActivity.this, "Clicked item at: " + ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
			}
		});

		getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(MainActivity.this, "Held item at: " + ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} else
			return super.onOptionsItemSelected(item);
	}

	public void onGetNameClick(View view) {
		Intent getNameScreenIntent = new Intent(this, SecondScreen.class);
		final int result = 1;
		getNameScreenIntent.putExtra("callingActivity", "MainActivity");
//		startActivity(getNameScreenIntent);
		startActivityForResult(getNameScreenIntent, result);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		TextView usersNameMessage = (TextView)findViewById(R.id.users_name_message);
		String nameSentBack = data.getStringExtra("UsersName");
		usersNameMessage.append(" " + nameSentBack);
	}

	public void addItems(View view) {
		listItems.add("Clicked : " + listItems.size());
		adapter.notifyDataSetChanged();
	}
}
