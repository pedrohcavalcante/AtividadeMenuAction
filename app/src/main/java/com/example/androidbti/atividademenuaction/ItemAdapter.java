package com.example.androidbti.atividademenuaction;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> /*implements View.OnLongClickListener*/ {

    private List<Item> itemList = new ArrayList<>();
    private Context context;
    private boolean actionModeActive;

    public ItemAdapter(Context context){
        this.context = context;
        Item item = new Item();
        item.setNome("teste");
        itemList.add(item);
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        Item item = itemList.get(i);
        itemHolder.itemNome.setText(item.getNome());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

   /* @Override
    public boolean onLongClick(View v) {
        if(!actionModeActive){
            v.startActionMode(this);
            actionModeActive = true;
        }

        return true;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.action, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if(item.getItemId() == R.id.action_edit){
            Toast.makeText(context, "Editar", Toast.LENGTH_SHORT).show();
            mode.finish();
        } else if (item.getItemId() == R.id.action_delete){
            Toast.makeText(context, "deletar", Toast.LENGTH_SHORT).show();
            mode.finish();
        }
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }*/

    public class ItemHolder extends RecyclerView.ViewHolder implements  View.OnLongClickListener, ActionMode.Callback{
        public TextView itemNome;

        public ItemHolder(View itemView){
            super(itemView);
            itemNome = itemView.findViewById(android.R.id.text1);

            itemView.setOnLongClickListener(this);
        }

       /* @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            itemList.remove(pos);
            notifyItemRemoved(pos);
        }*/

        @Override
        public boolean onLongClick(View v) {

            int pos = getAdapterPosition();
            Toast.makeText(context, itemList.get(pos).getNome(), Toast.LENGTH_SHORT).show();
            v.setBackgroundColor(Color.BLUE);

            if(!actionModeActive){
                v.startActionMode(this);
                actionModeActive = true;
            }
            return true;
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.itens_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if(item.getItemId() == R.id.action_edit){
                Toast.makeText(context, "Editar", Toast.LENGTH_SHORT).show();
                mode.finish();
            } else if (item.getItemId() == R.id.action_delete){
                Toast.makeText(context, "deletar", Toast.LENGTH_SHORT).show();
                mode.finish();
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionModeActive = false;

        }
    }
}
