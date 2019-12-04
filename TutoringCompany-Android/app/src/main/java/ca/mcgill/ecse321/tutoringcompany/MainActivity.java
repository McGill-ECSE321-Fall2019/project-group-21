package ca.mcgill.ecse321.tutoringcompany;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;




public class MainActivity extends AppCompatActivity {
    private String error = null;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.Loginbtn);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openManagerHomePage();
//            }
//        });



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
        refreshErrorMessage();
    }
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

    public void login(View v) {
        error = "";
        final TextView tv = (TextView) findViewById(R.id.email);
        final TextView tv2 = (TextView) findViewById(R.id.password);
        HttpUtils.post("Manager/Login" +"?ManagerEmail=" + tv.getText().toString()+"&ManagerPassword=" + tv2.getText().toString(), new RequestParams(), new TextHttpResponseHandler() {
            //@Override
            public void onSuccess(int statusCode, Header[] headers, String response) {
                //System.out.println(response.toString());
                System.out.println("onSuccess ============");
                refreshErrorMessage();
                openManagerHomePage();
                tv.setText("");
                tv2.setText("");
            }
            public void onFailure(int statusCode, Header[] headers, String errorResponseString, Throwable throwable) {
                try {
                    JSONObject errorResponseJSON = new JSONObject(errorResponseString);
                    error += errorResponseJSON.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }
                refreshErrorMessage();
                tv.setText("");
                tv2.setText("");
            }

        });
    }

    public void logout(View v) {
        error = "";
//        final TextView tv = (TextView) findViewById(R.id.email);
//        final TextView tv2 = (TextView) findViewById(R.id.password);
        HttpUtils.post("Manager/Logout", new RequestParams(), new TextHttpResponseHandler() {
            //@Override
            public void onSuccess(int statusCode, Header[] headers, String response) {
                //System.out.println(response.toString());
                refreshErrorMessage();
            }
            public void onFailure(int statusCode, Header[] headers, String errorResponseString, Throwable throwable) {
                try {
                    JSONObject errorResponseJSON = new JSONObject(errorResponseString);
                    error += errorResponseJSON.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }

                refreshErrorMessage();
                tv.setText("");
                tv2.setText("");
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

    public void openManagerHomePage(){
        Intent intent = new Intent(this, ManagerHomePager.class);
        startActivity(intent);
    }
}