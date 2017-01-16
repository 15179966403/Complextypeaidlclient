package com.hrc.administrator.complextypeaidlclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hrc.administrator.complextypeaidl.IMyService;

public class MainActivity extends Activity implements View.OnClickListener{
    private IMyService myService=null;
    private TextView textview;
    private Button btnInvokeAIDLService,btnBindAIDLService;
    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService=IMyService.Stub.asInterface(service);
            btnInvokeAIDLService.setEnabled(true);
            Log.d("ss","服务被调用");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=(TextView)findViewById(R.id.textview);
        btnInvokeAIDLService=(Button)findViewById(R.id.btnInvokeAIDLService);
        btnBindAIDLService=(Button)findViewById(R.id.btnBindAIDLService);
        btnInvokeAIDLService.setEnabled(false);
        btnInvokeAIDLService.setOnClickListener(this);
        btnBindAIDLService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInvokeAIDLService:
                try{
                    String s="";
                    s="Product.id="+myService.getProduct().getId()+"\n";
                    s+="Product.name="+myService.getProduct().getName()+"\n";
                    s+="Product.price="+myService.getProduct().getPrice()+"\n";
                    s+=myService.getMap("China",myService.getProduct()).toString();
                    textview.setText(s);
                }catch (Exception e){
                }
                break;
            case R.id.btnBindAIDLService:
                Log.d("ss","按钮被点击");
                Intent intent=new Intent();
                intent.setAction("com.hrc.administartor.complextypeaidl.aidl.IMyService");
                intent.setPackage("com.hrc.administrator.complextypeaidl");
                bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
                break;
        }
    }
}
