package com.darkstar.alternity.act;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

		getListView().setOnItemClickListener((parent, view, position, id) ->
			Toast.makeText(this, "Clicked item at: " + position, Toast.LENGTH_SHORT)
		);

		getListView().setOnItemLongClickListener((parent, view, position, id) -> {
			Toast.makeText(this, "Held item at: " + position, Toast.LENGTH_SHORT);
			return true;
		});
	}

	public void addItems(View view) {
		listItems.add("Clicked : " + listItems.size());
		adapter.notifyDataSetChanged();
	}
}
