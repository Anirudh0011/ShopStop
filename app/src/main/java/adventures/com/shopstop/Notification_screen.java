package adventures.com.shopstop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Notification_screen extends AppCompatActivity {
    ImageView back_home,to_cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_screen);

        back_home=findViewById(R.id.back_home);
        to_cart=findViewById(R.id.to_cart);

        back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q=new Intent(Notification_screen.this,Main2Activity.class);
                startActivity(q);
                finish();
            }
        });
        to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(Notification_screen.this,cart_items.class);
                startActivity(a);
                finish();
            }
        });
    }
}
