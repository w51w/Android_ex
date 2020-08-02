package com.example.sqlitesam0625

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*
import java.text.SimpleDateFormat

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.Holder>() {
    var helper:SqliteHelper? = null
    var listData = mutableListOf<Memo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return Holder(view)

    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var mMemo:Memo? = null
        init {
            itemView.buttonDelete.setOnClickListener {
                helper?.deleteMemo(mMemo!!)
                listData.remove(mMemo)
                notifyDataSetChanged()
            }
        }
        fun setMemo(memo:Memo){
            itemView.textNo.text = "${memo.no}"
            itemView.textContent.text = memo.content
            val sdf = SimpleDateFormat("yyyy/mm/dd hh:mm")
            itemView.textDatetime.text ="${sdf.format(memo.datetime)}"

            this.mMemo = memo
        }
    }
}