package learning.com.githhub.base

import android.support.v4.app.Fragment


/**
 * Created by mohankumar on 9/8/18.
 */

open class BaseFragment : Fragment() {


    //Overide function in your fragment if need to handle back press
    fun hasBackHandle():Boolean{
        return false
    }

}