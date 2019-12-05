package ca.mcgill.ecse321.tutoringcompany;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class TutorsPage extends AppCompatActivity {

    /**
     * This method runs after the creation of the page.
     * Initialize activity.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutors_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    /**
     * Opens a list of all verified tutors and displays it in the View.
     *
     * @param v
     */
    public void openVerifyTutors(View v){
        Intent intent = new Intent(this, VerifyTutors.class);
        startActivity(intent);
    }
    
    /**
     * Opens a list of all tutors, verified or not, and displays it in the View.
     *
     * @param v
     */
    public void openViewTutors(View v){
        Intent intent = new Intent(this, ViewTutors.class);
        startActivity(intent);
    }
}
