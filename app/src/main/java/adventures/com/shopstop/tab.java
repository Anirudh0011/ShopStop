package adventures.com.shopstop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class tab extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

            Gtab = (RecyclerView)view.findViewById(R.id.Gtab);
            int numberOfColumns = 2;
            getdata();
            return view;

        }

        ArrayList<recycler_model> recycler_modelArrayList = new ArrayList<>();
        tab_adapter gadapter;
        RecyclerView Gtab;

        private void getdata () {

            recycler_modelArrayList.add(new recycler_model("25","Apple Ipad Pro", "₹89,990", R.drawable.ipadpro));
            recycler_modelArrayList.add(new recycler_model("26","Apple Ipad (6th Gen) ", "₹34,600", R.drawable.ipad6));
            recycler_modelArrayList.add(new recycler_model("27","Samsung Tab A ", "₹9,480", R.drawable.taba));
            recycler_modelArrayList.add(new recycler_model("28","Samsung Tab S3 ", "₹45,990", R.drawable.tabs3));
            recycler_modelArrayList.add(new recycler_model("29","Honor MediaPad", "₹14,990", R.drawable.honortab));
            recycler_modelArrayList.add(new recycler_model("30","Samsung Tab J 330 ", "₹12,990", R.drawable.jtab));
            recycler_modelArrayList.add(new recycler_model("31","Lenovo Tab 4", "12,990", R.drawable.lenovotab));
            recycler_modelArrayList.add(new recycler_model("32","Microsoft Surface Go ", "₹49,990", R.drawable.surfacego));


            final GridLayoutManager GridLayoutManager = new GridLayoutManager(getContext(), 2);
            GridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            Gtab.setLayoutManager(GridLayoutManager);
            gadapter = new tab_adapter(getActivity(), recycler_modelArrayList,tab.this,getContext());
            Gtab.setAdapter(gadapter);
        }

    public void nextpage4(){
        Intent i= new Intent(getContext(),single_product.class);
        startActivity(i);
    }
    }


