package com.rantolin.cleanarchitecture.presentation.ui.fragments

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rantolin.cleanarchitecture.domain.model.UserModel
import com.rantolin.cleanarchitecture.presentation.AndroidApplication
import com.rantolin.cleanarchitecture.presentation.R
import com.rantolin.cleanarchitecture.presentation.internal.di.components.DaggerFragmentComponent
import com.rantolin.cleanarchitecture.presentation.internal.di.components.FragmentComponent
import com.rantolin.cleanarchitecture.presentation.internal.di.modules.FragmentModule
import com.rantolin.cleanarchitecture.presentation.ui.adapters.MainFragmentViewAdapter
import com.rantolin.cleanarchitecture.presentation.ui.presenters.MainPresenter
import com.rantolin.cleanarchitecture.presentation.ui.views.MainView
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.ArrayList
import javax.inject.Inject

class MainFragment: BaseFragment(), MainView {
    private var entryList:List<UserModel> = ArrayList()
    private val spanCount = 2
    private val orientation = StaggeredGridLayoutManager.VERTICAL

    @Inject
    lateinit var presenter:MainPresenter

    private val component: FragmentComponent
        get() = DaggerFragmentComponent.builder()
                .applicationComponent((activity.application as AndroidApplication).component)
                .fragmentModule(FragmentModule(this))
                .build()


    companion object{
        fun newInstance (bundle: Bundle?): MainFragment {
            val fragment = MainFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, "Something was wrong: ${throwable.message}", Toast.LENGTH_LONG).show()
        Log.d("Error", throwable.message)
    }

    override fun searchResult(entryList: List<UserModel>) {
        itemsList.adapter = MainFragmentViewAdapter(entryList) {
            goToUserDetails(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = inflater?.inflate(R.layout.fragment_main,container,false)
        component.inject(this)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onCreate(this)
        val staggeredLM = StaggeredGridLayoutManager(spanCount,orientation)
        staggeredLM.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        itemsList.setHasFixedSize(true)
        itemsList.isDrawingCacheEnabled = true
        itemsList.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH;
        itemsList.layoutManager = staggeredLM
        itemsList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                (recyclerView.layoutManager as StaggeredGridLayoutManager).invalidateSpanAssignments()
            }
        })

    }

    fun goToUserDetails(userModel:UserModel){

    }
}