package com.example.examenfinal.Vistas;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.examenfinal.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.mostrararticulos)
public class vistasArticulos {
    @View(R.id.volume)
    private TextView volume;

    @View(R.id.number)
    private TextView number;

    @View(R.id.year)
    private TextView year1;

    @View(R.id.date_published)
    private ImageView date_published;
    @View(R.id.title)
    private ImageView title;
    @View(R.id.doi)
    private ImageView doi;
    @View(R.id.cover)
    private ImageView cover;
}
