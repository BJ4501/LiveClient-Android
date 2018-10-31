package com.bj.liveclient.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.bj.liveclient.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddLiveRoomActivity extends AppCompatActivity {

    private Spinner mSpinner;
    private EditText mRoomNumber;
    private Button mBtnAddRoom;

    private List<Map<String,Object>> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_live_room);

        mSpinner = findViewById(R.id.lr_spinner);
        mRoomNumber = findViewById(R.id.et_room_num);
        mBtnAddRoom = findViewById(R.id.btn_add_live_room);

        mList = new ArrayList<>();

        String[] k = {"image", "text"};
        int[] v = {R.id.img, R.id.tvv};

        SimpleAdapter adapter = new SimpleAdapter(this, getPlatformList(), R.layout.cell_platform, k, v);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mBtnAddRoom.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    //PlatformDataList
    private List<Map<String,Object>> getPlatformList() {
        Map<String, Object> map = new HashMap<>();
        map.put("image", R.drawable.ic_bilibili);
        map.put("text", "哔哩哔哩");
        mList.add(map);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("image", R.drawable.ic_panda);
        map1.put("text", "熊猫直播");
        mList.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("image", R.drawable.ic_zhanqi);
        map2.put("text", "战旗直播");
        mList.add(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("image", R.drawable.ic_douyu);
        map3.put("text", "斗鱼直播");
        mList.add(map3);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("image", R.drawable.ic_huomao);
        map4.put("text", "火猫直播");
        mList.add(map4);
        Map<String, Object> map5 = new HashMap<>();
        map5.put("image", R.drawable.ic_longzhu);
        map5.put("text", "龙珠直播");
        mList.add(map5);
        Map<String, Object> map6 = new HashMap<>();
        map6.put("image", R.drawable.ic_huya);
        map6.put("text", "虎牙直播");
        mList.add(map6);
        Map<String, Object> map7 = new HashMap<>();
        map7.put("image", R.drawable.ic_quanmin);
        map7.put("text", "全民直播");
        mList.add(map7);
        Map<String, Object> map8 = new HashMap<>();
        map8.put("image", R.drawable.ic_cc);
        map8.put("text", "CC直播");
        mList.add(map8);
        Map<String, Object> map9 = new HashMap<>();
        map9.put("image", R.drawable.ic_yizhibo);
        map9.put("text", "一直播");
        mList.add(map9);
        Map<String, Object> map10 = new HashMap<>();
        map10.put("image", R.drawable.ic_twitch);
        map10.put("text", "Twitch");
        mList.add(map10);
        Map<String, Object> map11 = new HashMap<>();
        map11.put("image", R.drawable.ic_openrec);
        map11.put("text", "OpenRec");
        mList.add(map11);
        return mList;
    }
}
