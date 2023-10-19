package com.example.coretwo


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import java.time.LocalDate
import androidx.activity.result.contract.ActivityResultContracts

@RequiresApi(Build.VERSION_CODES.O)
private val Date = LocalDate.now() // get the current date

//    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"

class MainActivity : AppCompatActivity() {
    private lateinit var cycleBorrowActivityResultLauncher: ActivityResultLauncher<Intent>
    //    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"

    // create cycle objects to show on the screen
    private var cycleArray: Array<Cycle> = arrayOf(
        Cycle(
            R.drawable.cycle1,
            "Cycle1",
            "1 Gear Casual",
            2.5F,
            "1,0,1,1",
            30,
            0
        ),
        Cycle(
            R.drawable.cycle3,
            "Cycle2",
            "2 Gear Electric",
            4.5F,
            "1,1,1,0",
            50,
            0
        ),

        //    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"

        Cycle(
            R.drawable.cycle2,
            "Cycle2",
            "3 Gear Mountain",
            3.5F,
            "0,1,0,1",
            70,
            0
        )
    )

    //array of the ratings
    private var ratingList: MutableList<Float> = mutableListOf(
        cycleArray[0].rating,
        cycleArray[1].rating,
        cycleArray[2].rating,

        )
    //    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"
    //array of the rents
    private var rentList: MutableList<Int> = mutableListOf(
        cycleArray[0].borrowed,
        cycleArray[1].borrowed,
        cycleArray[2].borrowed,

        )
    //    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"
    // android widget the variables
    private lateinit var cycleImage: ImageView
    private lateinit var cycleName: TextView
    private lateinit var cycleDetail: TextView
    private lateinit var cycleRating: RatingBar
    private lateinit var cpAC: Chip
    private lateinit var cpDC: Chip
    private lateinit var cpNVA: Chip
    private lateinit var cpAutomatic: Chip
    private lateinit var Price: TextView
    private lateinit var borrowButton: Button
    private lateinit var nextButton: Button
    private lateinit var someActivityResultLauncher: ActivityResultLauncher<Intent>

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"
        cycleImage = findViewById(R.id.cycleImage)
        cycleName = findViewById(R.id.nameOfCycle)
        cycleDetail = findViewById(R.id.deatilOfCycle)
        cycleRating = findViewById(R.id.ratingOfCycle)
        cpAC = findViewById(R.id.AC)
        cpDC = findViewById(R.id.DCchip)
        cpNVA = findViewById(R.id.NVAchip)
        cpAutomatic = findViewById(R.id.AutomaticChip)
        Price = findViewById(R.id.tvPrice)
        borrowButton = findViewById(R.id.buttonBorrow)
        nextButton = findViewById(R.id.buttonNext)

        var rentPeriod= 0
        var currentCycle = 0


//    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"
        cycleBorrowActivityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                if (result.resultCode == RESULT_OK) {
                    val data = result.data
                    if (data != null) {
                        rentPeriod = data.getIntExtra("rentPeriod", 0)
                        currentCycle = data.getIntExtra("currentCycle", 0)
                        for (i in 0..2) {
                            val recievedCycle = data.getParcelableExtra<Cycle>("cycle_$i")
                            if (recievedCycle != null) {
                                cycleArray[i].rating = recievedCycle.rating
                                cycleArray[i].borrowed = recievedCycle.borrowed
                            }
                            if(i==currentCycle){
                                cycleArray[i].borrowed=rentPeriod
                            }

                        }
                    }

                    showRentButton(rentPeriod)
                    displayCycleAd(cycleArray[currentCycle])

                }
            }
////    cycleImage.setImageResource(cycle.pic)
////    cycleName.text = cycle.name
////    cycleDetail.text = cycle.description
////    cycleRating.rating = cycle.rating
////    Price.text = "$${cycle.price}"

        showRentButton(rentPeriod)
        displayCycleAd(cycleArray[currentCycle])



        borrowButton.setOnClickListener {
            updateRating(currentCycle)
            // Handles the "Borrow" button click
            val intent = Intent(this, BorrowCycle::class.java)
            intent.putExtra("currentCycle", currentCycle)
            //pass all the cycles
            for (i in 0..2) {
                intent.putExtra("cycle_$i", cycleArray[i])
            }
//    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"
            cycleBorrowActivityResultLauncher.launch(intent)
        }
        nextButton.setOnClickListener {
            // Handle the "Next" button click
            updateRating(currentCycle)

            currentCycle++
            if (currentCycle > 2) {
                currentCycle = 0
            }
            displayCycleAd(cycleArray[currentCycle])
            showRentButton(cycleArray[currentCycle].borrowed)

        }
    }
//    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showRentButton(days: Int) {
        if (days == 0) {
            borrowButton.text = "Borrow"
            borrowButton.isEnabled = true
        } else {
            val dueDate = Date.plusDays(days.toLong())

            borrowButton.text = "Borrowed till $dueDate "
            borrowButton.isEnabled = false
        }
    }

    private fun updateRent(currentCycle: Int, rentPeriod: Int) {
        cycleArray[currentCycle].borrowed = rentPeriod
        rentList[currentCycle] = rentPeriod
    }

    private fun updateRating(currentCycle: Int) {
        cycleArray[currentCycle].rating = cycleRating.rating
        ratingList[currentCycle] = cycleRating.rating

    }
//
//    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"
    // Function to populate the cycle postings
    private fun displayCycleAd(cycle: Cycle) {
        cycleImage.setImageResource(cycle.pic)
        cycleName.text = cycle.name
        cycleDetail.text = cycle.description
        cycleRating.rating = cycle.rating
        Price.text = "$${cycle.price}"
        cpAC.setChipBackgroundColorResource(
            if (cycle.parseFeatures()[0]) R.color.c else R.color.w
        )
        cpDC.setChipBackgroundColorResource(
            if (cycle.parseFeatures()[1]) R.color.c else R.color.w
        )
        cpNVA.setChipBackgroundColorResource(
            if (cycle.parseFeatures()[2]) R.color.c else R.color.w
        )
        cpAutomatic.setChipBackgroundColorResource(
            if (cycle.parseFeatures()[3]) R.color.c else R.color.w
        )
    }
//    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"

    override fun onBackPressed() {

        finishAffinity()

    }
}
//    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"

// converts list of float to an array of strings
fun floatToStringList(floatList: MutableList<Float>): ArrayList<String> {
    val stringList = ArrayList<String>()
    for (float in floatList) {
        stringList.add(float.toString())
    }
    return stringList
}

// converts a list of integers to an array of strings
fun intToStringList(intList: MutableList<Int>): ArrayList<String> {
    val stringList = ArrayList<String>()
    for (int in intList) {
        stringList.add(int.toString())
    }
    return stringList
}
//    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"
// converts an array of strings to a list of int
fun stringToIntList(stringList: ArrayList<String>): MutableList<Int> {
    val intList = mutableListOf<Int>()
    for (string in stringList) {
        val intValue = string.toIntOrNull()
        if (intValue != null) {
            intList.add(intValue)
        }
    }
    return intList
}
//    cycleImage.setImageResource(cycle.pic)
//    cycleName.text = cycle.name
//    cycleDetail.text = cycle.description
//    cycleRating.rating = cycle.rating
//    Price.text = "$${cycle.price}"
// converts an array of strings to a list of float
fun stringToFloatList(stringList: ArrayList<String>): MutableList<Float> {
    val floatList = mutableListOf<Float>()
    for (string in stringList) {
        val floatValue = string.toFloatOrNull()
        if (floatValue != null) {
            floatList.add(floatValue)
        }
    }
    return floatList
}



