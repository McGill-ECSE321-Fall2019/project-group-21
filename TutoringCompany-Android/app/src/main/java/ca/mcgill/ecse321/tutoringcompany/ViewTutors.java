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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        listView = (ListView)findViewById(R.id.listview_name);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Elias");
        arrayList.add("George");
        arrayList.add("Ryan");
        arrayList.add("Caleb");arrayList.add("Louca");

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

        System.out.println(error);
//        TextView tvError = (TextView) findViewById(R.id.errorMsg);
//        tvError.setText(error);
//
//        if (error == null || error.length() == 0) {
//            tvError.setVisibility(View.GONE);
//        } else {
//            tvError.setVisibility(View.VISIBLE);
//        }
    }

//    public void viewTutors(View v) {
//        error = "";
//        tutorAdapter = new ArrayAdapter<String>(this, android.R.layout.listview_name, tutorNames);
//        ListView tutorListView = (ListView) findViewById(R.id.tutors);
//        tutorListView.setAdapter(tutorAdapter);
//        getNames(tutorAdapter, tutorNames, "/Manager/get/allTutors");
//    }

//    private void getNames(final List<String> names, final String restFunctionName) {
//        //final List<String> names = new ArrayList<>();
//        HttpUtils.get(restFunctionName, new RequestParams(), new JsonHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
//                try {
//                    System.out.println(response.getJSONObject(0).toString());
//                    System.out.println(response.getJSONObject(0).getString("first_name"));
//                } catch (Exception e) { error += e.getMessage();System.out.println("error getting 0th"); }
//                names.clear();
//                //names.add("hello"); names.add("name2");
////                names.add("Please select...");
//                System.out.println(response.length());
//                for( int i = 0; i < 3; i++){
//                    try {
//                        names.add(response.getJSONObject(i).getString("first_name")
//                                );
//                    } catch (Exception e) {
//                        error += e.getMessage();
//                    }
//                    //refreshErrorMessage();
//                    System.out.println(names.get(i));
//                }
//                System.out.println("done for loop");
//                //tutorAdapter.notifyDataSetChanged();
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
//                //refreshErrorMessage();
//            }
//        });
//    }

}
