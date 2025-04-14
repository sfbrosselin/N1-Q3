package br.com.example.questaotres.utils;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

import br.com.example.questaotres.ui.MainActivity;

public class VoltarFunc {
    public static void voltarFunction(Button button, Activity activity){
        button.setOnClickListener(view -> {
            Intent intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
            activity.finish();
        });
    }
}
