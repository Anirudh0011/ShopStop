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
import android.widget.ImageView;

import java.util.ArrayList;


public class mobiles extends Fragment {

    public mobiles() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mobiles, container, false);

        Gphones = (RecyclerView) view.findViewById(R.id.Gphone);
        int numberOfColumns = 2;
        getdata();

        return view;
    }

    ArrayList<recycler_model> recycler_modelArrayList = new ArrayList<>();
    mobiles_adapter gadapter;
    RecyclerView Gphones;
    ImageView thumbsup;

    private void getdata() {

        recycler_modelArrayList.add(new recycler_model("9","Samsung S10 Plus ", "₹84,900", R.drawable.s10plus));
        recycler_modelArrayList.add(new recycler_model("10","Asus Zenfone Max pro m1 ", "₹13,999", R.drawable.xtood));
        recycler_modelArrayList.add(new recycler_model("11","Xiaomi Mi A2 ", "₹11,999", R.drawable.mia2));
        recycler_modelArrayList.add(new recycler_model("12","Redmi note 7 pro ", "₹13,999", R.drawable.note7pro));
        recycler_modelArrayList.add(new recycler_model("13","Samsung Note 8", "₹36,990", R.drawable.note8));
        recycler_modelArrayList.add(new recycler_model("14","Oppo f11 Pro ", "₹24,990", R.drawable.oppof11));
        recycler_modelArrayList.add(new recycler_model("15","Vivo V15 Pro", "28,990", R.drawable.vivov15));
        recycler_modelArrayList.add(new recycler_model("16","Samsung Galaxy A50 ", "₹19,990", R.drawable.galaxya50));


        final GridLayoutManager GridLayoutManager = new GridLayoutManager(getContext(), 2);
        GridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        Gphones.setLayoutManager(GridLayoutManager);
        gadapter = new mobiles_adapter(getActivity(), recycler_modelArrayList,mobiles.this,getContext());
        Gphones.setAdapter(gadapter);
    }

    public void nextpage3(){
        Intent i= new Intent(getContext(),single_product.class);
        startActivity(i);
    }
}