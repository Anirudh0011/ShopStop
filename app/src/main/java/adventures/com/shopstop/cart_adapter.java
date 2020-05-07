package adventures.com.shopstop;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class cart_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity activity;
    ArrayList<cart_modal> cart_modalArrayList;

    public cart_adapter(Activity activity, ArrayList<cart_modal> cart_modalArrayList) {
        this.activity = activity;
        this.cart_modalArrayList = cart_modalArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder show = null;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_cart, viewGroup, false);
        show = new cart_adapter.recyclerMain1(view);

        return show;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        final cart_adapter.recyclerMain1 holder = (cart_adapter.recyclerMain1) viewHolder;
        final cart_modal inthis = cart_modalArrayList.get(i);


        holder.setData1(inthis);

    }

    @Override
    public int getItemCount() {
        return cart_modalArrayList.size();
    }

    public class recyclerMain1 extends RecyclerView.ViewHolder {

        TextView product_name, product_price;
        ImageView img1;
        cart_modal cart_modal;

        public recyclerMain1(View view) {
            super(view);
            product_name = (TextView) itemView.findViewById(R.id.product_name);
            product_price = (TextView) itemView.findViewById(R.id.product_price);
            img1 = (ImageView) itemView.findViewById(R.id.img1);
        }

        public void setData1(cart_modal cart_modal) {
            this.cart_modal= cart_modal;
            product_name.setText(cart_modal.name);
            product_price.setText(cart_modal.price);
            img1.setImageResource(cart_modal.pic);
        }
    }
}