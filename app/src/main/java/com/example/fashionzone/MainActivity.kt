package com.example.fashionzone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.nio.file.Files.size

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        replaceFrameWithFragment(Home())

        val bottom = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottom.menu.getItem(0).isCheckable = false
        bottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.Item1 -> {
                    replaceFrameWithFragment(Search())
                    it.isCheckable = true
                }
                R.id.Item2 -> {
                    replaceFrameWithFragment(Categor())
                    it.isCheckable = true
                }
                R.id.Item4 -> {
                    replaceFrameWithFragment(Cart())
                    it.isCheckable = true
                }
                R.id.Item5 -> {
                    replaceFrameWithFragment(Account())
                    it.isCheckable = true
                }
                else->{

                }
            }
            true
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            replaceFrameWithFragment(Home())
            for (i in 0 until bottom.menu.size()) {
                bottom.menu.getItem(i).isCheckable = false
            }
        }
    }

    private fun replaceFrameWithFragment(frag: Fragment) {

        val fragManager = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()
        fragTransaction.replace(R.id.frameLayout, frag)
        fragTransaction.commit()
    }


}