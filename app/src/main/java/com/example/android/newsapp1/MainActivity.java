package com.example.android.newsapp1;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Article>> {

    // Constant value for the article loader ID
    private static final int ARTICLE_LOADER_ID = 1;

    public static final String USGS_REQUEST_URL =
            "https://content.guardianapis.com/search?q=architecture&from-date=2017-01-01&api-key=test&show-tags=contributor";

    /**
     * Adapter for the list of articles
     */
    private ArticleAdapter mAdapter;

    public ImageView emptyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find a reference to the {@link ListView} in the layout
        ListView articleListView = (ListView) findViewById(R.id.list);

        // Find a reference to the Image View in empty page in the layout
        emptyPage = (ImageView) findViewById(R.id.empty_text_view);
        articleListView.setEmptyView(findViewById(R.id.empty_text_view));

        // Create a new {@link ArrayAdapter} of articles
        mAdapter = new ArticleAdapter(this, new ArrayList<Article>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        articleListView.setAdapter(mAdapter);


        articleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Find the current article that was clicked on
                Article currentArticle = mAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri articleUri = Uri.parse(currentArticle.getWebUrl());

                // Create a new intent to view the article URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, articleUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnected()) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader
            loaderManager.initLoader(ARTICLE_LOADER_ID, null, this);
        } else {
            View progressBar = findViewById(R.id.loading_progress_bar);
            progressBar.setVisibility(View.GONE);
            emptyPage.setImageResource(R.drawable.no_connection);

        }
    }


    @Override
    public Loader<List<Article>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new ArticleLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Article>> loader, List<Article> articles) {

        View progressBar = findViewById(R.id.loading_progress_bar);
        progressBar.setVisibility(View.GONE);

        emptyPage.setImageResource(R.drawable.no_article);
        // Clear the adapter of previous article
        mAdapter.clear();

        // If there is a valid list of {@link Article}s, then add them to the adapter's
        // articles set. This will trigger the ListView to update.
        if (articles != null && !articles.isEmpty()) {
            mAdapter.addAll(articles);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Article>> loader) {
        mAdapter.clear();
    }


}

