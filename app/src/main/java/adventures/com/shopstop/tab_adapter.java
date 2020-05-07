package adventures.com.shopstop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class tab_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity activity;
    ArrayList<recycler_model> recycler_modelArrayList;
    tab fragment;
    Context context;

    public tab_adapter(Activity activity, ArrayList<recycler_model> recycler_modelArrayList, tab fragment, Context context){
        this.activity=activity;
        this.recycler_modelArrayList=recycler_modelArrayList;
        this.fragment=fragment;
        this.context= context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder show=null;
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view,viewGroup,false);
        show=new tab_adapter.recyclerMain(view);

        return show;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        final tab_adapter.recyclerMain holder=(tab_adapter.recyclerMain) viewHolder;
        final recycler_model inthis=recycler_modelArrayList.get(i);

        Log.e("chcek",""+context.toString());

        Log.e("chcek",""+fragment.toString());


        holder.sid=inthis.getPid();
        holder.sname=inthis.getName();
        holder.sprice=inthis.getPrice();
        holder.tosingleLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("chcek","1");

                SharedPreferences sharedPreferences= activity.getSharedPreferences("ShopStop",0);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                Log.e("chcek","2");
                editor.putString("DATA_ID",holder.sid);
                editor.putString("DATA_NAME",holder.sname);
                editor.putString("DATA_PRICE",holder.sprice);
                // editor.putString("imagePreferance", encodeTobase64(holder.grid_img));
                editor.apply();

                fragment.nextpage4();



            }
        });




        holder.setData(inthis);

    }

    @Override
    public int getItemCount() {
        return recycler_modelArrayList.size();
    }

    public class recyclerMain extends RecyclerView.ViewHolder {

        TextView grid_name,grid_price;
        ImageView grid_img;
        recycler_model recycler_model;
        String sid,sname,simg,sprice;
        RelativeLayout tosingleLay;

        public recyclerMain(View view) {
            super(view);
            grid_name=(TextView)itemView.findViewById(R.id.grid_name);
            grid_price=(TextView)itemView.findViewById(R.id.grid_price);
            grid_img=(ImageView)itemView.findViewById(R.id.grid_img);
            tosingleLay=(RelativeLayout)itemView.findViewById(R.id.tosingleLay);
        }

        public void setData( recycler_model recycler_model) {
            this.recycler_model=recycler_model;
            grid_name.setText(recycler_model.name);
            grid_price.setText(recycler_model.price);
            grid_img.setImageResource(recycler_model.pic);
        }


    }

    public static String encodeTobase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        Log.d("Image Log:", imageEncoded);
        return imageEncoded;
    }
}
