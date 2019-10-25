package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static android.net.Uri.*;

public class InfoActivity extends AppCompatActivity {
    TextView textViewPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        textViewPhone = (TextView) findViewById(R.id.text_view_phone);

        Uri uri = parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    public void createMapIntent( View view){
        Uri uriAddress = parse( "geo:0,0?q=618 E South St Orlando, FL 32801" );
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uriAddress);
        mapIntent.setPackage("com.google.android.apps.maps");
        if(mapIntent.resolveActivity(getPackageManager()) != null){
            startActivity(mapIntent);
        }
    }


    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
    public void createPhoneItntent(View view) {
        Intent intentCall = new Intent(Intent.ACTION_DIAL);
        intentCall.setData(Uri.parse("tel:0123456789"));
        startActivity(intentCall);
    }

    public void createPhoneIntent( View view){


        Intent intentCall = new Intent(Intent.ACTION_DIAL);
        intentCall.setData(Uri.parse("tel:0123456789"));
        startActivity(intentCall);

    }

}
