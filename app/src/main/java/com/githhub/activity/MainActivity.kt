package com.githhub.activity

import android.content.DialogInterface
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.githhub.R
import com.githhub.base.BaseActivity
import com.githhub.base.BaseFragment
import com.githhub.callback.DCallBack
import com.githhub.databinding.ActivityMainBinding
import com.githhub.login.LoginFragment
import com.githhub.main.NavMngr
import com.githhub.utils.AppUtils
import com.githhub.utils.UiUtils.askConfirmation
import timber.log.Timber

class MainActivity : BaseActivity(), MainPresenterImpl.MainPresenter, View.OnClickListener,DCallBack {

    private lateinit var aBinding: ActivityMainBinding ;
    private lateinit var mImpl: MainPresenterImpl;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(aBinding.toolbar)

        NavMngr.registerActivity(this)
        initActivity()

    }

    private fun initActivity() {
        mImpl = MainPresenterImpl(this)
        aBinding.fab.setOnClickListener(this)
        NavMngr.pushFragment(LoginFragment() as BaseFragment)

    }


    override fun onBackPressed() {
        val bFrag:BaseFragment = NavMngr.getFragmentOnTop()

        if(bFrag.hasBackHandle()){
            return
        }

        if(!NavMngr.isLastFragment()){
            super.onBackPressed()
            return
        }

        Timber.e("Ask dialog to close app")

        askConfirmation(this,
                getString(R.string.app_name),
                getString(R.string.closeConfirm),this

        )

    }

    override fun onClick(view: View) {
        Timber.e("fab click action")
        when (view.getId()) {
            R.id.fab -> AppUtils.showMessage(aBinding.root, getString(R.string.action))
        }

    }

    override fun dialogAction(state: Int, id: String?, obj: Any?) {

        if(state != DialogInterface.BUTTON_POSITIVE)
            return


        finish()

    }

    override fun displayMessage() {

    }
}
