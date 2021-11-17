package yayasan.idn.newsapp.packages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import yayasan.idn.newsapp.DataNews
import yayasan.idn.newsapp.NewsAdapter
import yayasan.idn.newsapp.R
import yayasan.idn.newsapp.bindNewsHeadline
import yayasan.idn.newsapp.databinding.FragmentAllNewsBinding

class AllNewsFragment : Fragment() {

    private var _binding: FragmentAllNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAllNewsBinding.inflate(inflater, container, false)

        binding.rvAllNews.apply {
            adapter = NewsAdapter(DataNews.dataAllNews)
            layoutManager = LinearLayoutManager(activity)

        }

        bindNewsHeadline(binding.newsHeadline,0)
        return binding.root
    }
}