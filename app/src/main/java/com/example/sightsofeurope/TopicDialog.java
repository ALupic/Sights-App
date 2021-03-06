package com.example.sightsofeurope;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.example.sightsofeurope.MainActivity.MyPREFERENCES;

public class TopicDialog extends DialogFragment {

    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    NoticeDialogListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (NoticeDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            e.printStackTrace();
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        Bundle bundle = getArguments();
        final View v = inflater.inflate(R.layout.dialog_addtopic, null);
        final int sightId = bundle.getInt("sight_id");

        builder.setView(v)
                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("Positive button");
                        EditText content = v.findViewById(R.id.editTextFirst);
                        EditText comment = v.findViewById(R.id.editTextSecond);

                        SharedPreferences sharedPreferences = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                        //String username = sharedPreferences.getString("username","");
                        DatabaseHelper db = new DatabaseHelper(getContext());

                        String pattern = "dd/MM/yyyy HH:mm";
                        DateFormat df = new SimpleDateFormat(pattern);
                        Date today = Calendar.getInstance().getTime();
                        String todayAsString = df.format(today);

                        Topic newTopic = new Topic(1, content.getText().toString(), "unun", sightId);
                        System.out.println("/////////////// THE VALUE IS: " + content.getText().toString());
                        System.out.println("/////////////// SIGHT ID IS: " + sightId);

                        db.addTopic(newTopic);

                        System.out.println("/////////////// NEW TOPIC ID IS: " + newTopic.getId());
                        Comment newComment = new Comment(1, comment.getText().toString(), "unun", todayAsString, newTopic.getId());
                        db.addComment(newComment);

                        //listener.onDialogPositiveClick(TopicDialog.this);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("Negative button");
                    }
                });
        return builder.create();
    }
}
