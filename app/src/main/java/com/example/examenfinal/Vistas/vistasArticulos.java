package com.example.examenfinal.Vistas;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenfinal.R;
import com.example.examenfinal.models.Revistas;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.example.examenfinal.R;
import com.example.examenfinal.models.articulos;
@Layout(R.layout.mostrararticulos)
public class vistasArticulos {
    @View(R.id.volume)
    private TextView volume;
    @View(R.id.number)
    private TextView number;
    @View(R.id.year)
    private TextView year1;
    @View(R.id.date_published)
    private TextView date_published;
    @View(R.id.title)
    private TextView title;
    @View(R.id.doi)
    private TextView doi;
    @View(R.id.cover)
    private ImageView cover;
    private articulos mInfo;
    private Context mContext;
    public vistasArticulos(Context context, articulos info) {
        mContext = context;
        mInfo = info;
    }
    @Resolve
    private void onResolved() {
        volume.setText(mInfo.getVolume());
        number.setText(mInfo.getNumber());
        year1.setText(mInfo.getYear());
        date_published.setText(mInfo.getDate_published());
        title.setText(mInfo.getTitle());
        doi.setText(mInfo.getDoi());
        Glide.with(mContext).load(mInfo.getCover()).into(cover);
    }

}
