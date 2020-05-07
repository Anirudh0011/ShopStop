package adventures.com.shopstop;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.LinearLayout.VERTICAL;

public class cart_items extends AppCompatActivity {
    ArrayList<cart_modal> recycler_modelArrayList = new ArrayList<>();
    cart_adapter gadapter;
    TextView gotocart;
    RecyclerView Cartlist;
    ImageView back_to_home,to_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_items);
        gotocart=(TextView)findViewById(R.id.gotocart);
        back_to_home=findViewById(R.id.back_to_home);
        to_notification=findViewById(R.id.to_notification);
        gotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pay=new Intent(cart_items.this,payment.class);
                startActivity(pay);
            }
        });
        back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o=new Intent(cart_items.this,Main2Activity.class);
                startActivity(o);
                finish();
            }
        });
        to_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p=new Intent(cart_items.this,Notification_screen.class);
                startActivity(p);
                finish();
            }
        });
        Cartlist = (RecyclerView) findViewById(R.id.cartlist);
        getdata();

        SharedPreferences sharedPreferences= this.getSharedPreferences("ShopStop",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString("NAME","Radhika");
        editor.apply();


    }

    private void getdata() {

        recycler_modelArrayList.add(new cart_modal("Apple Macbook Air ", "₹75,990", R.drawable.apple));
        recycler_modelArrayList.add(new cart_modal("Alienware 15 ", "₹3,21,609", R.drawable.alienware));
        recycler_modelArrayList.add(new cart_modal("Asus Rog Strix ", "₹1,01,990", R.drawable.rog));
        recycler_modelArrayList.add(new cart_modal("Asus Core i3 ", "₹47,990", R.drawable.asus));
        recycler_modelArrayList.add(new cart_modal("Msi GL series ", "₹60,990", R.drawable.msi));
        recycler_modelArrayList.add(new cart_modal("Lenovo Ideapad 330 ", "₹43,990", R.drawable.lenovo));
        recycler_modelArrayList.add(new cart_modal("Hp 15q APU ", "24,990", R.drawable.hp));
        recycler_modelArrayList.add(new cart_modal("Dell Vostro 15 ", "₹43,990", R.drawable.dell));


        final LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        LinearLayoutManager.setOrientation(VERTICAL);
        Cartlist.setLayoutManager(LinearLayoutManager);
        gadapter = new cart_adapter(cart_items.this,recycler_modelArrayList);
        Cartlist.setAdapter(gadapter);
    }

    public void alert(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure, You wanted to make decision");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(cart_items.this, "You clicked yes button", Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
