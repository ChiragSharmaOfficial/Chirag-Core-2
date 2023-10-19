package com.example.coretwo
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast


private val cycles: Array<String> = arrayOf(
    "cycle1",
    "cycle2",
    "cycle3",

    )

//    private lateinit var CycleName: TextView
//    private lateinit var tvLabel: TextView
//    private lateinit var seekBar1: SeekBar
//    private lateinit var Price: TextView
//    private lateinit var saveButton: Button
//    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)

private val prices: Array<Int> = arrayOf(
    40, 60, 75,
)

//    private lateinit var CycleName: TextView
//    private lateinit var tvLabel: TextView
//    private lateinit var seekBar1: SeekBar
//    private lateinit var Price: TextView
//    private lateinit var saveButton: Button
//    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)

class BorrowCycle : AppCompatActivity() {
    // android widget variables
    private lateinit var CycleName: TextView
    private lateinit var tvLabel: TextView
    private lateinit var seekBar1: SeekBar
    private lateinit var Price: TextView
    private lateinit var saveButton: Button
    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cycle_borrow)

        CycleName = findViewById(R.id.name)
        tvLabel = findViewById(R.id.days)
        Price = findViewById(R.id.price)
        seekBar1 = findViewById(R.id.seekBar)
        saveButton = findViewById(R.id.buttonSave)

//    private lateinit var CycleName: TextView
//    private lateinit var tvLabel: TextView
//    private lateinit var seekBar1: SeekBar
//    private lateinit var Price: TextView
//    private lateinit var saveButton: Button
//    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)

        val cycle = intent.getIntExtra("currentCycle", 0)
        val price = prices[cycle]
        val ratingList = intent.getStringArrayListExtra("ratingList")
        val rentList = intent.getStringArrayListExtra("rentList")

        // receive cycle list
        for (i in 0..2) {
            val receivedCycle = intent.getParcelableExtra<Cycle>("cycle_$i")

            if (receivedCycle != null) {
                cycleArray[i] = receivedCycle
            }
        }
//    private lateinit var CycleName: TextView
//    private lateinit var tvLabel: TextView
//    private lateinit var seekBar1: SeekBar
//    private lateinit var Price: TextView
//    private lateinit var saveButton: Button
//    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)

        var borrowDays = 1

        val cycleStringList = intent.getStringArrayListExtra("cycles")

        CycleName.text = cycles[cycle]
        Price.text = "$$price"

//    private lateinit var CycleName: TextView
//    private lateinit var tvLabel: TextView
//    private lateinit var seekBar1: SeekBar
//    private lateinit var Price: TextView
//    private lateinit var saveButton: Button
//    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)

        // Set up a listener for SeekBar changes
        seekBar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Update the TextView with the current value
                borrowDays = progress
                Price.text = "$${price * (progress)}" // Update with the calculated rent
                if (borrowDays == 1) {
                    tvLabel.text = "$borrowDays day"
                }
                else{
                tvLabel.text = "$borrowDays days"
            }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if(borrowDays==1) {
                tvLabel.text = "$borrowDays day"}
                else
                {
                    tvLabel.text = "$borrowDays days"

                }
            }
//    private lateinit var CycleName: TextView
//    private lateinit var tvLabel: TextView
//    private lateinit var seekBar1: SeekBar
//    private lateinit var Price: TextView
//    private lateinit var saveButton: Button
//    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Hide the tooltip when the user stops touching the SeekBar
                if(borrowDays==1) {
                    tvLabel.text = "$borrowDays day"}
                else
                {
                    tvLabel.text = "$borrowDays days"

                }
            }
        })
//    private lateinit var CycleName: TextView
//    private lateinit var tvLabel: TextView
//    private lateinit var seekBar1: SeekBar
//    private lateinit var Price: TextView
//    private lateinit var saveButton: Button
//    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)


        saveButton.setOnClickListener {
            if (borrowDays == 0) {
                Toast.makeText(
                    this, "Must Select Atleast Some Days",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, MainActivity()::class.java)
                intent.putExtra("rentPeriod", borrowDays)
                intent.putExtra("currentCycle", cycle)
////    private lateinit var CycleName: TextView
////    private lateinit var tvLabel: TextView
////    private lateinit var seekBar1: SeekBar
////    private lateinit var Price: TextView
////    private lateinit var saveButton: Button
////    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)
                // pass all cycles
                for (i in 0..2) {
                    intent.putExtra("cycle_$i", cycleArray[i])
                }
                Toast.makeText(this, "Good Choice", Toast.LENGTH_SHORT).show()

                setResult(RESULT_OK,intent)
                finish()
            }
        }
//    private lateinit var CycleName: TextView
//    private lateinit var tvLabel: TextView
//    private lateinit var seekBar1: SeekBar
//    private lateinit var Price: TextView
//    private lateinit var saveButton: Button
//    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)

    }

    // Override the onBackPressed method for rent cancel message
    @Deprecated("This is an intentionally overrided-deprecated method from a super-class")
    override fun onBackPressed() {
        // Rent is canceled, show toast message
        Toast.makeText(this, "Keep Exploring for the right cycle", Toast.LENGTH_SHORT).show()
//    private lateinit var CycleName: TextView
//    private lateinit var tvLabel: TextView
//    private lateinit var seekBar1: SeekBar
//    private lateinit var Price: TextView
//    private lateinit var saveButton: Button
//    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)
        //Finish the current activity and return to MainActivity
        finish()
    }
//    private lateinit var CycleName: TextView
//    private lateinit var tvLabel: TextView
//    private lateinit var seekBar1: SeekBar
//    private lateinit var Price: TextView
//    private lateinit var saveButton: Button
//    private var cycleArray: Array<Cycle?> = arrayOfNulls(5)

}