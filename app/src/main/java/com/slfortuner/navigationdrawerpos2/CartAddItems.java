package com.slfortuner.navigationdrawerpos2;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CartAddItems extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public Uri mCurrentCartUri;
    ImageButton plusQuantity, minusQuantity;
    Button addToCart;
    TextView quantityNum, itemTotalPrice, testRun;
    int quantity;
    boolean hasAllRequiredValues;
    private Products selectedProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cart_add_items );

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar2 );
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );


        plusQuantity = findViewById( R.id.addquantity );
        minusQuantity = findViewById( R.id.subquantity );
        addToCart = findViewById( R.id.addItemToCart );
        quantityNum = findViewById( R.id.quantity );
        itemTotalPrice = findViewById( R.id.itemTotalPrice );

        testRun = findViewById( R.id.testrun );
        testRun.setText( getIntent().getExtras().getString( "name" ) );


        addToCart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CartAddItems.this, Summary.class);
                startActivity( intent );

            }
        } );


        plusQuantity.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int basePrice = 5;
                quantity++;
                displayQuantity();
                int itemPrice = basePrice * quantity;
                String setnewPrice = String.valueOf( itemPrice );
                itemTotalPrice.setText( setnewPrice );

            }
        } );


        minusQuantity.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int basePrice = 5;
                if (quantity == 0) {
//// make a toast if u wanted
                }else{
                    quantity--;
                    displayQuantity();
                    int itemPrice = basePrice * quantity;
                    String setnewPrice = String.valueOf( itemPrice );
                    itemTotalPrice.setText( setnewPrice );
                }
            }
        } );


    }

    private void displayQuantity() {

        quantityNum.setText(String.valueOf( quantity ));

    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }


}