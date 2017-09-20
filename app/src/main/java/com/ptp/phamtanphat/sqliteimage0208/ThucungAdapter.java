package com.ptp.phamtanphat.sqliteimage0208;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KhoaPhamPC on 20/9/2017.
 */

public class ThucungAdapter extends BaseAdapter {
    Context context;
    ArrayList<Thucung> thucungArrayList;

    public ThucungAdapter(Context context, ArrayList<Thucung> thucungArrayList) {
        this.context = context;
        this.thucungArrayList = thucungArrayList;
    }

    @Override
    public int getCount() {
        return thucungArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return thucungArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    class ViewHolder{
        TextView txtten;
        ImageView imgthucung;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.dong_thucung,null);
            viewHolder = new ViewHolder();
            viewHolder.imgthucung = view.findViewById(R.id.imageviewthucung);
            viewHolder.txtten = view.findViewById(R.id.textviewtenthucung);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Thucung thucung = (Thucung) getItem(i);
        viewHolder.txtten.setText(thucung.getTen());
        // Chuyen kieu du lieu byte[] sang bitmap

        byte[] hinhanh = thucung.getHinhanh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);

        viewHolder.imgthucung.setImageBitmap(bitmap);
        return view;
    }
}
