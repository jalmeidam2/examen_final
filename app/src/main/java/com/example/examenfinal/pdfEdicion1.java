package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.examenfinal.MostarVistas.mostrarItemsPdf;
import com.example.examenfinal.Vistas.vistasPdf;
import com.example.examenfinal.models.pdfEdicion;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class pdfEdicion1 extends AppCompatActivity {
    private pdfEdicion articulos1;
    private List<pdfEdicion> journalsArrayList;
    private RequestQueue requestQueue;
    private InfinitePlaceHolderView vsita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_edicion);
        requestQueue = Volley.newRequestQueue(this);
        vsita = (InfinitePlaceHolderView) findViewById(R.id.loadMoreView);
        WebservicePdf();
    }

    private void Revistass(List<pdfEdicion> feedList1) {
        Log.d("DEBUG", "LoadMoreView.LOAD_VIEW_SET_COUNT " + mostrarItemsPdf.LOAD_VIEW_SET_COUNT);
        for (int i = 0; i < feedList1.size(); i++) {
            vsita.addView(new vistasPdf(this.getApplicationContext(), feedList1.get(i)));
        }
    }

    private void WebservicePdf() {
        journalsArrayList = new ArrayList<>();
        String url = "https://revistas.uteq.edu.ec/ws/pubs.php";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int size = response.length();
                        for (int i = 0; i < size; i++) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.get(i).toString());
                                articulos1 = new pdfEdicion();
                                articulos1.setSection(jsonObject.getString("section"));
                                articulos1.setPublication_id(jsonObject.getString("publication_id"));
                                articulos1.setTitle(jsonObject.getString("title"));
                                articulos1.setDate_published(jsonObject.getString("date_published"));
                                journalsArrayList.add(articulos1);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Revistass(journalsArrayList);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("HttpClient", "error: " + error.toString());
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }

    public void DescargarPDF() {
        try {

            URL url = new URL("https://revistas.uteq.edu.ec/ws/pubs.php");
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setDoOutput(true);
            c.connect();
            String Path = Environment.getExternalStorageDirectory() + "/download/";
            Log.v("PdfManager", "PATH: " + Path);
            File file = new File(Path);
            file.mkdirs();
            FileOutputStream fos = new FileOutputStream("file.pdf");
            InputStream is = c.getInputStream();
            byte[] buffer = new byte[702];
            int len1 = 0;
            while ((len1 = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len1);
            }
            fos.close();
            is.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("PdfManager", "Error: " + e);
        }
        Log.v("PdfManager", "Check: ");
    }
}