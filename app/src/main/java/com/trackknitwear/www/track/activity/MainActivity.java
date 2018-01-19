package com.trackknitwear.www.track.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.trackknitwear.www.track.R;
import com.trackknitwear.www.track.adapter.GalleryAdapter;
import com.trackknitwear.www.track.fragment.SlideshowDialogFragment;
import com.trackknitwear.www.track.model.Image;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Image> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
        getSupportActionBar().setTitle("Track Catalog");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        images = new ArrayList<>();

        images.add(new Image("T101",R.drawable.image0));
        images.add(new Image("T102",R.drawable.image1));
        images.add(new Image("T103",R.drawable.image2));
        images.add(new Image("T104",R.drawable.image3));
        images.add(new Image("T105",R.drawable.image4));
        images.add(new Image("T106",R.drawable.image5));
        images.add(new Image("T107",R.drawable.image6));
        images.add(new Image("T108",R.drawable.image7));
        images.add(new Image("T109",R.drawable.image8));
        images.add(new Image("T110",R.drawable.image9));
        images.add(new Image("T111",R.drawable.image10));
        images.add(new Image("T112",R.drawable.image11));
        images.add(new Image("T113",R.drawable.image12));
        images.add(new Image("T114",R.drawable.image13));
        images.add(new Image("T115",R.drawable.image14));
        images.add(new Image("T116",R.drawable.image15));
        images.add(new Image("T117",R.drawable.image16));
        images.add(new Image("T118",R.drawable.image17));
        images.add(new Image("T119",R.drawable.image18));


        GalleryAdapter mAdapter = new GalleryAdapter(getApplicationContext(), images);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new GalleryAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new GalleryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("images", images);
                bundle.putInt("position", position);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                SlideshowDialogFragment newFragment = SlideshowDialogFragment.newInstance();
                newFragment.setArguments(bundle);
                newFragment.show(ft, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_menu:
                return true;
            case R.id.contact_menu:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
