package learning.com.githhub.home

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_user_detail.view.*
import learning.com.githhub.R
import learning.com.githhub.base.BaseActivity
import learning.com.githhub.utils.AppUtils
import learning.com.githhub.utils.UiUtils

/**
 * Created by mohankumar on 9/8/18.
 */


class UserAdapter(val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    var arrayList:ArrayList<Pair<String,String>>? = null;



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_user_detail, parent, false))
    }

    override fun getItemCount(): Int {
        if (arrayList == null) {
            return 0
        }

        return arrayList!!.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pair = arrayList!![position];
        holder.iHeader.text = pair.first
        holder.iValue.text = pair.second

        var cCode = R.color.colorText

        if(AppUtils.isWebUrl(pair.second)){
            cCode = R.color.colorPrimary
        }

        holder.iValue.setTextColor(ContextCompat.getColor(context,cCode))
        holder.rootView.tag = position


        holder.rootView.setOnClickListener {
            val pair = arrayList!![position];
            if(AppUtils.isWebUrl(pair.second)){
                UiUtils.loadWebPage(context as BaseActivity,pair.second)
            }

        }

    }



}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val rootView = view.layoutUser
    val iHeader = view.iName
    val iValue = view.iValue

}