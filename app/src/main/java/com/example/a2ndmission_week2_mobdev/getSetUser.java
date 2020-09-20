package com.example.a2ndmission_week2_mobdev;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import com.example.a2ndmission_week2_mobdev.itemAdapter;

public class getSetUser {
    public static ArrayList<User> items = new ArrayList<>();

    public static final Dialog loadingDialog(Context context){
        final Dialog dialog = new Dialog(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.loading_screen, null);
        dialog.setContentView(dialogView);
        dialog.setCancelable(false);
        return dialog;
    }
}
