package adventures.com.shopstop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Rating extends Fragment {

    ImageView s1;

    public Rating() {
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
        View view= inflater.inflate(R.layout.fragment_rating, container, false);

        s1=(ImageView)view.findViewById(R.id.s1);

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1.setImageResource(R.drawable.star2);
            }
        });
        return view;
    }

}
