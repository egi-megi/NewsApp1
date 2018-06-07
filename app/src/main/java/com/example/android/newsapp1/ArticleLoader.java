package com.example.android.newsapp1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by egi-megi on 07.06.18.
 */

public class ArticleLoader extends AsyncTaskLoader<List<Article>> {

    /** Tag for log messages */
    private static final String LOG_TAG = ArticleLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public ArticleLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Article> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        // Create URL object
        // Perform the HTTP request for earthquake data and process the response.
        List<Article> article = QueryUtilis.fetchArticleData(mUrl);
        // Update the information displayed to the user.
        return article;
    }
}
