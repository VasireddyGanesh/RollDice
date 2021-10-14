package com.example.rolldice

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    var imageView : ImageView? = null

    var textView :TextView? = null

    var buttonView : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView=findViewById(R.id.IDImageView)
        textView=findViewById(R.id.IDTextView)
        buttonView=findViewById(R.id.IDBtn)
        roll()
        buttonView!!.setOnClickListener {
            roll()
        }
    }

    private fun roll() {
        val dice :Dice = Dice(6)
        val dicenum :Int =dice.rollDice()
        textView!!.text = dicenum.toString()
        textView!!.visibility=View.VISIBLE
        when(dicenum){
            1->imageView!!.setImageResource(R.drawable.one)
            2->imageView!!.setImageResource(R.drawable.two)
            3->imageView!!.setImageResource(R.drawable.three)
            4->imageView!!.setImageResource(R.drawable.four)
            5->imageView!!.setImageResource(R.drawable.five)
            6->imageView!!.setImageResource(R.drawable.six)
        }

    }

    class Dice(var diceInt : Int ){
        fun rollDice() : Int {
            return (1..diceInt).random()
        }
    }
}