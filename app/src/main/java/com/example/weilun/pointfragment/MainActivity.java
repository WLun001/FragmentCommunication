package com.example.weilun.pointfragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements InputFragment.OnButtonClickedListener{

    public final static String MIDPOINT = "com.example.weilun.pointfragment.MIDPOINT";
    @Override
    public void onButtonClicked(Line line) {
        Point midpoint = line.getMidPoint();

        OutputFragment outputFragment = new OutputFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MIDPOINT, midpoint);
        outputFragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //replace whatever is in the fragment_container view with this fragment
        //add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, outputFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //check that the activity is using he layout version with the fragment_container FrameLayout
        if(findViewById(R.id.fragment_container) != null){
            //if we are being restored from previous state, dn do anything
            //we could end up with overlapping fragments
            if(savedInstanceState != null){
                return;
            }
            //create a new Fragment and placed in the activity layout
            InputFragment inputFragment = new InputFragment();

            //in case this activity was started with special instructions from an
            //Intent, pass the Intent's extras to the fragment as arguments
            inputFragment.setArguments(getIntent().getExtras());

            //add the fragment to the fragment_container FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, inputFragment).commit();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
