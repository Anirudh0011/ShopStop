package adventures.com.shopstop;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static java.security.AccessController.getContext;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager viewpager;
    ViewPager pager;
    viewpageadapter adapter2;
    viewpageadapter adapter;
    int images2[]={R.drawable.qwq,R.drawable.aaaa,R.drawable.asd,R.drawable.open};
    int images[]={R.drawable.mb1,R.drawable.lb,R.drawable.tb,R.drawable.cb};
    ImageView singleCart,notification;
    ArrayList<scroll_modal> scroll_modalArrayList= new ArrayList<>();
    scroll_adapter hori_scroll;
    recycler_Adapter1 recycler_adapter;
    recycler_Adapter2 recycler_adapter2;
    ArrayList<recycler_model>grid_modalArrayList=new ArrayList<>();
    ArrayList<recycler_model>grid2_modal=new ArrayList<>();
    RecyclerView hori_swipe,grid_view,grid_view2;

    int secondpage=0;
    Timer timer2;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 1000;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.
    Dialog dialog;
    ImageView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
       // setSupportActionBar(toolbar);
        viewpager=findViewById(R.id.viewpager);
        pager=findViewById(R.id.pager2);
        hori_swipe=findViewById(R.id.hori_swipe);
        grid_view=findViewById(R.id.grid_view);
        grid_view2=findViewById(R.id.grid_view2);
        singleCart=findViewById(R.id.singleCart);
        notification=findViewById(R.id.notification);
        pages();
        pager();
        datafetch();
        grid_fetch();
        grid2_fetch();
        int numberOfColumns = 2;

        menu=findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);
              /*  if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }*/
            }
        });
        singleCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,cart_items.class);
                startActivity(i);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent(Main2Activity.this,Notification_screen.class);
                startActivity(x);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void datafetch() {
        scroll_modalArrayList.add(new scroll_modal("Laptops",R.drawable.apple));
        scroll_modalArrayList.add(new scroll_modal("Mobiles",R.drawable.s10plus));
        scroll_modalArrayList.add(new scroll_modal("Cameras",R.drawable.canon1));
        scroll_modalArrayList.add(new scroll_modal("Tablets",R.drawable.ipadpro));
        scroll_modalArrayList.add(new scroll_modal("Tablets",R.drawable.ipadpro));
        scroll_modalArrayList.add(new scroll_modal("Tablets",R.drawable.ipadpro));
        scroll_modalArrayList.add(new scroll_modal("Tablets",R.drawable.ipadpro));

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Main2Activity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //list.setLayoutManager(new GridLayoutManager(this, 2));
        hori_swipe.setLayoutManager(linearLayoutManager);
        hori_scroll= new scroll_adapter(this,scroll_modalArrayList);
        hori_swipe.setAdapter(hori_scroll);
    }
    public void grid_fetch(){
        grid_modalArrayList.add(new recycler_model("1","Apple Macbook Air","1400",R.drawable.apple));
        grid_modalArrayList.add(new recycler_model("2","Samsung Galaxy S10+","1233",R.drawable.s10plus));
        grid_modalArrayList.add(new recycler_model("3","Canon EOS 77D","1234",R.drawable.canon1));
        grid_modalArrayList.add(new recycler_model("4","Apple Ipad Pro","4444",R.drawable.ipadpro));

        final GridLayoutManager gridLayoutManager=new GridLayoutManager(new Main2Activity(),2);
        grid_view.setLayoutManager(new GridLayoutManager(this, 2));
        recycler_adapter=new recycler_Adapter1(this,grid_modalArrayList);
        grid_view.setAdapter(recycler_adapter);
    }
    public void grid2_fetch(){
        grid2_modal.add(new recycler_model("111","Apple Macbook Air","140000000000000000",R.drawable.apple));
        grid2_modal.add(new recycler_model("222","Samsung Galaxy S10+","1245634633",R.drawable.s10plus));
        grid2_modal.add(new recycler_model("333","Canon EOS 77D","1233453464",R.drawable.canon1));
        grid2_modal.add(new recycler_model("444","Apple Ipad Pro","43456345444",R.drawable.ipadpro));

        final GridLayoutManager gridLayoutManager=new GridLayoutManager(new Main2Activity(),2);
        grid_view2.setLayoutManager(new GridLayoutManager(this, 2));
        recycler_adapter2=new recycler_Adapter2(this,grid2_modal);
        grid_view2.setAdapter(recycler_adapter2);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent i=new Intent(Main2Activity.this,Main2Activity.class);
            startActivity(i);
        }else

        if (id == R.id.cameras) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.base,new cmaera())
                    .commit();
         //   getSupportFragmentManager().beginTransaction()
                 //   .replace(R.id.base, new cmaera())
                //    .addToBackStack(null)
                 //   .commit();
           // Intent c=new Intent(Main2Activity.this,single_product.class);
           // startActivity(c);
            // Handle the camera action
        } else if (id == R.id.laptops) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.base,new laptops())
                    .commit();

        } else if (id == R.id.mobiles) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.base, new mobiles())
                    .commit();

        } else if (id == R.id.tablets) {
            getSupportFragmentManager().beginTransaction()
                   .replace(R.id.base,new tab())
                   .commit();
        } else if (id == R.id.privacy) {
            getSupportFragmentManager().beginTransaction()
                   .replace(R.id.base,new priv())
                   .commit();
        } else if (id == R.id.rating) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.base,new Rating())
                    .commit();
        } else if (id == R.id.nav_send) {
            Intent l=new Intent(Main2Activity.this,laptops.class);
            startActivity(l);

        } else if (id==R.id.nav_share) {
            Intent l=new Intent(Intent.ACTION_SEND);
            l.setType("text/plain");
            l.putExtra(Intent.EXTRA_SUBJECT,"add what a subject you want");
            //String
            startActivity(l);

        }else if (id==R.id.location) {
            Intent l = new Intent(Main2Activity.this, MapsActivity.class);
            startActivity(l);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void pages() {

       viewpageadapter adapter= new viewpageadapter(Main2Activity.this,images);
        viewpager.setAdapter(adapter);


        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage ==images.length) {
                    currentPage = 0;
                }
                viewpager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }
    public void pager(){

        viewpageadapter adapter=new viewpageadapter(Main2Activity.this,images2);
        pager.setAdapter(adapter);

        final Handler handler=new Handler();
        final Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if (secondpage == images2.length) {
                    secondpage = 0;
                }
                pager.setCurrentItem(secondpage++,true);
            }
        };
        timer2=new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },DELAY_MS,PERIOD_MS);


    }
}
