package yayasan.idn.newsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import yayasan.idn.newsapp.databinding.RowItemNewsBinding

class NewsAdapter(private val listNews: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RowItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun bindItem(news:News){
                binding.tvCategory.text = news.category
                binding.tvTitle.text = news.title
                binding.tvDate.text = news.date
                binding.tvTime.text = news.time
                binding.imgNews.setImageResource(news.photo)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(listNews[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,DetailActivity::class.java)
            intent.putExtra(DetailActivity.NEWS_DATA,listNews[position])
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listNews.size
}