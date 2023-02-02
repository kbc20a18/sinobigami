package com.example.sinobigami;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.input.InputManager;
import android.net.Uri;
import android.os.Bundle;

import android.os.ParcelFileDescriptor;
import android.text.method.ScrollingMovementMethod;

import android.util.Log;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;


import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {
    private DataBaseSave dataBaseSave;
    private ScrollView constraintLayout;
    InputMethodManager inputMethodManager;
    private static final int RESULT_PICK_IMAGEFILE = 1000;
    private ImageView imageView;
    private String url = "";
    private ArrayList<Integer> aaa = new ArrayList<>();
    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent resultData  = result.getData();
                    if (resultData  != null) {
                        openImage(resultData);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kyarashi);

        Realm.init(this);
        imageView = findViewById(R.id.imageView);
        Button Savebutton = findViewById(R.id.kyarashi_hozon);
        Savebutton.setOnClickListener(v -> {
            // 引数　要素　全指定
            EditText edit_kyara = (EditText) findViewById(R.id.editText_kyaraname);
            String name = edit_kyara.getText().toString();
            RadioGroup Radio_type = (RadioGroup) findViewById(R.id.radioGroup1);
            int type = Radio_type.getCheckedRadioButtonId();
            Spinner Spin_ryuha = (Spinner) findViewById(R.id.spinner_ryuha);
            int ryuha = Spin_ryuha.getSelectedItemPosition();
            EditText edit_ryuha = (EditText) findViewById(R.id.editText_kairyuha);
            String kairyuha = edit_ryuha.getText().toString();
            EditText edit_ryugi = (EditText) findViewById(R.id.edittext_ryugi);
            String ryugi = edit_ryugi.getText().toString();
            EditText edit_kyuteki = (EditText) findViewById(R.id.editText_kyuteki);
            String kyuteki = edit_kyuteki.getText().toString();
            Spinner spin_kaikyu = (Spinner) findViewById(R.id.spinner_kaikyu);
            int kaikyu = spin_kaikyu.getSelectedItemPosition();
            EditText edit_kouseki = (EditText) findViewById(R.id.editText_kouseki);
            int kouseki = Integer.parseInt(edit_kouseki.getText().toString());
            EditText edit_nenrei = (EditText) findViewById(R.id.editText_nenrei);
            int nenrei = Integer.parseInt(edit_nenrei.getText().toString());
            RadioGroup radio_seibetu = (RadioGroup) findViewById(R.id.radioGroup2);
            int seibetu = radio_seibetu.getCheckedRadioButtonId();
            EditText edit_job = (EditText) findViewById(R.id.editText_omotenokao);
            String job = edit_job.getText().toString();
            EditText edit_sinen = (EditText) findViewById(R.id.edittext_sinnen);
            String sinen = edit_sinen.toString().toString();
            EditText edit_setei = (EditText) findViewById(R.id.edittext_memo);
            String setei = edit_setei.getText().toString();

            dataBaseSave = new DataBaseSave();
//            dataBaseSave.save
//                    (name,url,type,ryuha,kairyuha,ryugi,kyuteki,kaikyu,kouseki,nenrei,seibetu,job,sinen,setei);
//            RadioGroupe.check();

        });
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        constraintLayout = findViewById(R.id.kyarashi_sv);
        // 画面遷移
        Button intentButton = findViewById(R.id.intent_button);
        intentButton.setOnClickListener(view -> {
            SubFragment sub_fragment = new SubFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.kyarashi_sv,sub_fragment);
            fragmentTransaction.commit();
        });

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");

            resultLauncher.launch(intent);
        });
        }
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        inputMethodManager.hideSoftInputFromWindow(constraintLayout.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        constraintLayout.requestFocus();
        return true;
    }

    void openImage(Intent resultData){
        ParcelFileDescriptor pfDescriptor = null;
        try{
            Uri uri = resultData.getData();
            // Uriを表示

            pfDescriptor = getContentResolver().openFileDescriptor(uri, "r");
            if(pfDescriptor != null){
                Log.i("uri",uri.toString());
                url = uri.toString();
                FileDescriptor fileDescriptor = pfDescriptor.getFileDescriptor();
                Bitmap bmp = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                pfDescriptor.close();
                imageView.setImageBitmap(bmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(pfDescriptor != null){
                    pfDescriptor.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    }
