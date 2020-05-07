package adventures.com.shopstop;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class laptops extends Fragment {

    public laptops() {
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
        View view= inflater.inflate(R.layout.fragment_laptops, container, false);
        Glist = (RecyclerView)view.findViewById(R.id.Stlist);
        int numberOfColumns = 2;
        getdata();

        return view;

    }
    ArrayList<recycler_model> recycler_modelArrayList = new ArrayList<>();
    laptops_adapter gadapter;
    RecyclerView Glist;

    private void getdata() {

        recycler_modelArrayList.add(new recycler_model("17","Apple Macbook Air ", "₹75,990", R.drawable.apple));
        recycler_modelArrayList.add(new recycler_model("18","Alienware 15 ", "₹3,21,609", R.drawable.alienware));
        recycler_modelArrayList.add(new recycler_model("19","Asus Rog Strix ", "₹1,01,990", R.drawable.rog));
        recycler_modelArrayList.add(new recycler_model("20","Asus Core i3 ", "₹47,990", R.drawable.asus));
        recycler_modelArrayList.add(new recycler_model("21","Msi GL series ", "₹60,990", R.drawable.msi));
        recycler_modelArrayList.add(new recycler_model("22","Lenovo Ideapad 330 ", "₹43,990", R.drawable.lenovo));
        recycler_modelArrayList.add(new recycler_model("23","Hp 15q APU ", "24,990", R.drawable.hp));
        recycler_modelArrayList.add(new recycler_model("24","Dell Vostro 15 ", "₹43,990", R.drawable.dell));


        final GridLayoutManager GridLayoutManager = new GridLayoutManager(getContext(), 2);
        GridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        Glist.setLayoutManager(GridLayoutManager);
        gadapter = new laptops_adapter(getActivity(),recycler_modelArrayList,laptops.this,getContext());
        Glist.setAdapter(gadapter);
    }

    public void nextpage2(){
        Intent i= new Intent(getContext(),single_product.class);
        startActivity(i);
    }
}