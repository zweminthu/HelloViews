package com.example.helloviews

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Switch
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHW.text = getString(R.string.greeting)
//        imageView.setImageResource(R.mipmap.ic_launcher_round)

        val animeImg = intArrayOf(
            R.drawable.opm_profile_pic,
            R.drawable.opm_moon,
            R.drawable.opm_snaps,
            R.drawable.opm_lock_screen_bg,
            R.drawable.zenitsu
        )

        btnHello.setOnClickListener {
            val randomSeed = Random()
            val randomIndex = randomSeed.nextInt(animeImg.size)
//            val name = editName.text.toString()
//            Toast.makeText(this, "Hello, $name", Toast.LENGTH_LONG).show()
            imageView.setImageResource(animeImg[randomIndex])
        }

//      CheckBox
        btnCheckFruit.setOnClickListener(){
            var selectedFruit = ""

            if (checkBoxApple.isChecked){
                selectedFruit += getString(R.string.apple_cb)
            }
            if (checkBoxOrange.isChecked){
                selectedFruit += getString(R.string.orange_cb)
            }
            if (checkBoxBerry.isChecked){
                selectedFruit += getString(R.string.berry_cb)
            }
//            when {
//                checkBoxApple.isChecked -> selectedFruit = getString(R.string.apple_cb)
//                checkBoxOrange.isChecked -> selectedFruit = getString(R.string.orange_cb)
//                checkBoxBerry.isChecked -> selectedFruit = getString(R.string.berry_cb)
//            }

            val alertDialog: AlertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle(getString(R.string.fruit_alert_dialog_title))
            alertDialog.setMessage("Your selected Fruits, $selectedFruit ")
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                DialogInterface.OnClickListener(){ dialog, which -> dialog.dismiss() })
            alertDialog.show()
        }

//      RadioButton
        radioButtonMale.setOnCheckedChangeListener(){compoundButton, isChecked -> if (isChecked){
            Toast.makeText(this, getString(R.string.rb_male),Toast.LENGTH_LONG).show()
        }
        }

        radioButtonFemale.setOnCheckedChangeListener(){compoundButton, isChecked -> if (isChecked){
            Toast.makeText(this, getString(R.string.rb_female),Toast.LENGTH_LONG).show()
        }
        }

//      ToggleButton
        tb_guest_room_light.setOnCheckedChangeListener(){compoundButton, isChecked ->
            when {
                isChecked -> {
            Toast.makeText(this, "Turning ON the Guest Room Light",Toast.LENGTH_LONG).show()
        }
                else -> {
                    Toast.makeText(this, "Turning OFF the Guest Room Light",Toast.LENGTH_LONG).show()
                }
        }
        }

//      Switch
        swt_door_lock.setOnCheckedChangeListener { compoundButton, b ->
            when {
                b -> {
                    Toast.makeText(this, "Switching ON the Door Lock", Toast.LENGTH_LONG)
                        .show()
                }
                else -> {
                    Toast.makeText(this, "Switching OFF the Door Lock", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

//      SeekBar
        sb_volume.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean){
//              logic code
            }
            override fun onStartTrackingTouch(seekBar: SeekBar){

            }
            override fun onStopTrackingTouch(seekBar: SeekBar){

            }
            })

//      RatingBar
        rbRatingStar.setOnRatingBarChangeListener(){ratingBar, rating, fromUser ->
        }

//      AutoCompleteTextView
        /**must attach with an adapter **/
        val drinksAdapter: ArrayAdapter<Any?> = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
        resources.getStringArray(R.array.additional_drinks))
        acDrinks.setAdapter(drinksAdapter)

//        val autotextView = findViewById<AutoCompleteTextView>(R.id.acDrinks)
//        val drinks = resources.getStringArray(R.array.additional_drinks)
//        val adapter = ArrayAdapter(this,
//        android.R.layout.simple_list_item_1, drinks)
//        autotextView.setAdapter(adapter)

//        date picker
        btn_select_date.setOnClickListener() {
            val calendar = Calendar.getInstance()
            val day = calendar[Calendar.DAY_OF_MONTH]
            val month = calendar[Calendar.MONTH]
            val year = calendar[Calendar.YEAR]

//        date picker dialog
            val picker = DatePickerDialog(
                this,
                { dp, year, month, day ->
//                logic code
                    tv_selected_date.text = ("$day/${month + 1}/$year")
                },
                2022,
                12,
                12
            )
            picker.show()
        }

//        time picker
        btn_select_time.setOnClickListener(){
            val calendar = Calendar.getInstance()
            val hour = calendar[Calendar.HOUR_OF_DAY]
            val minute = calendar[Calendar.MINUTE]

//            time picker dialog
            val picker = TimePickerDialog(
                this,
                {
                    tp, hour, minute ->
//                    loic code
                    tv_selected_time.text = ("$hour:$minute")
                },
                hour,
                minute,
                true
            )
            picker.show()
        }
        }
    }

