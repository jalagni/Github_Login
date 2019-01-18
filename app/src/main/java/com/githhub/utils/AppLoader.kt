package com.githhub.utils

import android.app.ProgressDialog
import android.content.Context
import com.githhub.R

/**
 * Created by mohankumar on 9/8/18.
 */

class AppLoader(val context:Context){

    val dialog: ProgressDialog =  ProgressDialog(context);

    init {
        dialog.setMessage(context?.getString(R.string.loading));
    }

    fun showLoader(){
        dialog.show()
    }

    fun hideLoader(){
        dialog.dismiss()
    }

}