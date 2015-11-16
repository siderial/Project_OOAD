package com.example.undine.project_ooad;

import android.annotation.TargetApi;
<<<<<<< HEAD
import android.content.DialogInterface;
=======
>>>>>>> origin/v6.1
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
<<<<<<< HEAD
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
=======
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
>>>>>>> origin/v6.1
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private ViewHolder mViewHolder;
    private String parameter="";
    private String method="";
<<<<<<< HEAD
=======
    private SimpleTask tk=new SimpleTask();
>>>>>>> origin/v6.1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        mListView = (ListView) findViewById(R.id.listView);


<<<<<<< HEAD
        final  String  title,
=======
       final  String  title,
>>>>>>> origin/v6.1
                date,
                location,
                startTime,
                description;
        double rate;
<<<<<<< HEAD
        final int topicID;
=======
       final int topicID;
>>>>>>> origin/v6.1
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                title= null;
                description= null;
                date = null;
                location = null;
                startTime=null;
                rate = 0;
                topicID = 0;
            } else {
                title = extras.getString("EVENT_TITLE");
                date = extras.getString("EVENT_DATE");
                description = extras.getString("EVENT_DES");
                location = extras.getString("EVENT_LOCATE");
                rate = extras.getDouble("EVENT_RATE");
                topicID = extras.getInt("TOPIC_ID");
                startTime = extras.getString("START_TIME");
<<<<<<< HEAD


=======
>>>>>>> origin/v6.1
            }
        } else {
            title= (String)savedInstanceState.getSerializable("EVENT_TITLE");
            description= (String) savedInstanceState.getSerializable("EVENT_DES");
            date= (String) savedInstanceState.getSerializable("EVENT_DATE");
            location = (String) savedInstanceState.getSerializable("EVENT_LOCATE");
            rate = (Double) savedInstanceState.getSerializable("EVENT_RATE");
            topicID = (Integer)savedInstanceState.getSerializable("TOPIC_ID");
            startTime = (String)savedInstanceState.getSerializable("START_TIME");
        }
        //Toast.makeText(getApplicationContext(),title+date+description+location+rate,Toast.LENGTH_SHORT).show();
        TextView textTitle = (TextView)findViewById(R.id.textTitle);
        TextView textDate = (TextView)findViewById(R.id.textDate);
        TextView textLocate = (TextView)findViewById(R.id.DesLocate);
        TextView textDes = (TextView)findViewById(R.id.DesDes);
        TextView textRate = (TextView)findViewById(R.id.textRate);
        RatingBar ratebar = (RatingBar)findViewById(R.id.ratingBar);
        textTitle.setText(title);
        textDate.setText(date);
        textLocate.setText(location);
        textDes.setText(description);
        textRate.setText(Double.toString(rate));
        ratebar.setRating((float) rate);
<<<<<<< HEAD
        Toast.makeText(this,""+topicID+"   "+startTime+"   "+date, Toast.LENGTH_LONG).show();
=======
       Toast.makeText(this,""+topicID+"   "+startTime+"   "+date, Toast.LENGTH_LONG).show();
>>>>>>> origin/v6.1

        //------------------Pin--------------------------------------------------------------------
        final Switch ib=(Switch)findViewById(R.id.switchPin);

        int i=111;
<<<<<<< HEAD
        // parameter="accountID=765&date=20151113&topicID="+topicID+"&time=23:27:00";
=======
       // parameter="accountID=765&date=20151113&topicID="+topicID+"&time=23:27:00";
>>>>>>> origin/v6.1
        ib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                method = "storePinup";
                parameter = "accountID=776&date=" + date.substring(0, 4) + date.substring(5, 7) + date.substring(8, 10) + "&topicID=" + topicID + "&time=" + startTime;
                new HttpTask().execute();
                // Toast.makeText(this,"topicID", Toast.LENGTH_LONG).show();
            }
        });
<<<<<<< HEAD


=======
>>>>>>> origin/v6.1
        //------------get comment---------------------------------------------------
        final Button cm=(Button) findViewById(R.id.buttoncomment);
        cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD

