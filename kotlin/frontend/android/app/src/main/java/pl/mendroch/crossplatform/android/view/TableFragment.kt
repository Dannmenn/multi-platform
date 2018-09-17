package pl.mendroch.crossplatform.android.view


import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_table.*
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.android.Main
import pl.mendroch.crossplatform.android.R
import pl.mendroch.crossplatform.common.model.TableObject
import pl.mendroch.crossplatform.respositories.TableDataProvider
import pl.mendroch.crossplatform.utils.HttpUtil
import pl.mendroch.crossplatform.view.table.TableView

class TableFragment : Fragment() {
    private val items: ObservableList<TableObject> = ObservableArrayList<TableObject>()
    private val tableView = TableView(Dispatchers.Main, TableDataProvider(HttpUtil.HTTP_UTIL), this::updateUI)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_table, container, false)

        if (view is ViewPager) {
            with(view) {
                adapter = TableFragmentAdapter(childFragmentManager, items)
            }
        }
        tableView.onCreate()
        return view
    }

    private fun updateUI(values: Array<TableObject>) {
        items.clear()
        items.addAll(values)
        viewPager.adapter?.notifyDataSetChanged()
    }

    override fun onDetach() {
        super.onDetach()
        tableView.preDestroy()
    }
}
