//package com.fashionlabs.silkprediction;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import com.google.android.gms.auth.api.identity.BeginSignInRequest;
//import com.google.android.gms.auth.api.identity.Identity;
//import com.google.android.gms.auth.api.identity.SignInClient;
//import com.google.android.gms.auth.api.identity.SignInCredential;
//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.auth.api.signin.GoogleSignInClient;
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.common.api.ApiException;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthCredential;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.GoogleAuthProvider;
//
//public class loginPage extends AppCompatActivity {
//
//    private static final int REQ_ONE_TAP = 772;
//    private static final String TAG = "Login Page";
//    private SignInClient oneTapClient;
//    private BeginSignInRequest signInRequest;
//    private Context context;
//    private FirebaseAuth mAuth;
//    private GoogleSignInClient mGoogleSignInClient;
//    private GoogleSignInOptions gso;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login_page);
//        context = getApplicationContext();
//        com.google.android.gms.common.SignInButton signBtn = findViewById(R.id.button);
//        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//        mAuth = FirebaseAuth.getInstance();
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//        signBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("Inside On click");
////                signInRequest = BeginSignInRequest.builder()
////                        .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
////                                .setSupported(true)
////                                // Your server's client ID, not your Android client ID.
////                                .setServerClientId(getString(R.string.default_web_client_id))
////                                // Only show accounts previously used to sign in.
////                                .setFilterByAuthorizedAccounts(true)
////                                .build())
////                        .build();
//                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
////                oneTapClient = Identity.getSignInClient(context);
//                startActivityForResult(signInIntent, REQ_ONE_TAP);
//                System.out.println("exiting On click");
//            }
//        });
//    }
//
//
////        FirebaseAuth auth = FirebaseAuth.getInstance();
////        if(auth.getCurrentUser()!=null)
////        {
////            Intent i = new Intent(context,HomePage.class);
////            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////            i.addFlags(Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS);
////            startActivity(i);
////        }
////        signInRequest = BeginSignInRequest.builder()
////                .setPasswordRequestOptions(BeginSignInRequest.PasswordRequestOptions.builder()
////                        .setSupported(true)
////                        .build())
////                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
////                        .setSupported(true)
////                        // Your server's client ID, not your Android client ID.
////                        .setServerClientId(getString(R.string.default_web_client_id))
////                        // Only show accounts previously used to sign in.
////                        .setFilterByAuthorizedAccounts(true)
////                        .build())
////                .setAutoSelectEnabled(true)
////                .build();
//@Override
//protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//    super.onActivityResult(requestCode, resultCode, data);
//    // Check condition
//    System.out.println("inside activity result");
//    if(requestCode==REQ_ONE_TAP)
//    {
//        // When request code is equal to 100
//        // Initialize task
//        System.out.println("inside if result");
//        Task<GoogleSignInAccount> signInAccountTask=GoogleSignIn.getSignedInAccountFromIntent(data);
//
//        // check condition
//        if(signInAccountTask.isSuccessful())
//        {
//            // When google sign in successful
//            // Initialize string
//            System.out.println("inside second if result");
//            String s="Google sign in successful";
//            // Display Toast
////            displayToast(s);
//            // Initialize sign in account
//            try {
//                // Initialize sign in account
//                System.out.println("inside try  result");
//                GoogleSignInAccount googleSignInAccount=signInAccountTask
//                        .getResult(ApiException.class);
//                // Check condition
//                if(googleSignInAccount!=null)
//                {
//                    // When sign in account is not equal to null
//                    // Initialize auth credential
//                    System.out.println("inside try if result");
//                    AuthCredential authCredential= GoogleAuthProvider
//                            .getCredential(googleSignInAccount.getIdToken()
//                                    ,null);
//                    // Check credential
//                    mAuth.signInWithCredential(authCredential)
//                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    // Check condition
//                                    if(task.isSuccessful())
//                                    {
//                                        // When task is successful
//                                        System.out.println("succes");
//                                    }
//                                    else
//                                    {
//                                        // When task is unsuccessful
//                                        System.out.println("fail");
//
//                                    }
//                                }
//                            });
//
//                }
//            }
//            catch (ApiException e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//
//    private void firebaseAuthWithGoogle(String idToken) {
//        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithCredential:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            Intent home = new Intent(context,HomePage.class);
//                            home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                            startActivity(home);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithCredential:failure", task.getException());
//                        }
//                    }
//                });
//    }
//
//}

/**
 * Copyright 2021 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fashionlabs.silkprediction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

/**
 * Demonstrate Firebase Authentication using a Google ID Token.
 */
public class loginPage extends AppCompatActivity {

    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // [END config_signin]
        com.google.android.gms.common.SignInButton signBtn = findViewById(R.id.button);
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Inside On click");
                signIn();
                System.out.println("exiting On click");
            }
        });
        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]
    }

    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    // [END on_start_check_user]

    // [START onactivityresult]
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            updateUI(null);
                        }
                    }
                });
    }
    // [END auth_with_google]

    // [START signin]
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
    // [END signin]

    private void updateUI(FirebaseUser user) {
        if (user!= null){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
        }
    }
}