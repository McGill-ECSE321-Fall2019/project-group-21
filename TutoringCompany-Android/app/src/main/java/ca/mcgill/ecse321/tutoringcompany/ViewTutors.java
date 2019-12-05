package ca.mcgill.ecse321.tutoringcompany;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class ViewTutors extends AppCompatActivity {
  ListView listView;
    private String error = null;

    private List<String> tutorNames = new ArrayList<>();
    private ArrayAdapter<String> tutorAdapter;

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
        setContentView(R.layout.activity_view_tutors);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        listView = (ListView)findViewById(R.id.listview_name);
        ArrayList<String> arrayList = new ArrayList<>();
        // Dummy data, we were able to get the JSONarray from the backend and process it in the commented out method below, but we were unable to return from this method after call
        arrayList.add("Elias");
        arrayList.add("George");
        arrayList.add("Ryan");
        arrayList.add("Caleb");
        arrayList.add("Louca");

//        getNames(tutorNames, "/Manager/get/allTutors");

        System.out.println(tutorNames.size());
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
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

//    public void viewTutors(View v) {
//        error = "";
//        tutorAdapter = new ArrayAdapter<String>(this, android.R.layout.listview_name, tutorNames);
//        ListView tutorListView = (ListView) findViewById(R.id.tutors);
//        tutorListView.setAdapter(tutorAdapter);
//        getNames(tutorAdapter, tutorNames, "/Manager/get/allTutors");
//    }
//
//    private void getNames(final List<String> names, final ArrayAdapter adapter, final String restFunctionName) {
//        //final List<String> names = new ArrayList<>();
//        HttpUtils.get(restFunctionName, new RequestParams(), new JsonHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
//                names.clear();
//                for( int i = 0; i < 3; i++){
//                    try {
//                        names.add(response.getJSONObject(i).getString("first_name"));
//                    } catch (Exception e) {
//                        error += e.getMessage();
//                    }
//                    refreshErrorMessage();
//                }
//                adapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                try {
//                    error += errorResponse.get("message").toString();
//                } catch (JSONException e) {
//                    error += e.getMessage();
//                }
//                refreshErrorMessage();
//            }
//        });
//    }
}
