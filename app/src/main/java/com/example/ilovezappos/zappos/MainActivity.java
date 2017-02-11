package com.example.ilovezappos.zappos;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ilovezappos.zappos.Utils.NetworksUtil;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText mSearchBoxEditText;
    private TextView mUrlDisplayTextView;
    private TextView mSearchResultsTextView;
    String mSearchResults;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mSearchBoxEditText=(EditText)findViewById(R.id.search);
                mUrlDisplayTextView = (TextView) findViewById(R.id.textView);
                mSearchResultsTextView = (TextView) findViewById(R.id.textView2);
                makeGithubSearchQuery();
                //mSearchResults="[{\"brandName\":\"Nike Kids\",\"thumbnailImageUrl\":\"http://www.zappos.com/images/z/3/3/6/8/1/6/3368163-t-THUMBNAIL.jpg\",\"productId\":\"8621444\",\"originalPrice\":\"$45.00\",\"styleId\":\"3368163\",\"colorId\":\"584413\",\"price\":\"$45.00\",\"percentOff\":\"0%\",\"productUrl\":\"http://www.zappos.com/product/8621444/color/584413\",\"productName\":\"Flex Fury 2 (Infant/Toddler)\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http://www.zappos.com/images/z/3/7/5/0/1/6/3750161-t-THUMBNAIL.jpg\",\"productId\":\"8716119\",\"originalPrice\":\"$75.00\",\"styleId\":\"3750161\",\"colorId\":\"654015\",\"price\":\"$75.00\",\"percentOff\":\"0%\",\"productUrl\":\"http://www.zappos.com/product/8716119/color/654015\",\"productName\":\"Magista Onda II IC\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http://www.zappos.com/images/z/3/7/7/5/0/6/3775069-t-THUMBNAIL.jpg\",\"productId\":\"8799451\",\"originalPrice\":\"$45.00\",\"styleId\":\"3775069\",\"colorId\":\"353550\",\"price\":\"$36.00\",\"percentOff\":\"19%\",\"productUrl\":\"http://www.zappos.com/product/8799451/color/353550\",\"productName\":\"Zonal Cooling Relay Short Sleeve Running Top\"},{\"brandName\":\"Nike Kids\",\"thumbnailImageUrl\":\"http://www.zappos.com/images/z/3/7/7/6/7/8/3776783-t-THUMBNAIL.jpg\",\"productId\":\"8710571\",\"originalPrice\":\"$60.00\",\"styleId\":\"3776783\",\"colorId\":\"654000\",\"price\":\"$60.00\",\"percentOff\":\"0%\",\"productUrl\":\"http://www.zappos.com/product/8710571/color/654000\",\"productName\":\"JR Mercurial Vapor XI FG Soccer (Toddler/Little Kid/Big Kid)\"},{\"brandName\":\"Nike Golf\",\"thumbnailImageUrl\":\"http://www.zappos.com/images/z/3/4/6/0/7/7/3460775-t-THUMBNAIL.jpg\",\"productId\":\"8659673\",\"originalPrice\":\"$60.00\",\"styleId\":\"3460775\",\"colorId\":\"31878\",\"price\":\"$60.00\",\"percentOff\":\"0%\",\"productUrl\":\"http://www.zappos.com/product/8659673/color/31878\",\"productName\":\"Victory Stripe Polo\"},{\"brandName\":\"Nike Golf\",\"thumbnailImageUrl\":\"http://www.zappos.com/images/z/3/4/6/0/7/7/3460776-t-THUMBNAIL.jpg\",\"productId\":\"8659673\",\"originalPrice\":\"$60.00\",\"styleId\":\"3460776\",\"colorId\":\"287880\",\"price\":\"$60.00\",\"percentOff\":\"0%\",\"productUrl\":\"http://www.zappos.com/product/8659673/color/287880\",\"productName\":\"Victory Stripe Polo\"},{\"brandName\":\"Nike Golf\",\"thumbnailImageUrl\":\"http://www.zappos.com/images/z/3/4/6/1/8/5/3461851-t-THUMBNAIL.jpg\",\"productId\":\"8660189\",\"originalPrice\":\"$65.00\",\"styleId\":\"3461851\",\"colorId\":\"608450\",\"price\":\"$65.00\",\"percentOff\":\"0%\",\"productUrl\":\"http://www.zappos.com/product/8660189/color/608450\",\"productName\":\"Victory Texture Polo\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http://www.zappos.com/images/z/3/7/3/1/2/4/3731242-t-THUMBNAIL.jpg\",\"productId\":\"8756842\",\"originalPrice\":\"$90.00\",\"styleId\":\"3731242\",\"colorId\":\"651785\",\"price\":\"$90.00\",\"percentOff\":\"0%\",\"productUrl\":\"http://www.zappos.com/product/8756842/color/651785\",\"productName\":\"Air Max Motion Low Print\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http://www.zappos.com/images/z/3/7/2/9/6/2/3729621-t-THUMBNAIL.jpg\",\"productId\":\"8709414\",\"originalPrice\":\"$85.00\",\"styleId\":\"3729621\",\"colorId\":\"651522\",\"price\":\"$85.00\",\"percentOff\":\"0%\",\"productUrl\":\"http://www.zappos.com/product/8709414/color/651522\",\"productName\":\"Recreation Mid Prem\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http://www.zappos.com/images/z/3/7/2/9/5/5/3729552-t-THUMBNAIL.jpg\",\"productId\":\"8754877\",\"originalPrice\":\"$90.00\",\"styleId\":\"3729552\",\"colorId\":\"651510\",\"price\":\"$90.00\",\"percentOff\":\"0%\",\"productUrl\":\"http://www.zappos.com/product/8754877/color/651510\",\"productName\":\"Air Max Motion Low SE\"}]";

                intent=new Intent(view.getContext(), Search_Results.class);
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



    ////////////////////////////////////////

    private void makeGithubSearchQuery() {
        String githubQuery = mSearchBoxEditText.getText().toString();
        URL githubSearchUrl = NetworksUtil.buildUrl(githubQuery);
        mUrlDisplayTextView.setText(githubSearchUrl.toString());
        // COMPLETED (4) Create a new GithubQueryTask and call its execute method, passing in the url to query
        new GithubQueryTask().execute(githubSearchUrl);
    }

    public class GithubQueryTask extends AsyncTask<URL, Void, String> {

        // COMPLETED (2) Override the doInBackground method to perform the query. Return the results. (Hint: You've already written the code to perform the query)
        @Override
        protected String doInBackground(URL... params) {
            URL searchUrl = params[0];
            String githubSearchResults = null;
            try {
                githubSearchResults = NetworksUtil.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return githubSearchResults;
        }

        // COMPLETED (3) Override onPostExecute to display the results in the TextView
        @Override
        protected void onPostExecute(String githubSearchResults) {
            if (githubSearchResults != null && !githubSearchResults.equals("")) {
//                jm=new JsonManager();
//                productList=jm.getProducts(githubSearchResults);
//                mSearchResultsTextView.setText(githubSearchResults);
                    mSearchResults=githubSearchResults;
                intent.putExtra("result",mSearchResults);
                startActivity(intent);
            }
        }
    }
}
/////////////////////////
