package com.example.helloandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.data_list_item.view.*

class DataAdapter (
    val items : ArrayList<String>,
    val context: Context
) : RecyclerView.Adapter<ViewHolder>(){

    //목록 개수를 반환
    override fun getItemCount(): Int {
        return items.size
    }
    //뷰를 띄움
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(
            R.layout.data_list_item,
            parent,
            false
        ))
    }
    //ArrayList의 각 데이터를 바인드
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvDataType.text = items[position]
    }
}
//데이터를 로드해 보여주기 위한 뷰홀더
class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
    //TextView에 각 데이터 항목을 가져오기 위해 리소스로부터
    val tvDataType = view.tv_data_type!!//안드로이드 확장을 통해 리소스 id사용
}