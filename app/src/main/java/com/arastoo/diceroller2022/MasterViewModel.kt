package com.arastoo.diceroller2022

import android.util.Log
import android.view.View
import androidx.core.view.isGone
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.util.*


class MasterViewModel : ViewModel() {
    // TODO: Implement the ViewModel

   private var randomInt :Int = 0

    // یه لایو دیتا اینت میسازیم که قرار آیدی عکس ها رو بدیم بهش و این هر وقت عوض بشه
    // اون طرف یه پارامتر  داره نگاهش میکنه و تغیرات رو سریع میفهمه
    private val _imageID: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
    val imageID : LiveData<Int>
    get() =_imageID
//  get() {
//         return _imageID
//        }


    private val _yourScore: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
    val yourScore : LiveData<Int>
        get() =_yourScore

    private val _yourRolls: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
    val yourRolls : LiveData<Int>
        get() =_yourRolls


    // تابع اینشیالایز که اولین بار اجرا میشه و ما مقدار ایمیج آیدی خالی رو بهش دادیم عکس خالی خاکستری  رو ببینیم
    init {
        factoryReset()
    }
    private fun factoryReset(){
        _imageID.value=R.drawable.empty_dice
        _yourScore.value=0
        _yourRolls.value=0
    }

    /** یک راهنمای عالی برای روش های مختلف گرفتن کلیک با مقدار در بایندینگ
     * https://developpaper.com/seven-click-modes-of-databinding-onclick/
     */

    //Eventhandlers executes the click event
    // این یه تابع هست که تو لایوت گفتیم هروقت کلیک شد این رو اجرا کن
    //میتونه هراسمی داشته باشه

    fun clickButtonDiceRolls(view: View) {
        _yourRolls.value= _yourRolls.value?.plus(1)
        Log.i("arastoo", "testclick")

        //رو برو اجرا کن چرخش تاس
        rollDice()

// آخرین مقداری که رندوم تاس مونده رو اینجا اضافه میکنیم به امتیازات
        _yourScore.value= _yourScore.value?.plus(randomInt)
        //_yourScore.postValue(_yourScore.value?.plus(1) ?: 0)

    }

    fun clickButtonCleare(view: View) {
        factoryReset()
        Log.i("arastoo", "clickButtonCleare()")
    }



    private fun randomIntIdImage() {
         randomInt = Random().nextInt(6) + 1
        Log.i("arastoo", "randomInt${randomInt.toString()}")
        val drawableResource = when (randomInt) {

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //نکته مهم داره
//        imageID.value = drawableResource //این خطا میده میگه تو این ترد نیستید و باید از پست ولیو استفاده بشه
        _imageID.postValue(drawableResource)
    }


    private fun rollDice() {
        // Define a Runnable object
        randomInt=0 // اگر 0 نکنیم جمع میشه
        // نتونستیم صب کردن رو پیاده کنیم برای این داستان

        val runnable = java.lang.Runnable {
            // In the run() method, use a for loop to iterate
            // some code to show rolling dice animation



            for (i in 0 until 20) {
                randomIntIdImage()
                try {
                    // In a try block sleep the thread for a
                    // smooth animation
                    Thread.sleep(50)

                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }

            _yourScore.postValue(_yourScore.value?.plus(randomInt) ?: 0)



        }
        // Define a Thread object and pass the runnable object
        // in the constructor.
        val thread = Thread(runnable)
        // Start the thread. This will cause the run() method to be called
        // where all the dice rolling animation happens.
        thread.start()
        // If the MediaPlayer object is not null then start playing
        // the music.

    }


}// این جا پایان کلاس است