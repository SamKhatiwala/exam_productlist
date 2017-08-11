package com.example.macstudent.test1_c0696397_mad4124;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    EditText id;
    EditText name;
    EditText birth;
    EditText salary;
    Button btn;
    Button show;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText)findViewById(R.id.id);
        name = (EditText)findViewById(R.id.name);
        birth = (EditText)findViewById(R.id.birth);
        salary = (EditText)findViewById(R.id.salary);
        btn = (Button)findViewById(R.id.btn);
        show = (Button)findViewById(R.id.show);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm.init(getApplicationContext());
                realm=Realm.getDefaultInstance();
                EmpData obj=new EmpData();
                obj.eid=id.getText().toString();
                obj.ename=name.getText().toString();
                obj.birth = birth.getText().toString();
                obj.Salary=salary.getText().toString();
                realm.beginTransaction();
                realm.copyToRealm(obj);
                realm.commitTransaction();
                Toast.makeText(MainActivity.this, "Saved To Realm", Toast.LENGTH_SHORT).show();

            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(getApplicationContext(),ShowActivity.class);
                startActivity(myIntent);
            }
        });


    }
}
