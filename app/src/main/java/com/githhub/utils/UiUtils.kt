package com.githhub.utils

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.githhub.R
import com.githhub.callback.DCallBack
import timber.log.Timber
import android.content.Intent
import android.net.Uri
import com.githhub.base.BaseActivity


/**
 * Created by mohankumar on 9/8/18.
 */

object UiUtils{

    fun loadWebPage(context:BaseActivity,url:String){
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        context.startActivity(i)
    }

    fun loadImage(strUrl:String,iView:ImageView){

        if(!AppUtils.isValidString(strUrl)){
            Timber.e("invalid image url")
            return
        }

        Picasso.get().load(strUrl)
                    .placeholder(R.drawable.place_image)
                    .into(iView);

    }

    fun askConfirmation(context:Context,sHeader:String,sBody:String,dCallBack:DCallBack){
        val builder = AlertDialog.Builder(context)

        // Set the alert dialog title
        builder.setTitle(sHeader)

        // Display a message on alert dialog
        builder.setMessage(sBody)

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("YES"){dialog, which ->
            dCallBack.dialogAction(DialogInterface.BUTTON_POSITIVE,null,null)
            dialog.dismiss()
        }


        // Display a negative button on alert dialog
        builder.setNegativeButton("No"){dialog,which ->
            dCallBack.dialogAction(DialogInterface.BUTTON_NEGATIVE,null,null)
            dialog.dismiss()
        }


        // Display a neutral button on alert dialog
        builder.setNeutralButton("Cancel"){dialog,which ->
            dCallBack.dialogAction(DialogInterface.BUTTON_NEUTRAL,null,null)
            dialog.dismiss()
        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}