package maciej.example.com.storeapplication.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import maciej.example.com.storeapplication.activity.FruitsActivity;
import maciej.example.com.storeapplication.R;
import maciej.example.com.storeapplication.activity.VegetablesActivity;



public class ProductMainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    View root;
    public ImageView productImage;



    public ProductMainViewHolder(View itemView, final Context context) {
        super(itemView);
        root = itemView;
        this.productImage = (ImageView) itemView.findViewById(R.id.main_recycler_photo);

   root.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           ProductMain productMain = (ProductMain) view.getTag();
           int position = getAdapterPosition();
           if(position == 0) {
               Intent i = new Intent(context, FruitsActivity.class);
               context.startActivity(i);
           } else {
               Intent i1 = new Intent(context, VegetablesActivity.class);
               context.startActivity(i1);
           }
       }
   });
    }

    @Override
    public void onClick(View view) {

    }


}
