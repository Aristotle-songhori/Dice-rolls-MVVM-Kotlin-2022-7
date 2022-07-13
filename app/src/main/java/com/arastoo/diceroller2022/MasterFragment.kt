package com.arastoo.diceroller2022

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.arastoo.diceroller2022.databinding.FragmentMasterBinding

class MasterFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //بایندینگ رو تعریف میکنیم
        val binding = FragmentMasterBinding.inflate(inflater)
        //لایف سایکل رو میدیم به بایندینگ
        binding.lifecycleOwner = this

        //تعریف ویو مدل
        //viewModel = ViewModelProvider(this)[MasterViewModel::class.java]
        val viewModel: MasterViewModel by lazy { ViewModelProvider(this)[MasterViewModel::class.java] }

        //تعریف داده داخل لایوت به عنوان ویومدل
        // این مقدار در باید دربخش داده های لایوت پیدا کنی
        binding.xmlViewModelData=viewModel

/**   /////////////////////////////////////////////////////////////////////////////////////
        // Create the observer which updates the UI from viewModel.imageID.
        //این میاد میره یه مقاری رو آبزرو میکنه سریع میتونه it باشه میتونه هرچیز دیگه باشه
//        val xxxxxx = Observer <Int> {
//            // Update the UI, in this case, a TextView.
//            binding.button2.text = "id => ${it.toString()}"
//            binding.imageButton.setImageResource(it)
//        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        // اینجا میگیم مقدارviewModel.imageID یک پارامتر نگاه شونده هست
        // که از طرف xxxxxx داره نگاه میشه و هر وقت تغییر کرد بیا مقدارش رو به صورت It بگیر و توی اون تابع هرکاری خواستی بکن
       // viewModel.imageID.observe(viewLifecycleOwner, xxxxxx)
        /////////////////////////////////////////////////////////////////////////////////////
*/
        // همه 2 تا تکه کد بالا در یک کلام با هم نگاه کننده ایمیج آیدی
        viewModel.imageID.observe(viewLifecycleOwner, Observer {
            binding.textViewImgId.text = "Drawabel Res id => $it"
            binding.imageButton.setImageResource(it)
        })

        //نگاه کننده امتیاز
        viewModel.yourScore.observe(viewLifecycleOwner, Observer {
            binding.textViewScore.text = "Score => $it"
        })

        //نگاه کننده تعداد پرتاب
        viewModel.yourRolls .observe(viewLifecycleOwner, Observer {
            binding.textViewLanch.text = "Rolls => $it"
        })
        /////////////////////////////////////////////////////////////////////////////////////

        //اینجا م که میایم و میگیم لایه رو لود کن عمو جان
        //return inflater.inflate(R.layout.fragment_master, container, false)
        return  binding.root

    }

}