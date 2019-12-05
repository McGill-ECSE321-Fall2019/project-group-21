package ca.mcgill.ecse321.tutoringcompany;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class VerifyTutors extends AppCompatActivity {
    private String error = null;

    /**
     * This method runs after the creation of the page.
     * Initialize activity.
     *
     * @param savedInstanceState
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_tutors);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    /**
     * This method is connected to backend controller that takes a String input (email address)
     * and then verifies the tutors that has this email address
     * if the email is not existed in the backend (Null Pointer Exception is thrown)
     *
     *  @param v
     *
     */
    public void Verify(View v){
        error = "";
        final TextView emailTV = (TextView) findViewById(R.id.TutorEmail);
        HttpUtils.post("Manager/VerifyTutor" +"?email=" + emailTV.getText().toString(), new RequestParams(), new TextHttpResponseHandler() {
            //@Override
            public void onSuccess(int statusCode, Header[] headers, String response) {
                //System.out.println(response.toString());
                System.out.println("onSuccess ============");
                emailTV.setText("");
                error = "your Tutor is verified";
                refreshErrorMessage();
            }
            public void onFailure(int statusCode, Header[] headers, String errorResponseString, Throwable throwable) {
                error = "wrong format or tutor does not exist";
                refreshErrorMessage();
                emailTV.setText("");
            }
        });



    }

    /**
     * Displays error message on the screen, if there is any
     */
    private void refreshErrorMessage() {
        // set the error message
        TextView tvError = (TextView) findViewById(R.id.errorMsg);
        tvError.setText(error);

        if (error == null || error.length() == 0) {
            tvError.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.VISIBLE);
        }
    }
}
