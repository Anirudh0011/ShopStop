package adventures.com.shopstop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;



public class cmaera extends Fragment {


    ArrayList<recycler_model> recycler_modelArrayList = new ArrayList<>();
    recycler_Adapter gadapter;
    RecyclerView Gcam;

    public cmaera() {
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
        View iew= inflater.inflate(R.layout.fragment_cmaera, container, false);

        Gcam = (RecyclerView) iew.findViewById(R.id.Gcam);
        int numberOfColumns = 2;
        getdata();

        SharedPreferences sharedPreferences= getContext().getSharedPreferences("ShopStop",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString("NAME","Radhika");
        editor.apply();

        return  iew;
    }






    private void getdata() {

        recycler_modelArrayList.add(new recycler_model("1","Canon EOS 77D", "₹53,999", R.drawable.canon1));
        recycler_modelArrayList.add(new recycler_model("2","Canon EOS 80D", "₹68,999", R.drawable.canon2));
        recycler_modelArrayList.add(new recycler_model("3","Canon EOS 200D ", "₹48,499", R.drawable.canon3));
        recycler_modelArrayList.add(new recycler_model("4","Canon EOS 800D", "₹48,999", R.drawable.canon4));
        recycler_modelArrayList.add(new recycler_model("5","Canon EOS 1300D", "₹23,999", R.drawable.canon5));
        recycler_modelArrayList.add(new recycler_model("6","Canon EOS 1500D", "₹27,999", R.drawable.canon6));
        recycler_modelArrayList.add(new recycler_model("7","Nikon D3500", "₹28,490", R.drawable.nikon1));
        recycler_modelArrayList.add(new recycler_model("8","Nikon D5600 ", "₹47,499", R.drawable.nikon2));


        final GridLayoutManager GridLayoutManager = new GridLayoutManager(getContext(), 2);
        GridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        Gcam.setLayoutManager(GridLayoutManager);
        gadapter = new recycler_Adapter(getActivity(),recycler_modelArrayList,cmaera.this,getContext());
        Log.e("chcek1111",""+getContext());
        Gcam.setAdapter(gadapter);
    }

    public void nextpage1(){
        Intent i= new Intent(getContext(),single_product.class);
        startActivity(i);
    }
}


