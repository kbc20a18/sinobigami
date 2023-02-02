package com.example.sinobigami;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class GridAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final String[] tokugilist;
    private final String[] elementlist;
    private final int TitleLayoutId;
    private final int ElementLayoutId;
    static class ViewHoldertokugilist{
        TextView gct_tv;
        CheckBox gct_cb1;
        CheckBox gct_cb2;
    }
    static class ViewHolderelementlist{
        ConstraintLayout gce_cl;
        TextView gce_tv;
    }

    GridAdapter(Context context, int titleLayoutId, int elemetLayoutId, String[] tokugi, String[] element){
        inflater = LayoutInflater.from(context);
        TitleLayoutId = titleLayoutId;
        ElementLayoutId = elemetLayoutId;
        tokugilist = tokugi;
        elementlist = element;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoldertokugilist tokugiHolder = new ViewHoldertokugilist();
        ViewHolderelementlist elementHolder = new ViewHolderelementlist();
            if (convertView == null) {
                convertView = inflater.inflate(ElementLayoutId,null);
                elementHolder.gce_tv = convertView.findViewById(R.id.gce_tv);
                elementHolder.gce_cl = convertView.findViewById(R.id.gce_cl);
                convertView.setTag(elementHolder);
            } else {
                elementHolder = (ViewHolderelementlist) convertView.getTag();
            }
            //実数格納
            elementHolder.gce_tv.setText(elementlist[position]);
            System.out.println(position);
        return convertView;
    }
    @Override
    public int getCount() {
        return elementlist.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
