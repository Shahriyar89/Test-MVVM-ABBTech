package com.example.mvvmarchitectureabbtech.ui.customview

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.mvvmarchitectureabbtech.R

class ProfileCustomView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {


    private var isVisibleSurName: Boolean = false



    init {
        inflate(context, R.layout.item_row, this)
        initViews(context,attrs)
    }

    private fun initViews(context: Context, attrs: AttributeSet?) {
        context.obtainStyledAttributes(
            attrs,
            R.styleable.ProfileCustomView,0,0
        ).apply {
            isVisibleSurName =
                getBoolean(R.styleable.ProfileCustomView_profile_surname_label_visible, false)
        }

        refreshView()
    }

    private fun refreshView(){
        val surname =findViewById<TextView>(R.id.uSurName)
        surname.isVisible=isVisibleSurName

    }

    fun setSurnameVisible(data:ProfileModel){
        val firstName =findViewById<TextView>(R.id.uName)
        val surname =findViewById<TextView>(R.id.uSurName)
        val image =findViewById<ImageView>(R.id.profile)

        firstName.text=data.firstName
        surname.text=data.surName
        Glide.with(context)
            .load(data.image)
            .into(image)

    }
}