=======
>>>>>>> origin/v6.1
                EditText desc = (EditText) findViewById(R.id.editText2);
                parameter = "desc=" + desc.getText().toString() + "&accountID=776&topicID=" + topicID;
                method = "storeComment";
                new HttpTask().execute();
<<<<<<< HEAD
//                Intent intent2 = new Intent(DetailActivity.this, DetailActivity.class);
//                startActivity(intent2);
            }
        });

        new SimpleTask().execute(URL + "getCommentByTopicID?topicID=" + topicID);


    }
=======
                tk.execute(URL + "getCommentByTopicID?topicID=" + topicID);
                desc.setText("");
            }
        });
       new SimpleTask().execute(URL + "getCommentByTopicID?topicID=" + topicID);
   }
>>>>>>> origin/v6.1
    private static class ViewHolder{
        ImageView thumbnail;
        TextView title;
        TextView date;
        TextView location;
        TextView description;
        TextView rate;
    }

    //------------------------------------------Send Post-----------------------------------

    private final String USER_AGENT = "Mozilla/5.0";
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public  String sendPost1() throws Exception {

        // String urlParameters  = "title=Mikasa&startDate=20151102&location=NewYork&desc=HelloBob&type=private&rate=4.5&tag=HELLO";
        String urlParameters=parameter;
        byte[] postData = urlParameters.getBytes("UTF-8");
        int postDataLength = postData.length;
        URL url;
        HttpURLConnection urlConn;
        DataOutputStream printout;
        DataInputStream input;
        url = new URL("http://203.151.92.175:8080/"+method);
        urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setDoInput(true);
        urlConn.setDoOutput(true);
        urlConn.setUseCaches(false);
        urlConn.setInstanceFollowRedirects(false);
        urlConn.setRequestMethod("POST");
        urlConn.setRequestProperty("charset", "utf-8");
        urlConn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        urlConn.setRequestProperty("User-Agent", USER_AGENT);
        urlConn.connect();
        DataOutputStream wr = new DataOutputStream(urlConn.getOutputStream());
        wr.write(postData);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(urlConn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        urlConn.disconnect();
        return response.toString();

    }

    private class HttpTask extends AsyncTask<String, Integer, String> {

        protected String doInBackground(String... params)   {
            try {
                sendPost1();
                // postData();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "result";
        }

        protected void onProgressUpdate(Integer... values) {

        }

        protected void onPostExecute(String result)  {

        }
    }

    //-----------------------------------------Get Comment-----------------------------------


    public static final String URL = "http://203.151.92.175:8080/";
    private ListView mListView;
    private CommentAdapterFragment mAdapter;


    private class SimpleTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
<<<<<<< HEAD
            // Create Show ProgressBar
=======
>>>>>>> origin/v6.1
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
<<<<<<< HEAD
            // Dismiss ProgressBar
=======
>>>>>>> origin/v6.1
            showData(jsonString);
        }
    }

    private void showData(String jsonString) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(jsonString).getAsJsonArray();
        ArrayList<Comment> comments = new ArrayList<>();
        for (JsonElement obj : jArray){
            Comment comment = gson.fromJson(obj,Comment.class);
            comments.add(comment);
        }

        mAdapter = new CommentAdapterFragment(DetailActivity.this, comments);
        mListView.setAdapter(mAdapter);
<<<<<<< HEAD
=======
        mAdapter.notifyDataSetChanged();
>>>>>>> origin/v6.1


        //----------------------------set parameter layout-----------------------------------------
        int totalHeight = 0;
        for (int i = 0; i < mAdapter.getCount(); i++) {
            View listItem = mAdapter.getView(i, null, mListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
<<<<<<< HEAD

=======
>>>>>>> origin/v6.1
        ViewGroup.LayoutParams params = mListView.getLayoutParams();
        params.height = totalHeight + (mListView.getDividerHeight() * (mListView.getCount() - 1));
        mListView.setLayoutParams(params);
        mListView.requestLayout();
<<<<<<< HEAD
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(DetailActivity.this);
                builder.setMessage("Delete Comment?");
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
    }
}
>>>>>>> origin/v6.1
