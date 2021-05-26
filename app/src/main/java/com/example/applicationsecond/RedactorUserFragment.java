package com.example.applicationsecond;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
public class RedactorUserFragment extends Fragment {
private User user;
private TextView textView;
private Button updateBtn;
private EditText nameText;
private EditText lastNameText;
private EditText phoneText;
private int position;

 @Override
public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
             position = getActivity().getIntent().getIntExtra("position", 1);
             user = Users.get(getActivity()).getUserList().get(position);
           }
 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_user_redactor, viewGroup, false);
       textView = view.findViewById(R.id.textViewUpdateForm);
       nameText = view.findViewById(R.id.editUpdateName);
       lastNameText = view.findViewById(R.id.editUpdateLastName);
       phoneText = view.findViewById(R.id.editUpdatePhone);
       updateBtn = view.findViewById(R.id.updateBtn);
       nameText.setText(user.getUserName());
       lastNameText.setText(user.getUserLastName());
       phoneText.setText(user.getPhone());
     updateBtn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

user.setUserName(nameText.getText().toString());
user.setUserLastName(lastNameText.getText().toString());
user.setPhone(phoneText.getText().toString());
Users.get(getContext()).redactorUser(user);
Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.putExtra("position", position);
           startActivity(intent);
      }
 });
          return view;
       }
 }
