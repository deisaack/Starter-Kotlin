package com.qubeans.foobar.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.qubeans.foobar.Hobby
import com.qubeans.foobar.R
import com.qubeans.foobar.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    companion object {
        val TAG: String = HobbiesAdapter::class.java.simpleName
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        
        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.imgShare.setOnClickListener {
                currentHobby?.let {
                    val message = "My Hobby is " + currentHobby!!.title
                    context.showToast(message);
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"
                    context.startActivity(Intent.createChooser(intent, "Share To"))
                }
            }
        }
        fun setData(hobby: Hobby, position: Int) {
            itemView.txvTitle.text = hobby.title
            this.currentHobby = hobby
            this.currentPosition = position
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }
}