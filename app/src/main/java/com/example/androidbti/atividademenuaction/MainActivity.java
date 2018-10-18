package com.example.androidbti.atividademenuaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
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
}
