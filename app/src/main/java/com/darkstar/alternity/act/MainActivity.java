package com.darkstar.alternity.act;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
	ArrayList<String> listItems = new ArrayList<>();

	ArrayAdapter<String> adapter;

	int clickCounter = 0;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_main);
		adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
		setListAdapter(adapter);
	}

	public void addItems(View view) {
		listItems.add("Clicked : " + clickCounter++);
		adapter.notifyDataSetChanged();
	}
}
