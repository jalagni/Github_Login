package learning.com.githhub.home

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import learning.com.githhub.R
import learning.com.githhub.appModel.UserModel
import learning.com.githhub.base.BaseActivity
import learning.com.githhub.base.BaseFragment
import learning.com.githhub.databinding.FragHomeBinding
import learning.com.githhub.utils.AppUtils
import learning.com.githhub.utils.UiUtils


/**
 * Created by mohankumar on 9/7/18.
 */

class HomeFragment : BaseFragment(), HomePresenterImpl.HomePresenter{

    private lateinit var  activity: BaseActivity
    private lateinit var  fBinding: FragHomeBinding;
    private lateinit var  hImpl: HomePresenterImpl;
    private var userAdapter:UserAdapter? = null

    var lModel:UserModel? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.activity =  getActivity() as BaseActivity
        userAdapter = UserAdapter(activity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(activity).inflate(R.layout.frag_home, null);
        fBinding = DataBindingUtil.bind(view);
        initView();
        return fBinding.getRoot();
    }

    private fun initView() {
        hImpl = HomePresenterImpl(activity,this)
        userAdapter!!.arrayList = AppUtils.getList(lModel)
        fBinding.listDetail.adapter = userAdapter
        fBinding.listDetail.layoutManager = LinearLayoutManager(activity)

        val itemDecor = DividerItemDecoration(activity, VERTICAL)
        fBinding.listDetail.addItemDecoration(itemDecor)

        if(lModel != null){
            UiUtils.loadImage(lModel!!.avatar_url,fBinding.iUserProfile)
        }
    }



    override fun onAction(obj: Any) {
        AppUtils.showMessage(fBinding.root,obj.toString());
    }


    override fun showContent(cModel: UserModel) {
    }

    override fun showDisplay(sMsg: String) {
        AppUtils.showMessage(fBinding.getRoot(),sMsg);
    }

}