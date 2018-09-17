package pl.mendroch.crossplatform.android.view

import android.databinding.ObservableList
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import pl.mendroch.crossplatform.common.model.TableObject

class TableFragmentAdapter(fragmentManager: FragmentManager, private val items: ObservableList<TableObject>)
    : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(index: Int): Fragment = TableObjectFragment.newInstance(items[index])

    override fun getCount(): Int = items.size
}