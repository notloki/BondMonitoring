package com.notloki.bondMonitoring;

import android.app.LauncherActivity;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.TextView;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class BondHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bond_history);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Export History", Snackbar.LENGTH_LONG)
                        .setAction("Share",this);
            }
        });
    }

    @Override
    protected void onResume() {
        TextView textView = findViewById(R.id.historyTextViewBody);
        HistoryPrefs hp = new HistoryPrefs(getApplicationContext());
        Collection<HistoryObj> col = new ArrayList<>(hp.loadTenHistories(getApplicationContext()));
        while(col.iterator().hasNext()) {
            HistoryObj hO = col.iterator().next();
            textView.append(new StringBuilder().append(
                    hO.getDate()).append(" ").append(
                            hO.getText()).append(" ").append(
                                    hO.getTransaction_key())
                    );
        }


        super.onResume();


    }
}




    

