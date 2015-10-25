package me.krishnasudhakar.projects.finger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    Button btnReset;
    EditText txtIP;
    InetAddress i_IP = null;
    int c_Port = 26262;
    Socket fingering = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtIP =  (EditText) findViewById(R.id.eT_IP); //Finds the text field containing the IP

        btnReset = (Button)findViewById(R.id.btn_Reset); //Finds the button


        /* When the button is clicked */
        btnReset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                /* On click of the button, start the thread to send the message*/
               new Thread(new serverContact()).start();

            }
        });
    }

    class serverContact implements Runnable{

        @Override
        public void run() {

            try {

                // Get the IP from the text field
                String c_IP = String.valueOf(txtIP.getText());
                i_IP = InetAddress.getByName(c_IP);

                //Make socket with what we just got
                fingering = new Socket(i_IP,c_Port);

                //Send anything. It is not what is being sent, but that something is being sent
                OutputStream t_os = fingering.getOutputStream();
                PrintWriter out_wt = new PrintWriter(fingering.getOutputStream(),true);
                out_wt.println("S");

                //close the socket
                fingering.close();

                //And now, a whole lot of exceptions to catch. God, I hate Java!!
            }catch(UnknownHostException e) {
                System.out.println("Unknown host");
            } catch(IOException e) {
                System.out.println("No I/O");
            }catch (Exception e){
                e.printStackTrace();
                Log.e("MYAPP", "exception", e);
            }
        }
    }
}


