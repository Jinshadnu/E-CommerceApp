package com.example.e_commerceapp.activity.user.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.activity.user.pojo.Order;
import com.example.e_commerceapp.bottomNavigation.adapter.CartAdapter;
import com.example.e_commerceapp.databinding.LayoutCartBinding;
import com.example.e_commerceapp.databinding.LayoutMyorderBinding;

import java.util.List;

import static android.view.LayoutInflater.from;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
public Context context;
public List<Order> orderList;

    public OrderAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutMyorderBinding myorderBinding= DataBindingUtil.inflate(from(context), R.layout.layout_myorder,parent,false);
        return  new OrderAdapter.OrderViewHolder(myorderBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
     Order order=orderList.get(position);
     holder.myorderBinding.setOrders(order);
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        public LayoutMyorderBinding myorderBinding;
        public OrderViewHolder(@NonNull LayoutMyorderBinding myorderBinding) {
            super(myorderBinding.getRoot());
            this.myorderBinding=myorderBinding;

        }
    }
}
