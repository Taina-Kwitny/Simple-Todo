package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> todoItems;
    ArrayAdapter<String> aToDoAdapter;
    ListView lvItems;
    EditText etEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateArrayItems();
        lvItems = (ListView) findViewById(R.id.lvItems);
        lvItems.setAdapter(aToDoAdapter);
        etEditText = (EditText) findViewById(R.id.etEditText);
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                todoItems.remove(position);
                aToDoAdapter.notifyDataSetChanged();
                writeItems();
                return true;
            }
        });
// editView tries
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
// send to edit item view
// edit item view needs to be able to save changes
                textToEdit = lvItems.getItemAtPosition(position);
                launchEditView(textToEdit, position);
                aToDoAdapter.notifyDataSetChanged();
                writeItems();
//                return true;
            }
        });
    }
    private final int REQUEST_CODE = 1;

    private Object textToEdit;

    public void launchEditView(Object o, int position){
        Intent launchEditViewPage = new Intent(MainActivity.this, EditItemActivity.class);
//        EditText textToEdit = (EditText) findViewById(R.id.etEditText);
        String editMe = (String) o;
        launchEditViewPage.putExtra("editMe", editMe);
        launchEditViewPage.putExtra("index", position);
//        startActivity(launchEditViewPage);
        startActivityForResult(launchEditViewPage, REQUEST_CODE);
    }
    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            // Extract name value from result extras
            String name = data.getExtras().getString("editedText");
            int position = data.getExtras().getInt("daIndex");
            todoItems.set(position, name);
            aToDoAdapter.notifyDataSetChanged();
            writeItems();
        }
        else {
            Toast toast = Toast.makeText(this, "Oops, something went wrong!", Toast.LENGTH_LONG);
            toast.show();
        }
    }
    public void populateArrayItems (){
        todoItems = new ArrayList<String>();
        readItems();
        aToDoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
    }

    private void readItems (){
        File filesDir = getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try{
            todoItems = new ArrayList<String>(FileUtils.readLines(file));
        }
        catch (IOException e) {
            Toast.makeText(this, "No file found", Toast.LENGTH_SHORT);
        }
    }

    private void writeItems (){
        File filesDir = getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try{
            FileUtils.writeLines(file, todoItems);
        }
        catch (IOException e) {

        }
    }

    public void onAddItem(View view) {
        aToDoAdapter.add(etEditText.getText().toString());
        etEditText.setText("");
        writeItems();
    }
}
