package com.example.android.newsapp1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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

    public ArticleAdapter(Activity context, ArrayList < Article > articles) {
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

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentArticle.getTitle());


        TextView sectionNameTextView = (TextView) listItemView.findViewById(R.id.section_name_text_view);
        sectionNameTextView.setText(currentArticle.getSectionName());

        View textContainer = listItemView.findViewById(R.id.single_list_item);
        if (position%2 == 0){
            textContainer.setBackgroundColor(getContext().getResources().getColor( R.color.even));
        } else {
            textContainer.setBackgroundColor(getContext().getResources().getColor( R.color.odd));
        }


        int indexT = currentArticle.getPublicationDate().indexOf("T");
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(currentArticle.getPublicationDate().substring(0, indexT));

        TextView authorsTextView = (TextView) listItemView.findViewById(R.id.author_text_view);
        authorsTextView.setText(currentArticle.getAuthors());

        return listItemView;
    }


}

