package learning.com.githhub.login

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import learning.com.githhub.R
import learning.com.githhub.appModel.UserModel
import learning.com.githhub.base.BaseActivity
import learning.com.githhub.base.BaseFragment
import learning.com.githhub.databinding.FragLoginBinding
import learning.com.githhub.home.HomeFragment
import learning.com.githhub.main.NavMngr
import learning.com.githhub.utils.AppLoader
import learning.com.githhub.utils.AppUtils

/**
 * Created by mohankumar on 9/7/18.
 */

class LoginFragment : BaseFragment(), LoginPresenterImpl.LoginPresenter, View.OnClickListener {


    private lateinit var  activity: BaseActivity;
    private lateinit var  fBinding: FragLoginBinding;
    private lateinit var  hImpl: LoginPresenterImpl;
    lateinit var  aLoader:AppLoader

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.activity =  getActivity() as BaseActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(activity).inflate(R.layout.frag_login, null);
        fBinding = DataBindingUtil.bind(view);
        initView();
        return fBinding.getRoot();
    }

    private fun initView() {
        hImpl = LoginPresenterImpl(activity, this)
        fBinding.btnLogin.setOnClickListener(this);
        aLoader = AppLoader(activity);
    }

    override fun onClick(view: View) {
        when (view.getId()) {
            R.id.btnLogin -> {
                hImpl.loginAction(fBinding.eUser.text.toString().trim(),fBinding.eToken.text.toString().trim(),
                        fBinding.ePass.text.toString().trim())
            }
        }
    }

    override fun manageLoader(state: Boolean) {
        if(state){
            aLoader.showLoader()
            return
        }

        aLoader.hideLoader()
    }

    override fun onAction(obj: Any) {
        AppUtils.showMessage(fBinding.root,obj.toString());
    }

    override fun showContent(cModel: UserModel) {
        NavMngr.popFragment()

        val hFragment = HomeFragment()
        hFragment.lModel = cModel
        NavMngr.pushFragment(hFragment as BaseFragment);

    }

    override fun showDisplay(sMsg: String) {
        AppUtils.showMessage(fBinding.root, sMsg);
    }

}