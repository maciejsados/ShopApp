package maciej.example.com.storeapplication.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import maciej.example.com.storeapplication.R;


public class ProductMainViewAdapter extends RecyclerView.Adapter<ProductMainViewHolder> {

    private final Context context;
    private final List<ProductMain> products;
    private final LayoutInflater layoutInflater;



    public ProductMainViewAdapter(Context context, List<ProductMain> products) {
        this.context = context;
        this.products = products;
        layoutInflater = LayoutInflater.from(context);
    }




    @Override
    public ProductMainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.main_activity_recyler_item, parent, false);
        return new ProductMainViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ProductMainViewHolder holder, int position) {
        ProductMain productMain = this.products.get(position);



        if(position == 0) {
            holder.productImage.setImageResource(R.drawable.fruits);
        } else {
            holder.productImage.setImageResource(R.drawable.vegetables);

        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
