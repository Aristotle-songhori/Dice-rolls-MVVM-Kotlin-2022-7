package com.arastoo.diceroller2022


/** 1 افزودن کتابخانه دیتابایندینگ
 * اول داخل گریدل دیتابایندینگ رو اضافه میکنیم
 * دربخش اندروید باید اضافه بشه
 * buildFeatures {
dataBinding true

}
 */

/**2-اضافه کردن یک فرگمنت با ویو کنترلر برای صفحه اصلی
 * یه فرگمنت اصلی میسازیم برای صفحه اول اپ
 */

/**3- افزودن نویگیشن به برنامه  و ریسورسها و کتابخانه
 * از پوشه ریسورسها پوشه نویگیسن رو بزنید
 * بعدریسور نویگیشن بهش اضافه کنید
 * بعد خودش باید کتابخونه رو لود کنه
 */

/**4- معرفی نویگیشن هاستینگ به لایوت اکتیوتی
 * برای مدیریت فرگمنت ها
 * باید برید اونجا تو ویو ها سرچ کنید navhost
 * بعد این 2 تا رو مچ پرنت کنید
 *         android:layout_width="match_parent"
android:layout_height="match_parent"

 */

/**5- رفتن به لایوت فرگمنت و تبدیل به بایندینگ و افزودن یک داده به آن
 * باید برید مقدار رو layout تعریف کنید
 * بعد یه مقدار داده اضافه نید و به ویو مدل وصل کنید
 * <data>
<variable name="xmlMasterData" type="com.arastoo.diceroller2022.MasterViewModel"/>
</data>
 داخل ویو مدل حتما باید مقدارش رو مشخص کنید
 و در لایوت هم میتونید مقدار ها رو بگیرید
 *
 */


/**
 *
/** یک راهنمای عالی برای روش های مختلف گرفتن کلیک با مقدار در بایندینگ
 * https://developpaper.com/seven-click-modes-of-databinding-onclick/
*/
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}