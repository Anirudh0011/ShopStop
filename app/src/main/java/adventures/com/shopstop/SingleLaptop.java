package adventures.com.shopstop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleLaptop extends AppCompatActivity {

    TextView laptopprice,laptopnametext,laptopname;
    ImageView laptopimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_laptop);

        laptopname=findViewById(R.id.laptopname);
        laptopnametext=findViewById(R.id.laptopnametext);
        laptopprice=findViewById(R.id.laptopprice);
        laptopimg=findViewById(R.id.laptopimg);

    }
}
