package com.example.androidbti.atividademenuaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemFragment.onItemCLick{

    ItemFragment itemFragment;
    private boolean isActionModeActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        //itemFragment = (ItemFragment) getSupportFragmentManager().findFragmentById(R.id.my_fragment);

        RecyclerView recyclerView = findViewById(R.id.my_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        ItemAdapter itemAdapter = new ItemAdapter(this);
        recyclerView.setAdapter(itemAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAdd){
            EditDialogInput.show(getSupportFragmentManager(), new EditDialogInput.OnTextListener() {
                @Override
                public void onAddItem(String text) {
                    Toast.makeText(MainActivity.this, "oi " + text, Toast.LENGTH_SHORT).show();
                    // TODO fazer adicionar na list
                }
            });
            return true;
        } else {
            Toast.makeText(this, "Não foi possivel encontrar a opcao escolhida", Toast.LENGTH_SHORT).show();
            return super.onOptionsItemSelected(item);
        }
    }

    /*@Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.itens_menu, menu); // Com erro aqui
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getItemId() == R.id.action_edit){
            Toast.makeText(this, "Editar", Toast.LENGTH_SHORT).show();
            mode.finish();
        } else if (item.getItemId() == R.id.action_delete){
            Toast.makeText(this, "Excluir", Toast.LENGTH_SHORT).show();
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
            //startActionMode(this); // Com erro aqui
            isActionModeActive = true;
        }
        return true;
    }*/

    @Override
    public void onClick(Item item) {

    }
}
