package com.example.androidbti.atividademenuaction;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ItemFragment extends ListFragment implements View.OnLongClickListener, ActionMode.Callback {

    ArrayAdapter<Item> adapterItens;
    private onItemCLick listener;

    private boolean isActionModeActive;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(!(context instanceof onItemCLick)){
            throw new RuntimeException("Não é instancia de OnItemClick");
        }
        listener = (onItemCLick) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapterItens = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);

        setListAdapter(adapterItens);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Item item = adapterItens.getItem(position);
        if(listener != null){
            listener.onClick(item);
        }
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.itens_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getItemId() == R.id.action_edit){
            Toast.makeText(getContext(), "Editar", Toast.LENGTH_SHORT).show();
            mode.finish();
        } else if (item.getItemId() == R.id.action_delete){
            Toast.makeText(getContext(), "Excluir", Toast.LENGTH_SHORT).show();
            mode.finish();
        }
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        isActionModeActive = false;

    }

    @Override
    public boolean onLongClick(View v) {
        if(!isActionModeActive){
            startActionMode(this);
            isActionModeActive = true;
        }
        return true;
    }

    public interface onItemCLick{
        void onClick(Item item);
    }
}
