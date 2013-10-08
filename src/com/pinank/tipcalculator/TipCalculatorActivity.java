package com.pinank.tipcalculator;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {
	private static final double PERCENT_10 = 0.1;
	private static final double PERCENT_15 = 0.15;
	private static final double PERCENT_20 = 0.2;
	private EditText etAmount;
	private Button btn10Percent;
	private Button btn15Percent;
	private Button btn20Percent; 
	private TextView tvTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        btn10Percent = (Button) findViewById(R.id.btn10Percent);
        btn15Percent = (Button) findViewById(R.id.btn15Percent);
        btn20Percent = (Button) findViewById(R.id.btn20Percent);
        tvTip = (TextView) findViewById(R.id.tvTip);
        etAmount = (EditText) findViewById(R.id.etAmount);
        etAmount.setHint("Enter amount");
        
        //setup Listeners..
        setUp10PercentButtonListener();
        setUp15PercentButtonListener();
        setUp20PercentButtonListener();
    }
    
    
    public void setUp10PercentButtonListener() {
    	btn10Percent.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				computeTip(PERCENT_10);
			}
		});
    }
    
    public void setUp15PercentButtonListener() {
    	btn15Percent.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				computeTip(PERCENT_15);
				
			}
		});
    }
    
    public void setUp20PercentButtonListener() {
    	btn20Percent.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				computeTip(PERCENT_20);
			}
		});
    }
    
    public void computeTip(double percent) {
    	String amount = etAmount.getText().toString();
    	double tip = 0;
    	try {
    		tip = Double.parseDouble(amount) * percent; 
    	} catch (NumberFormatException e) {
    		Toast.makeText(this, "Invalid Amount", Toast.LENGTH_SHORT).show();
    	}
    	String strTip = String.format(Locale.getDefault(), "Tip is : $%.2f", tip);
    	tvTip.setText(strTip);
    	return;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
    
}
