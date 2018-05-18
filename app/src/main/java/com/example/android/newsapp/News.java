package com.example.android.newsapp;

public class News {
    /**
     * {@link News} represents a single Android platform release.
     * Each object has 3 properties: title, section, and date.
     */

    private String mTitle;

    private String mSection;

    private String mDate;

    String mUrl;

    /*
     * Create a new News object.
     *
     * @param vTitle is the title of the article
     * @param vSection is the section name
     * @param vDate is the date
     * */

    public News(String vTitle, String vSection, String vDate, String vUrl) {
        mDate = vDate;
        mTitle = vTitle;
        mSection = vSection;
        mUrl = vUrl;
    }

    /**
     * Get the magnitude
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the location
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Get the date
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Get the url
     */
    public String getUrl() {
        return mUrl;
    }
}


