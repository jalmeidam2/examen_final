package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.examenfinal.models.Revistas;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.example.examenfinal.MostarVistas.mostrarvistasitems;
import com.example.examenfinal.Vistas.vistasItem;

public class MainActivity extends AppCompatActivity {

    private Revistas revistas;
    private List<Revistas> journalsArrayList;
    private RequestQueue requestQueue;
    private InfinitePlaceHolderView vsita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        vsita = (InfinitePlaceHolderView)findViewById(R.id.loadMoreView);
        getDataWebService();
    }
    private void setupView(List<Revistas> feedList){
        Log.d("DEBUG", "LoadMoreView.LOAD_VIEW_SET_COUNT " + mostrarvistasitems.LOAD_VIEW_SET_COUNT);
        for(int i = 0; i < feedList.size(); i++){
            vsita.addView(new vistasItem(this.getApplicationContext(), feedList.get(i)));
        }
        /* EVITANDO MOSTRAR EL OTRO DE MAS */
        //mLoadMoreView.setLoadMoreResolver(new LoadMoreView(mLoadMoreView, feedList));
    }
    private void getDataWebService() {
        journalsArrayList = new ArrayList<>();
        String url = "https://revistas.uteq.edu.ec/ws/journals.php";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int size = response.length();
                        for (int i = 0; i < size; i++){
                            try {
                                JSONObject jsonObject = new JSONObject(response.get(i).toString());
                                revistas = new Revistas();
                                revistas.setJournal_id(jsonObject.getString("journal_id"));
                                revistas.setPortada(jsonObject.getString("portada"));
                                revistas.setAbbreviation(jsonObject.getString("abbreviation"));
                                revistas.setName(jsonObject.getString("name"));
                                journalsArrayList.add(revistas);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        setupView(journalsArrayList);
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

}