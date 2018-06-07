package com.example.android.newsapp1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by egi-megi on 07.06.18.
 */

public class ArticleAdapter extends ArrayAdapter<Article> {


    public int mColorResourceId;

    public ArticleAdapter(Activity context, ArrayList < Article > articles) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, articles);
    }


    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }




        final Article currentArticle = getItem(position);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentArticle.getWebUrl()));
                getContext().startActivity(intent);
            }
        };
        listItemView.setOnClickListener(listener);


 //       DecimalFormat formatterMagnitude = new DecimalFormat("0.0");

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentArticle.getTitle());

        TextView sectionNameTextView = (TextView) listItemView.findViewById(R.id.section_name_text_view);
        sectionNameTextView.setText(currentArticle.getSectionName());

        int indeksT = currentArticle.getPublicationDate().indexOf("T");
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(currentArticle.getPublicationDate().substring(0, indeksT));



 //       dateTextView.setText(currentArticle.getPublicationDate().substring(0, indeksT));




        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
//        String outputMagnitude = formatterMagnitude.format(currentArticle.getMagnitude());
//        magnitudeView.setText(outputMagnitude);

//        // Set the proper background color on the magnitude circle.
//        // Fetch the background from the TextView, which is a GradientDrawable.
//        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
//
//        // Get the appropriate background color based on the current earthquake magnitude
//        int magnitudeColor = getMagnitudeColor(currentArticle.getMagnitude());
//
//        // Set the color on the magnitude circle
//        magnitudeCircle.setColor(magnitudeColor);



//        int indeksOfPlus2 = indeksOf + 2;
//        int indeksOfPlus3 = indeksOf + 3;
//        int lengthLocation = currentArticle.getLocation().length();
//
//        if (currentArticle.getLocation().contains("of")) {
//            // Find the TextView in the list_item.xml layout with the ID version_number
//            TextView locationDistanceTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
//            // Get the version number from the current AndroidFlavor object and
//            // set this text on the number TextView
//            locationDistanceTextView.setText(currentArticle.getLocation().substring(0, indeksOfPlus2));
//
//            // Find the TextView in the list_item.xml layout with the ID version_number
//            TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
//            // Get the version number from the current AndroidFlavor object and
//            // set this text on the number TextView
//            locationTextView.setText(currentArticle.getLocation().substring(indeksOfPlus3, lengthLocation));
//        } else {
//            // Find the TextView in the list_item.xml layout with the ID version_number
//            TextView locationDistanceTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
//            // Get the version number from the current AndroidFlavor object and
//            // set this text on the number TextView
//            locationDistanceTextView.setText("Near the");
//
//            // Find the TextView in the list_item.xml layout with the ID version_number
//            TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
//            // Get the version number from the current AndroidFlavor object and
//            // set this text on the number TextView
//            locationTextView.setText(currentArticle.getLocation());
//        }
//
//        // Create a new Date object from the time in milliseconds of the earthquake
//        Date dateObject = new Date(currentArticle.getTimeInMilliseconds());
//
//        // Find the TextView with view ID date
//        TextView dateView = (TextView) listItemView.findViewById(R.id.date_text_view);
//        // Get the image resource ID from the current AndroidFlavor object and
//        // set the image to iconView
//        // Format the date string (i.e. "Mar 3, 1984")
//        String formattedDate = formatDate(dateObject);
//        dateView.setText(formattedDate);
//
//        // Find the TextView with view ID date
//        TextView timeView = (TextView) listItemView.findViewById(R.id.time_text_view);
//        // Get the image resource ID from the current AndroidFlavor object and
//        // set the image to iconView
//        // Format the date string (i.e. "Mar 3, 1984")
//        String formattedTime = formatTime(dateObject);
//        timeView.setText(formattedTime);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

//    public int getMagnitudeColor(double currentMagnitudeColor) {
//        int output = (int) currentMagnitudeColor;
//        switch (output) {
//            case 0:
//            case 1:
//                mColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude1);
//                break;
//            case 2:
//                mColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude2);
//                break;
//            case 3:
//                mColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude3);
//                break;
//            case 4:
//                mColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude4);
//                break;
//            case 5:
//                mColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude5);
//                break;
//            case 6:
//                mColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude6);
//                break;
//            case 7:
//                mColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude7);
//                break;
//            case 8:
//                mColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude8);
//                break;
//            case 9:
//                mColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude9);
//                break;
//            default:
//                mColorResourceId = R.color.magnitude10plus;
//                break;
//        }
//        return mColorResourceId;
//    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
//    private String formatDate(Date dateObject) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
//        return dateFormat.format(dateObject);
//    }
//
//    /**
//     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
//     */
//    private String formatTime(Date dateObject) {
//        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
//        return timeFormat.format(dateObject);
//    }

}

