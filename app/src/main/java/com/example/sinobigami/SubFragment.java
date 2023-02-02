package com.example.sinobigami;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;


public class SubFragment extends Fragment {
    final String[] tokugi =
            {"器術","体術","忍術","謀術","戦術","妖術"};
    final String[] element =
            {
                    "絡繰術","騎乗術","生存術","医術","兵糧術","異形化",
                    "火術","砲術","潜伏術","毒術","鳥獣術","召喚術",
                    "水術","手裏剣術","遁走術","罠術","野戦術","死霊術",
                    "針術","手練","盗聴術","調査術","地の利","結界術",
                    "仕込み","身体操術","腹話術","詐術","意気","封術",
                    "衣装術","歩法","隠形術","対人術","用兵術","言霊術",
                    "縄術","走法","変装術","遊芸","記憶術","幻術",
                    "登術","飛術","香術","九ノ一の術","見敵術","瞳術",
                    "拷問術","骨法術","分身の術","傀儡の術","暗号術","千里眼の術",
                    "壊器術","刀術","隠蔽術","流言の術","伝達術","憑依術",
                    "掘削術","怪力","第六感","経済力","人脈","呪術"};


    public SubFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_sub,container,false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstaneceState){
        super.onViewCreated(view,savedInstaneceState);
        GridView gridView = view.findViewById(R.id.gridView_tokugi);
        GridAdapter adapter = new GridAdapter(requireContext(),R.layout.gird_cell_titile, R.layout.grid_cell_element,
                tokugi,element);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                adapterView.getItemAtPosition(position);
                //ここ
                TextView textView = view.findViewById(R.id.gce_tv);
                if (textView.getCurrentTextColor() == Color.BLACK){
                    textView.setBackgroundColor(Color.BLACK);
                    textView.setTextColor(Color.WHITE);
                } else{
                    textView.setBackgroundResource(R.drawable.border);
                    textView.setTextColor(Color.BLACK);
                }

            }
        });
    }
}