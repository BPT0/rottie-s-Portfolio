package com.example.velog.motion

import android.util.Log
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.velog.R
import com.example.velog.databinding.ItemLoadingBinding
import com.example.velog.databinding.ItemVideoBinding
import com.example.velog.motion.video.Video
import kotlin.collections.ArrayList

class VideoAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items = ArrayList<Video>()
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1

    // 익명 리스너 객체 생성
    val selectionList = mutableListOf<Long>()
    val onItemClickListener : ((MutableList<Long>) -> Unit)?= null

    // 아이템뷰에 동영상이 들어가는 경우
    inner class ItemViewHolder(private val binding: ItemVideoBinding):
        RecyclerView.ViewHolder(binding.root){
        val btn_video = itemView.findViewById<Button>(R.id.btn_video)
        fun bind(item: Video){
            binding.apply {
                // 데이터 설정

                // 영상 업로드한 사람 프로필 설정필요
                Glide.with(itemView)
                    .load(item.thumbnailUrl)
                    .fitCenter()
                    .into(ivVideoSumnail)

                tvVideoTime.text ="22:29"
            }
        }
    }

    // setting Data fun s
    private fun getHits(hit: Int): Int{
        if (hit>=10000){
            return (hit/10000)*10000
        }else if(hit>=1000){
            return (hit/1000)*1000
        }else{
            return hit
        }
    }

    // 아이템뷰에 프로그레스바가 들어가는 경우
    inner class LoadingViewHolder(private val binding: ItemLoadingBinding) :
        RecyclerView.ViewHolder(binding.root){}

    // 뷰타입을 정해줌
    override fun getItemViewType(position: Int): Int {
        // 게시물과 프롤그래스바 아이템뷰를 구분할 기준 필요
        return when(items[position].title){
            " " -> VIEW_TYPE_LOADING
            else -> VIEW_TYPE_ITEM
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        return when(viewType){
            VIEW_TYPE_ITEM -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val ibinding = ItemVideoBinding.inflate(layoutInflater, parent, false)
                // 익명 리스너 객체 생성
                ibinding.root.setOnClickListener(object : View.OnClickListener{
                    override fun onClick(v: View?) {
                        val id = v?.tag
                        if(selectionList.contains(id)) selectionList.remove(id)
                        else selectionList.add(id as Long)
                        notifyDataSetChanged()
                        onItemClickListener?.let{it(selectionList)}
                    }
                })
                ItemViewHolder(ibinding)
            }
            else-> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemLoadingBinding.inflate(layoutInflater, parent, false)
                LoadingViewHolder(binding)
            }
        }
    }

    fun setList(videoes: MutableList<Video>) {
        items.addAll(videoes)
        // Add empty obbject
        items.add(Video(0, " ", "", "", "", "", R.drawable.android_picture, "", 0 ))
    }

    fun deleteLoading(videoes: MutableList<Video>){
        if(videoes.isNotEmpty()) items.removeAt(items.lastIndex) // 로딩이 완료되면 프로그레스바를 지움
    }

    fun reverseData(){
        items.reverse()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder){
            val item = items[position]
            //holder.bind(item)
            holder.apply {
                bind(item)
                itemView.apply {
                    // 아이템마다 익명리스너 대입
                    tag = getItemId(position)
                    isActivated = selectionList.contains(getItemId(position))

                    // 클릭시
                    // 1. 동영상 영역 전체
                    btn_video.setOnClickListener(object : View.OnClickListener{
                        override fun onClick(p0: View?) {
                            Log.v("클릭", "아이템뷰 전체")

                        }
                    })

                }
            }
        }
        else{

        }

    }
}