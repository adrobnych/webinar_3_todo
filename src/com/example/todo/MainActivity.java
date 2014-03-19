package com.example.todo;

import com.example.todo.model.ToDoManager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	ToDoManager todoManager = null;
	ListView todoList = null;
	ToDoAdapter a; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		todoManager = ((ToDoApp)getApplication()).getTodoManager();
		a = new ToDoAdapter(getApplicationContext(), todoManager.getTodos());
		
		todoList = (ListView) findViewById(R.id.listView1);
		
		todoList.setAdapter(a);
		
		todoList.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> l, View v,
					int position, long id) {
				todoManager.removeAtPosition(position);
				a.notifyDataSetChanged();
				return true;
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
