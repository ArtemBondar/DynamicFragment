package com.github.artembondar.dynamicfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.github.artembondar.dynamicfragment.fragment.FirstFragment;
import com.github.artembondar.dynamicfragment.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private CheckBox checkBox;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        checkBox = (CheckBox) findViewById(R.id.chbStack);
        fragmentManager = getSupportFragmentManager();

    }

    public void onClickFragment(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.btnAdd:
                if (fragmentManager.findFragmentByTag(FirstFragment.TAG) == null) {
                    fragmentTransaction.add(R.id.container, firstFragment, FirstFragment.TAG);
                }
                break;
            case R.id.btnRemove:
                if (fragmentManager.findFragmentByTag(FirstFragment.TAG) != null) {
                    fragmentTransaction.remove(firstFragment);
                }
                if (fragmentManager.findFragmentByTag(SecondFragment.TAG) != null) {
                    fragmentTransaction.remove(secondFragment);
                }
                break;
            case R.id.btnReplace:
                if (fragmentManager.findFragmentByTag(FirstFragment.TAG) != null) {
                    fragmentTransaction.replace(R.id.container, secondFragment, SecondFragment.TAG);
                }
                if (fragmentManager.findFragmentByTag(SecondFragment.TAG) != null) {
                    fragmentTransaction.replace(R.id.container, firstFragment, FirstFragment.TAG);
                }
                break;
            default:
                break;
        }

        if (checkBox.isChecked()) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
