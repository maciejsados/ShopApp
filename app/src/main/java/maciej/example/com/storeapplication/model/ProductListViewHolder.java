package maciej.example.com.storeapplication.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import maciej.example.com.storeapplication.R;
import maciej.example.com.storeapplication.activity.SecondActivity;


public class ProductListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View root;

    public ImageView productPhoto;
    public TextView productsName;
    public TextView productPrice;
    public TextView productQuantity;
    public View imageView;
    public View imageVIew2;
    public TextView kgQuantity;


    int count = 0;


    public ProductListViewHolder(View view, final Context context) {
        super(view);
        root = view;


        this.productsName = (TextView) view.findViewById(R.id.from_name);
        this.productQuantity = (TextView) view.findViewById(R.id.cart_product_quantity);
        this.productPrice = (TextView) view.findViewById(R.id.plist_price_text);
        this.imageView = view.findViewById(R.id.cart_plus_img);
        this.imageVIew2 = view.findViewById(R.id.cart_minus_img);
        this.productPhoto = (ImageView) view.findViewById(R.id.list_image);
        this.kgQuantity = (TextView) view.findViewById(R.id.kgPiece);


        root.setOnClickListener(new View.OnClickListener() {
            public static final String EXTRA = "key";
            public static final String EXTRA1 = "key1";
            public static final String EXTRA2 = "key2";
            public final String EXTRAINT = "byteArray";


            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, SecondActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra(EXTRA, productsName.getText().toString());
                intent.putExtra(EXTRA1, productPrice.getText().toString());
                intent.putExtra(EXTRA2, productQuantity.getText().toString());
                productPhoto.buildDrawingCache();

                Bitmap image = productPhoto.getDrawingCache();
                Bundle extras = new Bundle();
                extras.putParcelable(EXTRAINT, image);
                intent.putExtras(extras);

                context.startActivity(intent);
//
            }
        });


        imageView.setOnClickListener(this);
        imageVIew2.setOnClickListener(this);
    }





    @Override
    public void onClick(View view) {
        if (view.getId() == imageView.getId()) {
            count++;
            productQuantity.setText(String.valueOf(count));

        } else if (view.getId() == imageVIew2.getId()) {
            if (count == 0) {
                return;
            }
            count--;

            productQuantity.setText(String.valueOf(count));

        }


    }


}
