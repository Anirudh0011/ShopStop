package adventures.com.shopstop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class single_product extends AppCompatActivity {

    ImageView singleCart;
    TextView buy,add;
    String dataId,  dataName,dataPrice;
    ImageView backit;
    TextView Sname,Sprice;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product);

        SharedPreferences sharedPreferences= getSharedPreferences("ShopStop",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        dataId= sharedPreferences.getString("DATA_ID","");
        dataName= sharedPreferences.getString("DATA_NAME","");
        dataPrice=sharedPreferences.getString("DATA_PRICE","");
        backit=(ImageView)findViewById(R.id.backit);
        Sprice=(TextView)findViewById(R.id.Sprice);

        Sname=findViewById(R.id.Sname);
        Sname.setText(dataName);
        Sprice.setText(dataPrice);
        add=findViewById(R.id.add);
        buy=findViewById(R.id.buy);
        singleCart=findViewById(R.id.singleCart2);
        singleCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(single_product.this,empty_cart.class);
                startActivity(i);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent(single_product.this,cart_items.class);
                startActivity(b);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(single_product.this,cart_items.class);
                startActivity(a);
            }
        });

        backit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // getSupportFragmentManager().beginTransaction()
                 //       .replace(R.id.base,new laptops())
                   //     .commit();
                onBackPressed();
            }
        });
    }
}
