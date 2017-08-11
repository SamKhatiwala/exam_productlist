package com.example.macstudent.test1_c0696397_mad4124;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by macstudent on 2017-08-10.
 */

public class EmpData extends RealmObject {
    @PrimaryKey
    String eid;
    @Required
    String ename;
    String birth;
    String Salary;
}
