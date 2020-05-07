package adventures.com.shopstop;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.media.ImageReader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {
    ImageView back,next;
    EditText email,number;
    CheckBox terms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email=findViewById(R.id.email);

        back=findViewById(R.id.back);
        next=findViewById(R.id.next);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent(sign_up.this,Signup.class);
                startActivity(b);
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (email.getText().toString().equals("")){
                alert();
            }else{
                Intent n=new Intent(sign_up.this,Main2Activity.class);
                startActivity(n);
                finish();
            }
            }
        });
    }
    public void alert(){
        AlertDialog.Builder alertdialogbuilder= new AlertDialog.Builder(sign_up.this);
        alertdialogbuilder.setMessage("Please Write Correct Email");
        alertdialogbuilder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                Toast.makeText(sign_up.this,"Please Enter Email to Continue",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=alertdialogbuilder.create();
        alertDialog.show();

    }
}
