package com.example.examenfinal.MostarVistas;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.examenfinal.Vistas.vistasItem;
import com.example.examenfinal.models.Revistas;
import com.mindorks.placeholderview.InfinitePlaceHolderView;
import com.mindorks.placeholderview.annotations.infinite.LoadMore;

import java.util.List;

public class mostarItemsArticulos {

    public static final int LOAD_VIEW_SET_COUNT = 6;

    private InfinitePlaceHolderView Vista;
    private List<Revistas> Listar;

    public mostarItemsArticulos(InfinitePlaceHolderView loadMoreView, List<Revistas> feedList) {
        this.Vista = loadMoreView;
        this.Listar = feedList;
    }
    @LoadMore
    private void onLoadMore(){
        Log.d("DEBUG", "onLoadMore");
        new mostarItemsArticulos.ForcedWaitedLoading();
    }
    class ForcedWaitedLoading implements Runnable{
        public ForcedWaitedLoading() {
            new Thread(this).start();
    }
        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    int count = Vista.getViewCount();
                    Log.d("DEBUG", "count " + count);
                    for (int i = count - 1;
                         i < (count - 1 + mostrarvistasitems.LOAD_VIEW_SET_COUNT) && Listar.size() > i;
                         i++) {
                        Vista.addView(new vistasItem(Vista.getContext(), Listar.get(i)));

                        if(i == Listar.size() - 1){
                            Vista.noMoreToLoad();
                            break;
                        }
                    }
                    Vista.loadingDone();
                }
            });
        }
    }}
