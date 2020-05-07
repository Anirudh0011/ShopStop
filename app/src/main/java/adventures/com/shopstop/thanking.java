package adventures.com.shopstop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class thanking extends AppCompatActivity {
    TextView shop,rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanking);

        shop=(TextView)findViewById(R.id.shop);
        rate= findViewById(R.id.rate);
        
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s=new Intent(thanking.this,Main2Activity.class);
                startActivity(s);
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(thanking.this,Rating.class);
                startActivity(r);
            }
        });
    }
}
