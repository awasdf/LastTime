package com.example.lasttime.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lasttime.R;
import com.example.lasttime.domain.CallInfo;
import com.example.lasttime.service.CallInfoService;
import com.example.lasttime.service.IDUDDatebase;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;

/**
 * Created by ggrc on 2017/10/31.
 */

public class UserLastTimeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.user_lasttime_activity);
        ListView listView = (ListView)findViewById(R.id.user_last_time);
        CallInfoService callInfoService = new CallInfoService(MainActivity.dbHelper);
        callInfoService.getCallinfos();
        callInfoService.updateKITH_AND_KIN();
        IDUDDatebase idudDatebase1=new IDUDDatebase("KITH_AND_KIN",MainActivity.dbHelper);
        List<CallInfo> list1 = idudDatebase1.selectAll();
        List<String> data =new ArrayList<>();
        if(list1.size()!=0){
            for(CallInfo attribute:list1){
                data.add(String.format("您已距离和%s打电话有%d天了",attribute.getCall(),(currentTimeMillis()-attribute.getDate())/86400000));
            }
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(UserLastTimeActivity.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);



    }
}