package com.example.examenfinal.Vistas;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenfinal.R;
import com.example.examenfinal.models.articulos;
import com.example.examenfinal.models.pdfEdicion;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

public class vistasPdf {
    @View(R.id.section)
    private TextView volume;
    @View(R.id.publication_id)
    private TextView number;
    @View(R.id.title)
    private TextView year1;
    @View(R.id.date_published)
    private TextView date_published;
    private pdfEdicion Info1;
    private Context Context1;
    public vistasPdf(Context context, pdfEdicion info) {
        Context1 = context;
        Info1 = info;
    }
    @Resolve
    private void onResolved() {

        volume.setText(Info1.getSection());
        number.setText(Info1.getPublication_id());
        year1.setText(Info1.getTitle());
        date_published.setText(Info1.getDate_published());
    }

}
