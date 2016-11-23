package star.trytorij;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import layout.Account;
import layout.Home;
import layout.Train;


public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener{

    AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation= (AHBottomNavigation) findViewById(R.id.myBottomNavigation_ID);
        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();
    }

    private void createNavItems()
    {
        //CREATE ITEMS
        AHBottomNavigationItem crimeItem=new AHBottomNavigationItem("Home",R.drawable.ic_favorites);
        AHBottomNavigationItem dramaItem=new AHBottomNavigationItem("Train",R.drawable.ic_nearby);
        AHBottomNavigationItem docstem=new AHBottomNavigationItem("Account",R.drawable.ic_friends);

        //ADD THEM to bar
        bottomNavigation.addItem(crimeItem);
        bottomNavigation.addItem(dramaItem);
        bottomNavigation.addItem(docstem);

        //set properties
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        //set current item
        bottomNavigation.setCurrentItem(0);

    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        //show fragment
        if (position==0)
        {
            Home home=new Home();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,home).commit();
        }else  if (position==1)
        {
            Train train=new Train();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,train).commit();
        }else  if (position==2)
        {
            Account account=new Account();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,account).commit();
        }
    }
}

