package pl.mendroch.crossplatform.android.view

import android.content.Context
import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.android.Main
import pl.mendroch.crossplatform.android.R
import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.respositories.ListDataProvider
import pl.mendroch.crossplatform.utils.HttpUtil
import pl.mendroch.crossplatform.view.list.ListView

class ListObjectFragment : Fragment() {
    private var listener: OnListFragmentInteractionListener? = null
    private var values = ObservableArrayList<ListObject>()
    private val listView = ListView(Dispatchers.Main, ListDataProvider(HttpUtil.HTTP_UTIL), this::updateUI)

    private fun updateUI(listObjects: Array<ListObject>) {
        values.clear()
        values.addAll(listObjects)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_listobject_list, container, false)
        listView.onCreate()

        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = MyListObjectRecyclerViewAdapter(values, listener)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
        listView.preDestroy()
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: ListObject?)
    }
}
