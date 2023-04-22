package com.example.reminderfeature

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val add=findViewById<Button>(R.id.add)
        val delete=findViewById<Button>(R.id.delete)

        val date=findViewById<EditText>(R.id.editTextDate).text
        val time=findViewById<TimePicker>(R.id.time)
        val reminder=findViewById<EditText>(R.id.reminders).text





        add.setOnClickListener(){
            var timeSet:String
            var dateSet:String
            var remindSet:String

            //var error
            var hour=time.hour
            var minute=time.minute
            var dateTest=date.toString()
            val realTime=LocalDateTime.now()
            Log.v("Real Time",realTime.toString())
            val e: Boolean = getPresentCheck(realTime,dateTest, hour, minute)



            Log.v("Set time to",hour.toString()+":"+minute.toString())
            timeSet=getTime(hour,minute)
            Log.v("Real Time",realTime.toString())
            dateSet=date.toString()


            Log.v("Date Test",dateTest)
            var formatter=DateTimeFormatter.ofPattern("MM-dd-yyyy")



            //var date=
//            var m:String
//            var timeStr:String
//            if (hour>12){
//                hour=hour-12
//                m ="PM"
//            }
//            else if(hour==12){
//                m ="PM"
//            }
//            else{
//                if (hour==0){
//                    hour=hour+12
//                }
//                m ="AM"
//            }
//            if(minute<10){
//                timeStr=hour.toString()+":0"+ minute.toString()+m
//            }
//            else{
//                timeStr=hour.toString()+":"+ minute.toString()+m
//            }

//            Log.v("Hour",hour.toString())
//            Log.v("Minute",minute.toString())
//            Log.v("Time",timeStr)
        }
        delete.setOnClickListener{

        }


    }

//    private fun getDate(date: String): Any {
//            val d= date
//            //d=d.split("/")
//    }

    private fun getTime(hour: Int, minute: Int): String {
        var h = hour
        var min = minute
        var m:String
        var timeStr:String
        if (h>12){
            h=h-12
            m ="PM"
        }
        else if(h==12){
            m ="PM"
        }
        else{
            if (h==0){
                h=h+12
            }
            m ="AM"
        }
        if(min<10){
            timeStr=h.toString()+":0"+ min.toString()+m
        }
        else{
            timeStr=h.toString()+":"+ min.toString()+m
        }
        Log.v("Hour",h.toString())
        Log.v("Minute",min.toString())
        Log.v("Time",timeStr)
        return timeStr
    }

    private fun getPresentCheck(rt: LocalDateTime, dt:String, h: Int, m: Int): Boolean{
        val present=rt
        val time =h.toString()+":"+m.toString()
        val dateList= dt.split("/")
        if(dateList.size!=3){
            return false
        }
        else{
            val dateMonth=dateList[0]
            val dateDay=dateList[1]
            val dateYear=dateList[2]
        }
        if (dateList[0].toInt()>0&&dateList[0].toInt()<13){
            //if(dateList[0]==)
            val a=0
        }

        return true
    }


}