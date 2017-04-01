package com.rantolin.cleanarchitecture.presentation.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.rantolin.cleanarchitecture.domain.model.UserModel
import com.rantolin.cleanarchitecture.presentation.R
import com.rantolin.cleanarchitecture.utils.inflate
import com.rantolin.cleanarchitecture.utils.loadUrl
import kotlinx.android.synthetic.main.item_home.view.*

class MainFragmentViewAdapter(val objects: List<UserModel>, val listener: (UserModel) -> Unit) :
        RecyclerView.Adapter<MainFragmentViewAdapter.HomeViewHolder>() {
    override fun getItemCount(): Int = objects.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            HomeViewHolder = HomeViewHolder(parent.inflate(R.layout.item_home))

    override fun onBindViewHolder(vh: HomeViewHolder, i: Int) = vh.bind(objects[i], listener)

    class HomeViewHolder(var itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(userModel: UserModel, listener: (UserModel) -> Unit) = with(itemview) {
            if (userModel.userImage != null) {
                cardImage.layout(0, 0, 0, 0)
                cardImage.loadUrl(userModel.userImage!!)
            }
            cardTitle.text = userModel.username
            setOnClickListener { listener(userModel) }
        }
    }
}