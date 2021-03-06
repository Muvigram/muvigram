package com.estsoft.muvigram.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.estsoft.muvigram.R;
import com.estsoft.muvigram.ui.base.activity.BaseActivity;
import com.estsoft.muvigram.ui.base.activity.BasePlainActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JEONGYI on 2016. 10. 14..
 */

public class EditProfileActivity extends BasePlainActivity {

    @BindView(R.id.profile_image) ImageView profileImage;
    @BindView(R.id.userid_edittext) EditText userIdEditText;
    @BindView(R.id.username_eidttext) EditText userNameEditText;
    @BindView(R.id.userbio_edittext) EditText userBioEditText;
    @BindView(R.id.back_button) ImageButton backButton;
    @BindView(R.id.save_button) ImageButton saveButton;

    @OnClick(R.id.back_button) void clickBack(){
        finish();
    }

    @OnClick(R.id.save_button) void clickSave(){
        Intent intent = this.getIntent();
        intent.putExtra("userId",""+userIdEditText.getText());
        intent.putExtra("userName",""+userNameEditText.getText());
        intent.putExtra("userBio",""+userBioEditText.getText());
        this.setResult(RESULT_OK,intent);

        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);

        String userId = getIntent().getStringExtra("userId");
        String bio = getIntent().getStringExtra("userBio");
        String userName = getIntent().getStringExtra("userName");
        String userProfileImage = getIntent().getStringExtra("userProfileImage");

        //프라이머리키로 객체 찾아서 아이디 바이오 set 해주기!

        Picasso.with(this)
                .load(userProfileImage)
                .transform(new CircleTransform()).into(profileImage);
        userIdEditText.setText(userId);
        userBioEditText.setText(bio);
        userNameEditText.setText(userName);

    }

}
