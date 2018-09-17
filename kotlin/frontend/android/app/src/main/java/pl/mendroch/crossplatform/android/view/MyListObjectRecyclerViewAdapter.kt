package pl.mendroch.crossplatform.android.view


import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_listobject.view.*
import pl.mendroch.crossplatform.android.R
import pl.mendroch.crossplatform.android.view.ListObjectFragment.OnListFragmentInteractionListener
import pl.mendroch.crossplatform.common.model.ListObject

class MyListObjectRecyclerViewAdapter(
        private val mValues: ObservableList<ListObject>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyListObjectRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as ListObject
            mListener?.onListFragmentInteraction(item)
        }
        mValues.addOnListChangedCallback(ListListener())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_listobject, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item._id
        holder.mContentView.text = item.name

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }

    inner class ListListener : ObservableList.OnListChangedCallback<ObservableList<ListObject>>() {
        override fun onChanged(sender: ObservableList<ListObject>?) {
            notifyDataSetChanged()
        }

        override fun onItemRangeRemoved(sender: ObservableList<ListObject>?, positionStart: Int, itemCount: Int) {
            notifyItemRangeRemoved(positionStart, itemCount)
        }

        override fun onItemRangeMoved(sender: ObservableList<ListObject>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
            notifyItemMoved(fromPosition, toPosition)
        }

        override fun onItemRangeInserted(sender: ObservableList<ListObject>?, positionStart: Int, itemCount: Int) {
            notifyItemRangeInserted(positionStart, itemCount)
        }

        override fun onItemRangeChanged(sender: ObservableList<ListObject>?, positionStart: Int, itemCount: Int) {
            notifyItemRangeChanged(positionStart, itemCount)
        }
    }
}
