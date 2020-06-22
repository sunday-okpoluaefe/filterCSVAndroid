package com.sunday.androidfliterchallenge.presentation

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.sunday.androidfliterchallenge.R
import com.sunday.androidfliterchallenge.data.entity.CarOwner
import com.sunday.androidfliterchallenge.presentation.core.BaseActivity
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception


class MainActivity : BaseActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        readCSV()

//        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun readCSV(){
        val inputStream = resources.openRawResource(R.raw.car_ownsers_data)

        val reader = BufferedReader(
            InputStreamReader(inputStream, Charsets.UTF_8)
        )

        Log.d(TAG, "readingCSV")

        //this is all the file in the csv as a string, you can just write this to external storage
        val allText = inputStream.bufferedReader().use(BufferedReader::readText)

        val split = allText.split("\n")

        //the first row is the heading, so I split that off
        val heading = split.first()

        val carOwners = mutableListOf<CarOwner>()
        for(data in split.subList(1, split.size)){
            val row = "$data".split(',')
            try{
                carOwners.add(CarOwner().apply {
                    firstName = row[1]
                    lastName  = row[2]
                    email  = row[3]
                    country  = row[4]
                    carModel  = row[5]
                    carModelYear  = row[6]
                    carColor  = row[7]
                    gender  = row[8]
                    jobTitle  = row[9]
                    bio   = row[10]
                })
            }catch (e: Exception){
                Log.d(TAG, "$data")
                Log.d(TAG, "error: ${e.localizedMessage}")
            }
        }

        Log.d(TAG, "doneWithCSV: ${carOwners.size}")

    }
}