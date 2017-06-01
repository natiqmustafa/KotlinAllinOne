package com.natodriod.kotlin.kotlinfunctions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvHelloWorld.setText("Hello World With Kotlin")

        // events
        bString.setOnClickListener {
            var text = etString.text.toString();
            showToast("Replaced text: ${text.replace("Barcelona", "Garabag")} \nOrginal text: $text")
        }

        bSub.setOnClickListener {
            showToast(sub(etNumber1.text.toString().toInt(), etNumber2.text.toString().toInt()).toString())
        }

        bSum.setOnClickListener {
            showToast(sum(etNumber1.text.toString().toInt(), etNumber2.text.toString().toInt()).toString())
        }

        bMult.setOnClickListener {
            showToast(multi(etNumber1.text.toString().toInt(), etNumber2.text.toString().toInt()).toString())
        }

        bDiv.setOnClickListener {
            showToast(div(etNumber1.text.toString().toFloat(), etNumber2.text.toString().toFloat()).toString())
        }



        bIfCondition.setOnClickListener {
            // Conditions
            val a = 100  // final variable
            val b = 200
            val c = if (a > b) a else b  // ternary if
            showToast("val c = if (${a} > ${b}) ${a} else ${b}   c = ${c}")


            when(a){
                100 -> showToast("a = 100")
                else -> {
                    showToast("a != 100")
                }
            }
        }


        bLoop.setOnClickListener {
            // for loop
            val items = listOf<Int>(1,2,3,4,5,6,7,8,10,20,30,40,50,60,70,80,90,100)
            for (index in items){
                Log.d("DEBUG",index.toString())
            }
            Log.d("BR_LINE", "--------------------------------------------------------------")
            // print index and value
            for (index in items.indices){
                Log.d("D_IND_VAL_1", "INDEX = $index = ${items[index]}")
            }
            Log.d("BR_LINE", "--------------------------------------------------------------")
            // PRINT index and val 2
            for ((i, v) in items.withIndex()){
                Log.d("D_IND_VAL_2", "(index, value) = ($i, $v)")
            }

            Log.d("BR_LINE", "--------------------------------------------------------------")
            // while loop
            var wl = 0
            while (wl < 10){
                wl++
                if (wl % 2 != 0)
                    Log.d("WHILE_LOOP", "var wl = " + wl)
                else {
                    continue
                }


            }
            Log.d("BR_LINE", "--------------------------------------------------------------")
            // do-while loop
            var dw = 0
            do {
                Log.d("DO_WHILE_LOOP", "var dw = " + dw)
                dw++
            }while(dw < 10)
        }


        bRanges.setOnClickListener {
            // Ranges example
            Log.d("BR_LINE", "-------------L O O P I N C R E M E N T---------------------")
            for(i in 1..10) // 1 <= i && i <= 10
            {
                Log.d("RANGE_INC", "i = $i")
            }
            Log.d("BR_LINE", "-----------D O W N T O ---------------------------------------")
            // downto
            for (i in 10 downTo 1){
                Log.d("RANGE_DOWN_TO", i.toString())
            }
            Log.d("BR_LINE", "---------------D O W N TO  L O O P  STEP --------------------")
            // downto step 2
            for (i in 10 downTo 1 step 2){
                Log.d("RANGE_DOWN_TO", i.toString())
            }
            Log.d("BR_LINE", "---------------------U N T I L- L O O P----------------------")
            for(i in 1 until 10) // 1 <= i && i < 10
            {
                Log.d("RANGE_UNTIL", "i = $i")
            }
        }

        bCollection.setOnClickListener {
            Log.d("BR_LINE", "----------------------------collection exm---------------------------")
            var listOfNumber = listOf(10,20,30,14,25)
            for (listItem in listOfNumber){
                Log.d("LIST_OF_NUMBER", listItem.toString())
            }


            Log.d("BR_LINE", "--------------------------- MutableList ----------------------------")
            Log.d("BR_LINE", "A generic ordered collection of elements that supports adding and removing elements.")

            var mutableListOfNumber = mutableListOf<Int>(10,20,30,14,25)
            for (listItem in mutableListOfNumber){
                Log.d("MUTABLE_LIST_A", listItem.toString())
            }
            mutableListOfNumber.add(2003)
            mutableListOfNumber.add(848)
            for (listItem in mutableListOfNumber){
                Log.d("MUTABLE_LIST_B", listItem.toString())
            }
            Log.d("MUTABLE_FIRST_ITEM", mutableListOfNumber.first().toString())
            Log.d("MUTABLE_LAST_ITEM", mutableListOfNumber.last().toString())
            Log.d("MUTABLE_FILTER", mutableListOfNumber.filter { it % 2 != 0 }.toString())

            Log.d("BR_LINE", "-------- NOdupLICATE HASHSETOF-----------")
            val noDublicateData = hashSetOf<String>("Bakı", "Naxçıvan", "Culfa", "Bakı", "Culfa")
//            for (hasSetItem in noDublicateData)
            for (hasSetItem in noDublicateData.toSortedSet())
            {
                Log.d("NO_DUB_DATA", hasSetItem)
            }

            Log.d("BR_LINE", "-------- HASH_MAP-------------------------")
            val myHashMap = hashMapOf<String, Int>("First" to 1, "Second" to 2)
            Log.d("HASH_MAP", myHashMap["First"].toString())
            Log.d("HASH_MAP", myHashMap["Second"].toString())
            myHashMap["Third"] =  3
            Log.d("HASH_MAP", myHashMap["Third"].toString())


        }


    }

    fun sum(num1 : Int, num2: Int) : Int {
        return num1 + num2
    }

    fun sub(n1 : Int, n2: Int) : Int = n1 - n2


    fun div(n1 : Float, n2 :Float):Float{
        if (n2 == 0f)
            return 0f
        else
            return n1/n2
    }

    fun multi(n1 : Int, n2 : Int) : Int = n1 * n2

    // void type fun
    fun showToast(msg : String):Unit{
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}
