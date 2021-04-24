package br.unifor.cct.rgbpicker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private var hexValueR: String = "00"
    private var hexValueG: String = "00"
    private var hexValueB: String = "00"

    private var intValueR: Int = 0
    private var intValueG: Int = 0
    private var intValueB: Int = 0

    private lateinit var mColorView:View
    private lateinit var mColorValue: TextView

    private lateinit var mColorPickerR:SeekBar
    private lateinit var mColorPickerG:SeekBar
    private lateinit var mColorPickerB:SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mColorView = findViewById(R.id.main_view_colorview)
        mColorValue = findViewById(R.id.main_textview_colorvalue)

        mColorPickerR = findViewById(R.id.main_seekbar_colorpickerR)
        mColorPickerG = findViewById(R.id.main_seekbar_colorpickerG)
        mColorPickerB = findViewById(R.id.main_seekbar_colorpickerB)

        mColorPickerR.setOnSeekBarChangeListener(this)
        mColorPickerG.setOnSeekBarChangeListener(this)
        mColorPickerB.setOnSeekBarChangeListener(this)

    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            var hexValue = progress.toString(16)

            if(seekBar?.id == R.id.main_seekbar_colorpickerR){
                this.intValueR = progress
                    if (hexValue.length == 1){
                        this.hexValueR = "0$hexValue"
                    } else{
                        this.hexValueR = "$hexValue"
                    }
            } else if (seekBar?.id == R.id.main_seekbar_colorpickerG){
                this.intValueG = progress
                    if (hexValue.length == 1){
                        this.hexValueG = "0$hexValue"
                    } else{
                        this.hexValueG = "$hexValue"
                }
            } else if (seekBar?.id == R.id.main_seekbar_colorpickerB){
                this.intValueB = progress
                    if (hexValue.length == 1){
                    this.hexValueB = "0$hexValue"
                    } else{
                    this.hexValueB = "$hexValue"
                }
            }

            mColorView.setBackgroundColor(Color.rgb(intValueR, intValueG, intValueB))
            mColorValue.text = "#${this.hexValueB}R${this.hexValueG}${this.hexValueB}".toUpperCase()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        when (seekBar?.id){
            R.id.main_seekbar_colorpickerR ->{
            Log.i("App","Start touch!")
            }
        }
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        Log.i("App","Stop touch!")
    }
}