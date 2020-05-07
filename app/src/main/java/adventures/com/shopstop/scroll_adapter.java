package adventures.com.shopstop;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class scroll_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context context;
    private ArrayList<scroll_modal>scroll_modalArrayList;

    public scroll_adapter(Context context,ArrayList<scroll_modal> scroll_modalArrayList){
        this.context=context;
        this.scroll_modalArrayList=scroll_modalArrayList;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder show=null;
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hori_scroll,viewGroup,false);
        show=new scroll_adapter.recyclerMain(view);

        return show;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final scroll_adapter.recyclerMain holder=(scroll_adapter.recyclerMain) viewHolder;
        final scroll_modal current= scroll_modalArrayList.get(i);

        holder.setData(current);
    }



    @Override
    public int getItemCount() { return scroll_modalArrayList.size();}

    public class recyclerMain extends RecyclerView.ViewHolder {

        TextView scroll_text;
        ImageView scroll_image;
        scroll_modal scroll_modal11;
        String name;

        public recyclerMain(@NonNull View View) {
            super(View);

            scroll_text = (TextView) itemView.findViewById(R.id.scroll_text);
            scroll_image = (ImageView) itemView.findViewById(R.id.scroll_image);
        }

        public void setData(scroll_modal scroll_modal11) {
            this.scroll_modal11 = scroll_modal11;
            scroll_text.setText(scroll_modal11.name);
            scroll_image.setImageResource(scroll_modal11.pic);
        }


    }
}

