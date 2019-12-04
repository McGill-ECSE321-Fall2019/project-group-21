package ca.mcgill.ecse321.tutoringcompany;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import cz.msebera.android.httpclient.Header;

public class RoomPage extends AppCompatActivity {
String error;

    /**
     * Initialize activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_page);
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
     * Create an individual room
     *
     * @param v
     */
    public void CreateIndividualRoom(View v){
        error = "";
        final TextView tv = (TextView) findViewById(R.id.IndividualRoomNumber);

        final int number = Integer.parseInt(tv.getText().toString());
        boolean isgroup = false;


        HttpUtils.post("Manager/Create/Room" +"?roomNumber=" + number+"&RoomTypeIsGroup=" + isgroup, new RequestParams(), new TextHttpResponseHandler() {
            //@Override
            public void onSuccess(int statusCode, Header[] headers, String response) {




                error ="individual room number " + number+ " is created";

                refreshErrorMessage();

            }
            public void onFailure(int statusCode, Header[] headers, String errorResponseString, Throwable throwable) {
                error = "wrong format or empty input";
                refreshErrorMessage();


            }

        });



    }

    /**
     * Create a group room
     *
     * @param v
     */
    public void CreateGroupRoom(View v){
        error = "";
        final TextView tv = (TextView) findViewById(R.id.GroupRoomNumber);

        final int number = Integer.parseInt(tv.getText().toString());
        boolean isgroup = true;


        HttpUtils.post("Manager/Create/Room" +"?roomNumber=" + number+"&RoomTypeIsGroup=" + isgroup, new RequestParams(), new TextHttpResponseHandler() {
            //@Override
            public void onSuccess(int statusCode, Header[] headers, String response) {
                //System.out.println(response.toString());
                System.out.println("onSuccess ============");


                error ="group room number " + number+ " is created";

                refreshErrorMessage();

            }
            public void onFailure(int statusCode, Header[] headers, String errorResponseString, Throwable throwable) {
                error = "wrong format or empty input";
                refreshErrorMessage();


            }

        });



    }

    /**
     * Displays error message on the screen, if there is any
     */
    private void refreshErrorMessage() {
        // set the error message
        TextView tvError = (TextView) findViewById(R.id.RoomMsg);
        tvError.setText(error);

        if (error == null || error.length() == 0) {
            tvError.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.VISIBLE);
        }
    }
}
