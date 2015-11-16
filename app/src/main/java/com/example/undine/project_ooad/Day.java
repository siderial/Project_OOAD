package com.example.undine.project_ooad;

<<<<<<< HEAD
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
=======
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

>>>>>>> origin/v6.1
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
<<<<<<< HEAD
=======

>>>>>>> origin/v6.1
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
<<<<<<< HEAD
=======

>>>>>>> origin/v6.1
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Administrator on 6/11/2558.
 */
public class Day extends AppCompatActivity {

    Toolbar toolbar;
    public static final String URL = "http://203.151.92.175:8080/";
    private ListView mListView;
    private CustomAdapterActivity mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extra = getIntent().getExtras();
        String forBackend = extra.getString("DATE");
        Toast.makeText(this,forBackend,Toast.LENGTH_LONG).show();
        mListView = (ListView) findViewById(R.id.listView);
<<<<<<< HEAD

=======
>>>>>>> origin/v6.1
        new SimpleTask().execute(URL + "getPinOneDay?accountID=776&date=" + forBackend);



    }

    private class SimpleTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            // Create Show ProgressBar
        }

        protected String doInBackground(String... urls) {
            String result = "";
            IOException ee;
            Exception ex;
            try {

                HttpGet httpGet = new HttpGet(urls[0]);
                HttpClient client = new DefaultHttpClient();

                HttpResponse response = client.execute(httpGet);

                int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode == 200) {
                    InputStream inputStream = response.getEntity().getContent();
                    BufferedReader reader = new BufferedReader
                            (new InputStreamReader(inputStream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result += line;
                    }
                }

            } catch (ClientProtocolException e) {

            } catch (IOException e) {
                ee=e;
            }catch (Exception e){
                ex=e;
            }
            return result;
        }

        protected void onPostExecute(String jsonString) {
            // Dismiss ProgressBar
            try {
                showData(jsonString);
            }catch (Exception e){

            }

        }
    }

    private void showData(String jsonString) {
        Gson gson = new Gson();
<<<<<<< HEAD

=======
        //Blog blog = gson.fromJson(jsonString, Blog.class);
        //Map map = gson.fromJson(jsonString, Map.class);
>>>>>>> origin/v6.1
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(jsonString).getAsJsonArray();
        ArrayList<Event> events = new ArrayList<Event>();

        for (JsonElement obj : jArray){
            Event event = gson.fromJson(obj,Event.class);
            events.add(event);
        }

<<<<<<< HEAD

        mAdapter = new CustomAdapterActivity(this, events);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = mListView.getItemAtPosition(position);
                System.out.println(listItem);

                Intent intent = new Intent(Day.this, DetailActivity.class);
                Event en = (Event) listItem;
                intent.putExtra("EVENT_TITLE", en.getNameTitle());
                intent.putExtra("EVENT_DATE", en.getStartDate());
                intent.putExtra("EVENT_LOCATE", en.getLocation());
                intent.putExtra("EVENT_DES", en.getDescription());
                intent.putExtra("EVENT_RATE", en.getRate());
                intent.putExtra("TOPIC_ID", en.getTopicID());
                intent.putExtra("START_TIME", en.getStartTime());
                System.out.println(en.getDescription());
                startActivity(intent);
            }
        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(Day.this);
                builder.setMessage("Delete Pin?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(),
                                "แปะ URL ตรงเน้", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", null);
                builder.create();

                // สุดท้ายอย่าลืม show() ด้วย
                builder.show();

                return true;
            }
        });
    }
}
=======
        //StringBuilder builder = new StringBuilder();
        //builder.setLength(0);
        //List<Post> posts = blog.getPosts();
        //List<Event> events = map.getEvents();

        /*for (Event event : events) {
            builder.append(event.getDescription());
            builder.append("\n");
            builder.append(event.getLocation());
            builder.append("\n\n");
        }*/

        //mAdapter = new CustomAdapter(this, posts);
        //mListView.setAdapter(mAdapter);
        //Toast.makeText(this, jsonString, Toast.LENGTH_LONG).show();
        //Toast.makeText(this, builder.toString(), Toast.LENGTH_LONG).show();
        /*
        try {
            JSONArray array = new JSONArray(jsonString);
            JSONObject title = array.getJSONObject(0);

            String ss= title.getString("nameTitle");
            Log.v("AAAAAAAAAA", ss);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        mAdapter = new CustomAdapterActivity(this, events);
        mListView.setAdapter(mAdapter);
    }
}
>>>>>>> origin/v6.1
