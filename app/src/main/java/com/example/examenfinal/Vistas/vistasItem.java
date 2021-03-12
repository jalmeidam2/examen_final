package com.example.examenfinal.Vistas;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import com.example.examenfinal.R;
import com.example.examenfinal.models.Revistas;

@Layout(R.layout.mostrarvistasitem)
public class vistasItem {

    @View(R.id.name)
    private TextView nameTxt;

    @View(R.id.abreviatura)
    private TextView abreviaturaTxt;

    @View(R.id.descripcion)
    private TextView descripcion;

    @View(R.id.portada)
    private ImageView portada;
    @View(R.id.journalThumbnail)
    private TextView journalThumbnail;

    private Revistas mInfo;
    private Context mContext;
    public vistasItem(Context context, Revistas info) {
        mContext = context;
        mInfo = info;
    }
    @Resolve
    private void onResolved() {
        nameTxt.setText(mInfo.getName());
        abreviaturaTxt.setText(mInfo.getAbbreviation());
        descripcion.setText(mInfo.getDescription());
        journalThumbnail.setText(mInfo.getJournal_id());
        Glide.with(mContext).load(mInfo.getPortada()).into(portada);
    }

}
