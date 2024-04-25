package com.example.collegeapp_exp8;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showAlertDialogButton = findViewById(R.id.showAlertDialogButton);
        showAlertDialogButton.setOnClickListener(v -> showAlertDialog());

        Button showPopupMenuButton = findViewById(R.id.showPopupMenuButton);
        showPopupMenuButton.setOnClickListener(v -> showPopupMenu(v));

        // Assuming you want to show an options menu through the action bar
        // No need to call showOptionsMenu programmatically

        Button showContextMenuButton = findViewById(R.id.showContextMenuButton);
        showContextMenuButton.setOnClickListener(v -> {
            // Register the view for context menu
            registerForContextMenu(v);
            // Open the context menu for the view
            openContextMenu(v);
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This is an alert dialog.")
                .setPositiveButton("OK", (dialog, id) -> {
                    // Handle OK button click
                })
                .setNegativeButton("Cancel", (dialog, id) -> {
                    // Handle Cancel button click
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            Toast.makeText(this, "You clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        });
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle options menu item selection
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle context menu item selection
        return super.onContextItemSelected(item);
    }
}
