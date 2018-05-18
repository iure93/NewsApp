package com.example.android.newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    /*
     * {@link NewsAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
     * based on a data source, which is a list of {@link News} objects.
     * */

    private static final String LOG_TAG = NewsAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param news    A List of Earthquake objects to display in a list
     */
    public NewsAdapter(Activity context, ArrayList<News> news) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, news);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }

        // Get the {@link News} object located at this position in the list
        News currentNews = getItem(position);

        // Find the TextView in the lis.xml layout with the title
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.titleNews);

        // set this text on the name TextView
        String title = currentNews.getTitle();
        titleTextView.setText(title);

        // Find the TextView in the list.xml with the section
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section);

        String section = currentNews.getSection();

        // set this text on the sectionTextView
        sectionTextView.setText(section);

        // find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String currentDate = currentNews.getDate();

        // edit the date string
        String[] parts = currentDate.split("T");
        String date = parts[0]; // "yyyy, MM, dd"

        // Display the date of the current news in that TextView
        dateView.setText(date);

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView

        return listItemView;
    }
}
