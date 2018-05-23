package com.example.student_grade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity{
	//MyIntentService service;
	Boolean isBind;
	TextView txt;
	Intent intent;
	//Intent intent;	
	Spinner  sex,age,address,famsize,Mother_Edu,Father_Edu,Mjob,Fjob,guardian,traveltime,studytime,schoolsup,famsup,activities,higher,internet,romantic;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		isBind=false;
		intent = new Intent(this,SecondActivity.class);		
		sex=(Spinner)findViewById(R.id.ssex);
		age=(Spinner)findViewById(R.id.sage); 
		address=(Spinner)findViewById(R.id.saddress);
		famsize=(Spinner)findViewById(R.id.sfamSize);
		Mother_Edu=(Spinner)findViewById(R.id.smotheredu);
		Father_Edu=(Spinner)findViewById(R.id.sfatheredu);
		Mjob=(Spinner)findViewById(R.id.Smotherjob);
		Fjob=(Spinner)findViewById(R.id.Sfatherjob);
		guardian=(Spinner)findViewById(R.id.Sguardian);
		traveltime=(Spinner)findViewById(R.id.Strav);
		studytime=(Spinner)findViewById(R.id.Sstudy);
		schoolsup=(Spinner)findViewById(R.id.Sschoolsup);
		famsup=(Spinner)findViewById(R.id.Sfamilysup);
		activities=(Spinner)findViewById(R.id.Sactiv);
		higher=(Spinner)findViewById(R.id.Shigh);
		internet=(Spinner)findViewById(R.id.Sinter);
		romantic=(Spinner)findViewById(R.id.Sromant);
        
	}
	public void OnClick(View v) throws FileNotFoundException {
		//if (!isBind) {			
			//bindService(intent, this, Context.BIND_AUTO_CREATE);
			//isBind=true;
		//}
		
		int []input=new int[17];	
		String []send=new String[17];	
		send[0]= sex.getSelectedItem().toString();
		send[1]=age.getSelectedItem().toString();
		send[2]=address.getSelectedItem().toString();
		send[3]=famsize.getSelectedItem().toString();
		send[4]=Mother_Edu.getSelectedItem().toString();
		send[5]=Father_Edu.getSelectedItem().toString();
		send[6]=Mjob.getSelectedItem().toString();
		send[7]=Fjob.getSelectedItem().toString();
		send[8]=guardian.getSelectedItem().toString();
		send[9]=traveltime.getSelectedItem().toString();
		send[10]=studytime.getSelectedItem().toString();
		send[11]=schoolsup.getSelectedItem().toString();
		send[12]=famsup.getSelectedItem().toString();
		send[13]=activities.getSelectedItem().toString();
		send[14]=higher.getSelectedItem().toString();
		send[15]=internet.getSelectedItem().toString();
		send[16]=romantic.getSelectedItem().toString();
		////
		input[0]= sex.getSelectedItemPosition();
		input[1]=Integer.parseInt(age.getSelectedItem().toString());
		input[2]=address.getSelectedItemPosition();
		input[3]=famsize.getSelectedItemPosition();
		input[4]=Mother_Edu.getSelectedItemPosition();
		input[5]=Father_Edu.getSelectedItemPosition();
		input[6]=Mjob.getSelectedItemPosition()+1;
		input[7]=Fjob.getSelectedItemPosition()+1;
		input[8]=guardian.getSelectedItemPosition()+1;
		input[9]=traveltime.getSelectedItemPosition()+1;
		input[10]=studytime.getSelectedItemPosition()+1;
		input[11]=schoolsup.getSelectedItemPosition();
		input[12]=famsup.getSelectedItemPosition();
		input[13]=activities.getSelectedItemPosition();
		input[14]=higher.getSelectedItemPosition();
		input[15]=internet.getSelectedItemPosition();
		input[16]=romantic.getSelectedItemPosition();
		
		String GPA="";
		//Toast.makeText(getApplicationContext(),(name(send)) , Toast.LENGTH_SHORT).show();
		//for (int i = 0; i < send.length; i++) {
			//txt.append(Integer.toString(send[i])+" ");}		
		try {
			GPA=name(input);
			setTitle(GPA);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		intent.putExtra("key", GPA);
		startActivity(intent);
		//setTitle(service.getOutput(send));
		//if(isBind){   Integer.toString(send[16])
			
	//	}
	}
	
	public String name(int [] input) throws IOException {
		String csvFile = "C:\\Users\\awais\\eclipse-workspace\\Android_Proj\\src\\com\\example\\android_proj\\record.csv";
        String line = "";
        String cvsSplitBy = ",";
        InputStream isa = getResources().openRawResource(R.raw.record);
        
        List<Double> distance = new ArrayList<Double>();
        List<Integer> numValues;
       // int []send=new int [] {1 ,17 ,0 ,1 ,4 ,4 ,5 ,1 ,1 ,1 ,1 ,0 ,0 ,1 ,0 ,1 ,0};
        List<Double> Grade = new ArrayList<Double>();
        //Scanner scanner = new Scanner(new File(csvFile));InputStreamReader is = new InputStreamReader(getAssets().open(csvFile))
        try (BufferedReader read=new BufferedReader(new InputStreamReader(isa))) {
        	int i=0;
        	read.toString();
        	//return scanner.toString();
        	//Scanner dataScanner = null;
            while ((line = read.readLine()) != null) {
                String[] data = line.split(",");
            	if(i==0) {i++;continue;}
            	numValues = new ArrayList<Integer>();
                // use comma as separator
                // col 0
            	Grade.add(Double.parseDouble(data[17]));               
                if (data[0].equals("M")) {numValues.add(0);}
                else {numValues.add(1);}
                // col 1
                numValues.add(Integer.parseInt(data[1]));
                // col 2
                if(data[2].equals("U")) {numValues.add(0);}
                else {numValues.add(1);}
                // col 3
                if(data[3].equals("LE3")) {numValues.add(0);}
                else {numValues.add(1);}
                // col 4
                numValues.add(Integer.parseInt(data[4]));
                // col 5
                numValues.add(Integer.parseInt(data[5]));
                // col 6
                if(data[6].equals("teacher")) {numValues.add(1);}
                else if (data[6].equals("health")){numValues.add(2);}
                else if (data[6].equals("services")){numValues.add(3);}
                else if (data[6].equals("at_home")){numValues.add(4);}
                else {numValues.add(5);}
                // col 7
                if(data[7].equals("teacher")) {numValues.add(1);}
                else if (data[7].equals("health")){numValues.add(2);}
                else if (data[7].equals("services")){numValues.add(3);}
                else if (data[7].equals("at_home")){numValues.add(4);}
                else {numValues.add(5);}
                // col 8
                if(data[8].equals("mother")) {numValues.add(1);}
                else if(data[8].equals("father")) {numValues.add(2);}
                else {numValues.add(3);}
                // col 9
                numValues.add(Integer.parseInt(data[9]));
                // col 10
                numValues.add(Integer.parseInt(data[10]));
                // col 11
                if(data[11].equals("yes")) {numValues.add(0);}
                else {numValues.add(1);}
                // col 12
                if(data[12].equals("yes")) {numValues.add(0);}
                else {numValues.add(1);}
                // col 13
                if(data[13].equals("yes")) {numValues.add(0);}
                else {numValues.add(1);}
                // col 14
                if(data[14].equals("yes")) {numValues.add(0);}
                else {numValues.add(1);}
                // col 15
                if(data[15].equals("yes")) {numValues.add(0);}
                else {numValues.add(1);}
                // col 16
                if(data[16].equals("yes")) {numValues.add(0);}
                else {numValues.add(1);} 
                Double sum=0.0;
                for (int j = 0; j < input.length; j++) {
					sum+=Math.pow((input[j]-numValues.get(j)), 2);
				}
                sum = Math.sqrt(sum);
                distance.add(sum);  
    			}
        }
        catch (Exception e) {
            Log.e("awd", e.toString());
        }
        return  Double.toString(Grade.get(distance.indexOf(Collections.min(distance))));
	}
}
