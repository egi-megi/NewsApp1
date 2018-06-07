package com.example.android.newsapp1;

/**
 * Created by egi-megi on 07.06.18.
 */

public class Article {

    // Name of the Android version (e.g. Gingerbread, Honeycomb, Ice Cream Sandwich)
    private String mTitle;

    // Android version number (e.g. 2.3-2.7, 3.0-3.2.6, 4.0-4.0.4)
    private String mSectionName;

    // Drawable resource ID
    private String mPublicationDate;

    private String mWebUrl;

    /*
    * Create a new AndroidFlavor object.
    *
    * @param vName is the name of the Android version (e.g. Gingerbread)
    * @param vNumber is the corresponding Android version number (e.g. 2.3-2.7)
    * @param image is drawable reference ID that corresponds to the Android version
    * */
    public Article(String title, String sectionName, String publicationDate, String webUrl)
    {
        mTitle = title;
        mSectionName = sectionName;
        mPublicationDate = publicationDate;
        mWebUrl = webUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getPublicationDate() {
        return mPublicationDate;
    }

    public String getWebUrl() {
        return mWebUrl;
    }
}

