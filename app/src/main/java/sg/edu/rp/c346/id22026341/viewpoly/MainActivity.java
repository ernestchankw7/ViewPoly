package sg.edu.rp.c346.id22026341.viewpoly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView lvPoly;
    AsyncHttpClient client;
    ArrayAdapter<Poly> adapter;
    ArrayList<Poly> alPoly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvPoly = findViewById(R.id.ListViewPoly);
        client = new AsyncHttpClient();

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        ArrayList<Poly> alPoly = new ArrayList<Poly>();
        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=fdd36db3-3317-4790-8c27-8e58f7dd1a42",new JsonHttpResponseHandler()
        {
            int year;
            String type_of_study;
            int enrolment;
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
            {
                try
                {
                    JSONObject jsonArrResult = response.getJSONObject("result");
                    JSONArray jsonArrYear =jsonArrResult.getJSONArray("records");
                    for(int i = 0; i < jsonArrYear.length(); i++)
                    {
                        JSONObject jsonObjYear =jsonArrYear.getJSONObject(i);
                        year =jsonObjYear.getInt("year");
                        type_of_study = jsonObjYear.getString("type_of_study");
                        enrolment = jsonObjYear.getInt("enrolment");
                        Poly poly = new Poly(year, type_of_study, enrolment);
                        alPoly.add(poly);
                    }
                    //adapter.notifyDataSetChanged();
                }
                catch(JSONException e){
                }
                adapter =new ArrayAdapter<Poly>(MainActivity.this, android.R.layout.simple_list_item_1, alPoly);
                lvPoly.setAdapter(adapter);
            }
        });
    }
}