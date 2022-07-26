package com.slfortuner.navigationdrawerpos2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class ProductFragment extends Fragment {

    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       context = getActivity();

        return inflater.inflate( R.layout.fragment_products, container, false );
    }

    public void onStart(){

        super.onStart();
        Button btn = (Button) context.findViewById(R.id.product_btn  );
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductListActivity.class);
                startActivity( intent );
            }
        } );

    }


}


