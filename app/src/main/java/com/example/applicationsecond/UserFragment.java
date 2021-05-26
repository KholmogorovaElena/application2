package com.example.applicationsecond;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class UserFragment extends Fragment {
private User user;
private int position;
@Override
 public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
  //position = getActivity().getIntent().getIntExtra("position", 1);
 position = getArguments().getInt("position");
 user = Users.get(getActivity()).getUserList().get(position);
}
 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
 View view = inflater.inflate(R.layout.fragment_user, viewGroup, false);
 Button redBtn = view.findViewById(R.id.redBtn);
 Button deleteBtn = view.findViewById(R.id.deleteBtn);
 TextView userInfo = view.findViewById(R.id.userInfo);
 Button backBtn = view.findViewById(R.id.backBtn);
 String text = "Имя:  " + user.getUserName() + "\n"+"\n"+ "Фамилия:  " + user.getUserLastName() + "\n"+"\n"+  "Телефон:  "+ user.getPhone();
 userInfo.setText(text);
 redBtn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

 Intent intent = new Intent(getActivity(), RedactorUserActivity.class);
 intent.putExtra("position", position);

   startActivity(intent);
       }
    });
   deleteBtn.setOnClickListener(new View.OnClickListener() {
  @Override
public void onClick(View v) {
      Users.get(getContext()).deleteUser(user.getUuid().toString());
     Intent intent = new Intent(getContext(), MainActivity.class);
          startActivity(intent);
                   }
 });

   backBtn.setOnClickListener(new View.OnClickListener() {@Override
 public void onClick(View v) {
Intent intent = new Intent(getContext(), MainActivity.class);
 startActivity(intent);
 }
    });
return view;
    }
 }
