package com.example.macstudent.test1_c0696397_mad4124;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class ShowActivity extends AppCompatActivity {
    Realm realm;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        lv = (ListView) findViewById(R.id.listView);
        Realm.init(this);
        realm = Realm.getDefaultInstance();
        RealmResults<EmpData> test = realm.where(EmpData.class).findAll();
        String[] empid = new String[test.size()];
        String[] empname = new String[test.size()];
        String[] birth = new String[test.size()];
        String[] salary = new String[test.size()];
        for (int i = 0; i < test.size(); i++) {
            empid[i] = test.get(i).eid;
            empname[i] = test.get(i).ename;
            birth[i] = test.get(i).birth;
            salary[i] = test.get(i).Salary;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, empname);
        lv.setAdapter(adapter);


    }
}
