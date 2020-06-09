package com.example.onecharger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private EditText etxtstairheight;
    private TextView txtstairdisplay;
    private TextView txtmiddlenode;
    private TextView txtnums1;
    private TextView txtnums2;
    private TextView txtmedian;
    private int stairheight=0;
    private String nums;
    private ArrayList<Integer> linkedlist = new ArrayList<>();
    private ArrayList<Double> nums1 = new ArrayList<>();
    private ArrayList<Double> nums2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        etxtstairheight = (EditText) findViewById(R.id.stairheight);
        etxtstairheight.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId== EditorInfo.IME_ACTION_DONE )   )
                {
                    hideKeyboard();
                    buildstair();
                    return true;
                }
                return false;
            }
        });

        txtstairdisplay = (TextView)findViewById(R.id.txtstairdisplay);
        txtmiddlenode = (TextView)findViewById(R.id.txtmiddlenode);
        txtnums1 = (TextView)findViewById(R.id.txtnums1);
        txtnums2 = (TextView)findViewById(R.id.txtnums2);
        txtmedian = (TextView)findViewById(R.id.txtmedian);

    }


    public void selectarray(View v){
        switch (v.getId()) {
            case (R.id.txtnums1):
                txtnums1.setText("nums1 :");
                nums1.clear();
                nums = "nums1";
                break;
            case (R.id.txtnums2):
                txtnums2.setText("nums2 :");
                nums2.clear();
                nums = "nums2";
                break;
        }
    }
    public void numberSelect(View v){
            switch (v.getId()) {
                case (R.id.btn0):
                    linkedlist.add(0);
                    break;
                case (R.id.btn1):
                    linkedlist.add(1);
                    break;
                case (R.id.btn2):
                    linkedlist.add(2);
                    break;
                case (R.id.btn3):
                    linkedlist.add(3);
                    break;
                case (R.id.btn4):
                    linkedlist.add(4);
                    break;
                case (R.id.btn5):
                    linkedlist.add(5);
                    break;
                case (R.id.btn6):
                    linkedlist.add(6);
                    break;
                case (R.id.btn7):
                    linkedlist.add(7);
                    break;
                case (R.id.btn8):
                    linkedlist.add(8);
                    break;
                case (R.id.btn9):
                    linkedlist.add(9);
                    break;
            }
    }
    public void arrayinput(View v){
        if(nums==null || nums.equals("")){
            Toast.makeText(getApplicationContext(),"select nums1 or nums2",Toast.LENGTH_SHORT).show();
            return;
        }
        if(nums.equals("nums1")){
            switch (v.getId()) {
                case (R.id.arrin0):
                    nums1(0.0);
                    break;
                case (R.id.arrin1):
                    nums1(1.0);
                    break;
                case (R.id.arrin2):
                    nums1(2.0);
                    break;
                case (R.id.arrin3):
                    nums1(3.0);
                    break;
                case (R.id.arrin4):
                    nums1(4.0);
                    break;
                case (R.id.arrin5):
                    nums1(5.0);
                    break;
                case (R.id.arrin6):
                    nums1(6.0);
                    break;
                case (R.id.arrin7):
                    nums1(7.0);
                    break;
                case (R.id.arrin8):
                    nums1(8.0);
                    break;
                case (R.id.arrin9):
                    nums1(9.0);
                    break;
            }   
        }else {
            switch (v.getId()) {
                case (R.id.arrin0):
                    nums2(0.0);
                    break; 
                case (R.id.arrin1):
                    nums2(1.0);
                    break; 
                case (R.id.arrin2):
                    nums2(2.0);
                    break; 
                case (R.id.arrin3):
                    nums2(3.0);
                    break;
                case (R.id.arrin4):
                    nums2(4.0);
                    break; 
                case (R.id.arrin5):
                    nums2(5.0);
                    break; 
                case (R.id.arrin6):
                    nums2(6.0);
                    break;
                case (R.id.arrin7):
                    nums2(7.0);
                    break;
                case (R.id.arrin8):
                    nums2(8.0);
                    break;
                case (R.id.arrin9):
                    nums2(9.0);
                    break;
            }
        }
    }

    private void nums1(Double a){
        txtnums1.setText(txtnums1.getText().toString()+" "+new DecimalFormat("#").format(a));
        nums1.add(a);
    }
    
    private void nums2(Double a){
        txtnums2.setText(txtnums2.getText().toString()+" " +new DecimalFormat("#").format(a));
        nums2.add(a);
    }

    public void showmedian(View v){
        if(nums1==null || nums2==null){
            Toast.makeText(getApplicationContext(),"inter both nums1 and nums2",Toast.LENGTH_SHORT).show();
        }
        int item = 0;
        double median = 0.0;
        ArrayList<Double> newarray = new ArrayList<>();
        newarray.addAll(nums1);
        newarray.addAll(nums2);
        Collections.sort(newarray);

        if(newarray.size() % 2 == 0){
            item = (newarray.size())/2;
             median = (newarray.get(item-1)+newarray.get(item))/2;
            txtmedian.setText("the median is " + median);

        }else{
            item = (newarray.size()+1)/2;
            median = newarray.get(item-1);
            txtmedian.setText("the median is " + new DecimalFormat("#").format(median));
        }


    }

    public void showmiddlenode(View v){
        txtmiddlenode.setText("");
        String middletext = "Middle node of [";
        int middlevalue =0;
        if(linkedlist.size() < 2){
            Toast.makeText(getApplicationContext(),"enter more than one number",Toast.LENGTH_SHORT).show();
            return;
        }
        if(linkedlist.size() % 2 == 0){
            middlevalue = linkedlist.size()/2 +1;
        }else{
            middlevalue = (linkedlist.size()+1)/2;
        }
        for (int index = 0 ; index <linkedlist.size() ;index++){
            middletext = middletext+linkedlist.get(index)+" ";
        }
        middletext = middletext+"] is ";
        txtmiddlenode.setText(middletext+linkedlist.get(middlevalue-1)+"");
        linkedlist.clear();
    }
    public void displaystair(View v){
        hideKeyboard();
        buildstair();
    }
    private void buildstair(){
        if(etxtstairheight.getText().toString().equals("") || etxtstairheight.getText().toString()==null ){
            Toast.makeText(getApplicationContext(),"please enter any number",Toast.LENGTH_SHORT).show();
        }
        try {
            stairheight = Integer.parseInt(etxtstairheight.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"please enter just number",Toast.LENGTH_SHORT).show();
        }
        String stair ="";
        if(stairheight==0){
            Toast.makeText(getApplicationContext(),"please enter just number",Toast.LENGTH_SHORT).show();
        }
        for(int index = 1; index < stairheight+1;index++){
            for (int j = 0; j<index;j++){
                stair = stair+"#";
            }
            stair = stair+"\n";
        }
        txtstairdisplay.setText(stair);
    }
    private void hideKeyboard(){
        try  {
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {

        }
    }

}
