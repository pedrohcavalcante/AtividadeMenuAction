package com.example.androidbti.atividademenuaction;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class EditDialogInput extends DialogFragment {


    private EditText editText;
    private OnTextListener listener;

    public static void show(FragmentManager fm, OnTextListener listener){

        EditDialogInput dialog = new EditDialogInput();
        dialog.listener = listener;
        dialog.show(fm, "textDialog");

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Item");

        builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (listener != null){
                    String text = editText.getText().toString();
                    listener.onAddItem(text);
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        View view = getActivity().getLayoutInflater().inflate(R.layout.alert_dialog_input, null);
        editText = view.findViewById(R.id.edt_text);
        builder.setView(view);
        return builder.create();

    }

    public interface OnTextListener{
        void onAddItem(String text);
    }
}
