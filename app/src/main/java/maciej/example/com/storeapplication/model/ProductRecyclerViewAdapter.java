package maciej.example.com.storeapplication.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import maciej.example.com.storeapplication.R;



public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductListViewHolder> {

    private final Context context;
    private final List<Product> products;
    private final LayoutInflater layoutInflater;

    public ProductRecyclerViewAdapter(Context context, List<Product> news) {
        this.context = context;
        this.products = news;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ProductListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_product_item, parent, false);
        return new ProductListViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ProductListViewHolder holder, int position) {
        Product product = this.products.get(position);


        holder.productsName.setText(product.getName());
        holder.productQuantity.setText(product.getQuantity());
        holder.productPrice.setText(product.getPrice());
        holder.kgQuantity.setText(product.getPiece());



        if(position == 0) {
            holder.productPhoto.setImageResource(R.drawable.banana);
        } else if (position == 1) {
            holder.productPhoto.setImageResource(R.drawable.orange);
        } else if (position == 2) {
            holder.productPhoto.setImageResource(R.drawable.apple);
        } else if (position == 3){
            holder.productPhoto.setImageResource(R.drawable.strawberries);
        } else if (position == 4) {
            holder.productPhoto.setImageResource(R.drawable.plums);
        } else if (position == 5) {
            holder.productPhoto.setImageResource(R.drawable.pears);
        } else if (position == 6) {
            holder.productPhoto.setImageResource(R.drawable.avocado);
        } else if (position == 7){
            holder.productPhoto.setImageResource(R.drawable.raspberries);
        } else if (position == 9) {
            holder.productPhoto.setImageResource(R.drawable.watermelon);
        } else {
            holder.productPhoto.setImageResource(R.drawable.pineapple);
        }

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
