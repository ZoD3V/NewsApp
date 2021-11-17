package yayasan.idn.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import yayasan.idn.newsapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val NEWS_DATA = "data"
        const val EXTRA_IMG_HEADLINE = "image"
        const val EXTRA_TITLE_HEADLINE = "title"
        const val EXTRA_CONTENT_HEADLINE = "desc"
        const val EXTRA_DATE_HEADLINE = "date"
        const val EXTRA_AUTHOR_HEADLINE = "author"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "News Detail"
        }

        val news = intent.getParcelableExtra<News>(NEWS_DATA)

        val photoHeadLine = intent.getIntExtra(EXTRA_IMG_HEADLINE,0)
        val titleHeadLine = intent.getStringExtra(EXTRA_TITLE_HEADLINE)
        val contentHeadLine = intent.getStringExtra(EXTRA_CONTENT_HEADLINE)
        val dateHeadLine = intent.getStringExtra(EXTRA_DATE_HEADLINE)
        val authorHeadLine = intent.getStringExtra(EXTRA_AUTHOR_HEADLINE)

        binding.imgNewsDetail.setImageResource(photoHeadLine)
        binding.tvTitleDetail.text = titleHeadLine
        binding.tvContentDetail.text = contentHeadLine
        binding.tvDateDetail.text = dateHeadLine
        binding.tvAuthorDetail.text = authorHeadLine

        if (news != null) {
            binding.tvTitleDetail.text = news.title
            binding.tvDateDetail.text = news.date
            binding.tvAuthorDetail.text = news.author
            binding.tvContentDetail.text = news.content
            binding.imgNewsDetail.setImageResource(news.photo)
        } else {
            binding.imgNewsDetail.setImageResource(intent.getIntExtra(EXTRA_IMG_HEADLINE, 0))
            binding.tvTitleDetail.text = intent.getStringExtra(EXTRA_TITLE_HEADLINE)
            binding.tvDateDetail.text = intent.getStringExtra(EXTRA_DATE_HEADLINE)
            binding.tvAuthorDetail.text = intent.getStringExtra(EXTRA_AUTHOR_HEADLINE)
            binding.tvContentDetail.text = intent.getStringExtra(EXTRA_CONTENT_HEADLINE)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}