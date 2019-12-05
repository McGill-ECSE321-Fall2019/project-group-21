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
    private String error = null;
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

    }

    /**
     * Displays error message on the screen, if there is any
     */
    private void refreshErrorMessage() {
        // set the error message
        TextView tvError = (TextView) findViewById(R.id.error);
        tvError.setText(error);

        if (error == null || error.length() == 0) {
            tvError.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.VISIBLE);
        }
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

    /**
     * Logout of the application
     *
     * @param v
     */
    public void logout(View v) {
        error = "";
        System.out.println("logging out method");
        HttpUtils.post("Manager/Logout", new RequestParams(), new TextHttpResponseHandler() {
            //@Override
            public void onSuccess(int statusCode, Header[] headers, String response) {
                refreshErrorMessage();
                openManagerLoginPage();
            }
            public void onFailure(int statusCode, Header[] headers, String errorResponseString, Throwable throwable) {
                try {
                    JSONObject errorResponseJSON = new JSONObject(errorResponseString);
                    error += errorResponseJSON.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }

                refreshErrorMessage();

            }

        });
    }

    /**
     * Open the login page for the manager perspective
     */
    public void openManagerLoginPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
