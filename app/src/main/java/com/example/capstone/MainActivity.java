package com.example.capstone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.capstone.fragments.AboutFragment;
import com.example.capstone.fragments.FavoriteFragment;
import com.example.capstone.fragments.ListFragment;
import com.example.capstone.fragments.ProfileFragment;
import com.example.capstone.fragments.SettingsFragment;
import com.example.capstone.utils.AppSession;
import com.example.capstone.utils.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import Pojos.LoginResponse;
import Pojos.ProfileModel;
import de.hdodenhof.circleimageview.CircleImageView;
import ratofit.RestService;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    // declaring variables
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle menuButton;
    NavigationView navigationView;

    AppSession session;
    CircleImageView imgHeaderDP;
    TextView tvHeaderName;

    ImageView imgMenu;
    ImageView notifyBell;
    TextView notificationCount;

    Spinner spinnerLang;
    TextView tvHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        init();

//firebase
        if (getIntent().getExtras() != null) {

            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);


                Log.e("TAG----", "Key: " + key + " Value: " + value);
            }
        }


        // setting up the layout in frame
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ListFragment()).commit();
        }
    }


    // initializing views and variables
    private void init(){
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        imgMenu = findViewById(R.id.imgMenu);

        spinnerLang = findViewById(R.id.spnLng);

        tvHeading = findViewById(R.id.tvHeading);
        tvHeading.setText("Comics");

      //  notifyBell = findViewById(R.id.notifiBell);
       // notificationCount = findViewById(R.id.notificationCountText);



        menuButton = new ActionBarDrawerToggle(this,drawerLayout,R.string.close,R.string.open);
        drawerLayout.addDrawerListener(menuButton);
        menuButton.syncState();

     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setNavigateDrawer();
       // database = new DBHelper(this);
        session = AppSession.getInstance(this);

        View hView = navigationView.getHeaderView(0);

        tvHeaderName = (TextView) hView.findViewById(R.id.tv_name_header);
        imgHeaderDP = hView.findViewById(R.id.imgDP);
        tvHeaderName.setText(session.getStringData(Constants.NAME));

        // setting the image and name value from app session
        String previouslyEncodedImage = session.getStringData(Constants.IMAGE);
        if( !previouslyEncodedImage.equalsIgnoreCase("NA") ){
            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            imgHeaderDP.setImageBitmap(bitmap);
        } else {
            imgHeaderDP.setImageResource(R.drawable.user_img1);
        }





        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
Log.e("Fetching FCM ---- ","Fetching FCM registration token failed");
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        String msg =  token;
                        Log.e("====== ", msg);
                  //      Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });




        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        registerReceiver(receiver, new IntentFilter("alertmessage"));







        // spinner lang
        // Fetching string array of sizes from string resource and setting it to adapter
      //  ArrayAdapter<CharSequence> adapterSize = ArrayAdapter.createFromResource(this,R.array.lang_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
      //  adapterSize.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        // Setting adapter to spinner
      //  spinnerLang.setAdapter(adapterSize);

        //Set the text color of the Spinner's selected view (not a drop down list view)
        spinnerLang.setSelection(0, true);
        View v = spinnerLang.getSelectedView();
        ((TextView)v).setTextColor(Color.WHITE);

        // spinner handling
        spinnerLang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                //Change the selected item's text color
                ((TextView) view).setTextColor(Color.WHITE);

                // fetching and setting the name of current selected item to dataClass variable
                String pizzaQuantity = spinnerLang.getSelectedItem().toString();

              //  quantity = Integer.parseInt(pizzaQuantity);

              // int amount = price * quantity;
              //  btnOrder.setText("Place Order - "+ symbol + amount);
             //   finalPrice = amount;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




       // getAllComics();
        getProfile();
    }














    // opening fragments on click of  navigation view item click listeners
    private void setNavigateDrawer(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment frag = null;
                int itemId = item.getItemId();
                if(itemId == R.id.nav_menu){
                    frag = new ListFragment();
                    //spinnerLang.setVisibility(View.VISIBLE);
                    tvHeading.setText("Comics");

                }
               /* else if(itemId == R.id.nav_myorders){
                   // frag = new ListOrdersFragment();
                }*/
                else if(itemId == R.id.nav_Profile){
                    frag = new ProfileFragment();
                    spinnerLang.setVisibility(View.GONE);
                    tvHeading.setText("Profile");

                }


                else if(itemId == R.id.nav_Favourite){
                    frag = new FavoriteFragment();
                    spinnerLang.setVisibility(View.GONE);
                    tvHeading.setText("Favourites");

                }


                else if(itemId == R.id.nav_Settings){
                    frag = new SettingsFragment();
                    spinnerLang.setVisibility(View.GONE);
                    tvHeading.setText("Settings");

                }




                else if(itemId == R.id.nav_Aboutus){
                    frag = new AboutFragment();
                    spinnerLang.setVisibility(View.GONE);
                    tvHeading.setText("About Us");

                }
                else if(itemId == R.id.nav_logout){
                    showLogoutDialog();
                }

                if(frag!=null){
                    FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
                    fragTrans.replace(R.id.frameLayout,frag);
                    fragTrans.commit();
                    drawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (menuButton.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void showLogoutDialog(){

        new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.alert))
                .setMessage(getResources().getString(R.string.logout))

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        session.storeBoolenData(Constants.ISLOGIN,false);
                        Intent intent = new Intent(MainActivity.this,SplashActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(R.drawable.ic_logout)
                .show();
    }



    private void showNotificationDialog(String title, String message){

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                      dialog.dismiss();
                        //  session.storeBoolenData(Constants.ISLOGIN,false);
                       // Intent intent = new Intent(MainActivity.this,SplashActivity.class);
                      //  startActivity(intent);
                       // finish();
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                //.setNegativeButton(android.R.string.no, null)
                .setIcon(R.drawable.ic_notification)
                .show();
    }








    @Override
    protected void onResume() {
        super.onResume();
        goNotifiedText();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    void goNotifiedText() {

        int cout = session.getIntdata(Constants.NOTIFICATION);
        if (cout <= 0) {
//            notificationCount.setVisibility(View.GONE);
        } else {


          //  notificationCount.setText(String.valueOf(cout));
           // notificationCount.setVisibility(View.VISIBLE);
        }
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle getIn = intent.getExtras();
            String i = getIn.getString("MN");
            String ii = getIn.getString("TI");

            showNotificationDialog(ii,i);
            //goNotifiedText();

        }
    };







    private void getProfile(){

        RestService service = GlobalApp.getRestService();

        service.getProfile(new Callback<ProfileModel>() {
            @Override
            public void success(ProfileModel loginResponse, Response response) {
                //  openAnotherActivity(MainActivity.class);
            }

            @Override
            public void failure(RetrofitError error) {
                //showError(error.getMessage(),error.getMessage());
            }
        });
    }


}