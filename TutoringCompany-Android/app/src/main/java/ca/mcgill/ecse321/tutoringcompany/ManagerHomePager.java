package ca.mcgill.ecse321.tutoringcompany;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ManagerHomePager extends AppCompatActivity {

    /**
     * This method runs after the creation of the page
     * Initialize activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home_pager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Opens the tutors page and displays it in the view
     *
     * @param v
     */
    public void openTutorsPage(View v) {
        Intent intent = new Intent(this, TutorsPage.class);
        startActivity(intent);
    }

    /**
     * Opens the rooms page and displays it in the view
     *
     * @param v
     */
    public void openRoomsPage(View v) {
        Intent intent = new Intent(this, RoomPage.class);
        startActivity(intent);
    }
}
