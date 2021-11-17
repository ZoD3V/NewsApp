package yayasan.idn.newsapp.packages

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionPagerAdapter(fa:FragmentActivity):FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> AllNewsFragment()
            1 -> TopFragment()
            2 -> Popular()
            else -> TopFragment()
        }
    }

}