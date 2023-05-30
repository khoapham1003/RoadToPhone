package com.example.a21521003_phonenumdictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private ListView lv_PhoneNum;
    ArrayList<PhoneNumber> arrPhoneNum;
    PhoneNumberAdapter adapter;
    public static final int REQUEST_READ_CONTACTS = 79;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_PhoneNum = (ListView) findViewById(R.id.lv_phonenum);
        arrPhoneNum = new ArrayList<PhoneNumber>();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED) {
            arrPhoneNum = getAllContacts();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_CONTACTS)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS},
                        REQUEST_READ_CONTACTS);
            }
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_CONTACTS)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS},
                        REQUEST_READ_CONTACTS);
            }
        }
        adapter = new PhoneNumberAdapter(this, R.layout.phonenum_layout, arrPhoneNum);
        lv_PhoneNum.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) //them menu
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_ascending_order: {
                Collections.sort(arrPhoneNum, new Comparator<PhoneNumber>() {
                    @Override
                    public int compare(PhoneNumber pn1, PhoneNumber pn2) {
                        return pn1.getName().compareTo(pn2.getName());
                    }
                });
                adapter.notifyDataSetChanged();
                break;
            }
            case R.id.menu_descending_order: {
                Collections.sort(arrPhoneNum, new Comparator<PhoneNumber>() {
                    @Override
                    public int compare(PhoneNumber pn1, PhoneNumber pn2) {
                        return pn2.getName().compareTo(pn1.getName());
                    }
                });
                adapter.notifyDataSetChanged();
                break;
            }
            case R.id.menu_add: {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("Range")
    private ArrayList getAllContacts() {
        ArrayList<PhoneNumber> testList = new ArrayList<>();
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                int hasPhoneNumber = Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {
                    PhoneNumber phoneNumber = new PhoneNumber();
                    String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    phoneNumber.setName(name);

                    Cursor phoneCursor = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id},
                            null);
                    if (phoneCursor.moveToNext()) {
                        String pn = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        phoneNumber.setPhoneNum(pn);
                    }
                    phoneCursor.close();
                    testList.add(phoneNumber);

                }
            }
        }
        cur.close();
        return testList;
    }
}
