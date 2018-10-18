package com.example.androidbti.atividademenuaction;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItemFragment extends ListFragment {

    ArrayAdapter<Item> adapterItens;
    private onItemCLick listener;

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

    public interface onItemCLick{
        void onClick(Item item);
    }
}
