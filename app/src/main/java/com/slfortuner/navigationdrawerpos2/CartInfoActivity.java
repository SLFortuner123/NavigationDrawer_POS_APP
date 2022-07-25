package com.slfortuner.navigationdrawerpos2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CartInfoActivity extends AppCompatActivity {

    private ListView productListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cart_info );
        initWidgets();
        loadFromDBTomMemory();
        setProductAdapter();
        setOnClickListener();

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar6 );
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        productListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = productListView.getAdapter().getItem( i ).toString();
                Intent intent = new Intent(getApplicationContext(),CartAddItems.class);
                intent.putExtra( "name", name );
                startActivity( intent );

            }
        } );

    }


    private void loadFromDBTomMemory(){

        SQLManager sqlManager = SQLManager.instanceOfDatabase( this );
        sqlManager.populateProductListArray();
    }

    private void setProductAdapter()
    {
        ProductAdapter productAdapter = new ProductAdapter( getApplicationContext(), Products.nonDeletedProducts());
        productListView.setAdapter( productAdapter );
    }

    private void setOnClickListener() {

        productListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Products selectedProducts = (Products) productListView.getItemAtPosition( position );
                Intent addProductIntent = new Intent(getApplicationContext(), CartAddItems.class);
                startActivity( addProductIntent );
            }
        } );

    }



    private void initWidgets()
    {
        productListView = findViewById( R.id.listViewProducts2 );
    }

    public void newProduct(View view) {

        Intent newProductIntent = new Intent(this, EditProductsActivity.class);
        startActivity( newProductIntent );

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setProductAdapter();
    }
}

