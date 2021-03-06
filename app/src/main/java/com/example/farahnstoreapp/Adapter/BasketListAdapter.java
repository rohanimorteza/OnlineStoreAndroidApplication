package com.example.farahnstoreapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farahnstoreapp.Detail_of_product;
import com.example.farahnstoreapp.Model.Product;
import com.example.farahnstoreapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BasketListAdapter extends RecyclerView.Adapter<BasketListAdapter.ProctListViewHolder> {

    private Context context;
    private List<Product> productList;

    public BasketListAdapter(Context context, List<Product> productList){
        this.context = context;

        this.productList = productList;
    }

    @NonNull
    @Override
    public ProctListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_product_in_basket,parent,false);

        return new ProctListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProctListViewHolder holder, final int position) {

        holder.title.setText(productList.get(position).getName());
        Picasso.with(context).load(productList.get(position).getIcon()).into(holder.ax);
        holder.price.setText("فی : "+productList.get(position).getPrice()+" تومان ");
        holder.qty.setText("تعداد : "+productList.get(position).getQty()+"");
        holder.value.setText("مبلغ : "+(Integer.parseInt(productList.get(position).getQty())*Integer.parseInt(productList.get(position).getPrice())));
        holder.crd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, Detail_of_product.class);
                i.putExtra("ID",productList.get(position).getId());
                i.putExtra("NAME",productList.get(position).getName());
                i.putExtra("PRICE",productList.get(position).getPrice());
                i.putExtra("ICON",productList.get(position).getIcon());

                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public  class ProctListViewHolder extends RecyclerView.ViewHolder{


        ImageView ax;
        TextView title,price,qty,value;
        CardView crd;

        public ProctListViewHolder(View itemView) {
            super(itemView);

            ax = itemView.findViewById(R.id.img_list_product);
            title = itemView.findViewById(R.id.txt_name_list_product);
            price = itemView.findViewById(R.id.txt_fi_list_product);
            qty = itemView.findViewById(R.id.txt_qty_list_product);
            value = itemView.findViewById(R.id.txt_value_list_product);
            crd = itemView.findViewById(R.id.crd_list_product);

        }
    }
}
