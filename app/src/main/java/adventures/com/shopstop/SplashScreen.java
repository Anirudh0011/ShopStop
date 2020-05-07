package adventures.com.shopstop;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class SplashScreen extends AppCompatActivity {
        Handler handler;
    ImageView move1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        move1=findViewById(R.id.move1);

        Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        move1.startAnimation(animation);


        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent s=new Intent(SplashScreen.this,Signup.class);
                startActivity(s);
                finish();
            }
        },3000);


            String refreshedToken = FirebaseInstanceId.getInstance().getToken();

           // Log.e("here",refreshedToken);
    }

}
