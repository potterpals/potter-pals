package edu.fsu.cs.cen4020.potterpals;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.gms.appinvite.AppInviteInvitation;

/**
 * Created by sap15e on 11/2/2017.
 */

public class Invite extends AppCompatActivity
{
    Button invite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.invite);
        //int REQUEST_INVITE =1;
        invite = (Button) findViewById(R.id.button3);

        invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new AppInviteInvitation
                        .IntentBuilder("Send Invitations for XYZ app")
                        // Ensure valid length for any message used before calling otherwise this will throw
                        // an IllegalArgumentException if greater than MAX_MESSAGE_LENGTH.
                        .setMessage("Try out Potter Pals!")
                        .setDeepLink(Uri.parse("https://www.facebook.com/"))
                        //.setDeepLink(Uri.parse("//xyz.com/offer/free_trial_campaign"))
                        .setCallToActionText("Find data").build();
                startActivityForResult(intent,1);
            }
        });









    }

}
