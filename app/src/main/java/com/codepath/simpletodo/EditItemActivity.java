package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    EditText editText;
    int indexOfText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        String editText = getIntent().getStringExtra(textToEdit);
        setContentView(R.layout.activity_edit_item);
        editText = (EditText) findViewById(R.id.editText);
        editText.setText(getIntent().getExtras().getString("editMe"), TextView.BufferType.EDITABLE);
        indexOfText = getIntent().getExtras().getInt("index");
    }
//    public void onSubmit(View Ma)

    public void saveEdit(View v){
//        MainActivity.writeItems();
        Intent data = new Intent();
        data.putExtra("editedText", editText.getText().toString());
        data.putExtra("daIndex", indexOfText);
        setResult(RESULT_OK, data);
        finish();
    }

}
