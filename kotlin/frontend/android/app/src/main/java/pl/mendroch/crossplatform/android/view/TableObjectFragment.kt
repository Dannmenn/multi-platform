package pl.mendroch.crossplatform.android.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_table_object.view.*
import kotlinx.serialization.json.JSON
import pl.mendroch.crossplatform.android.R
import pl.mendroch.crossplatform.common.model.TableObject

class TableObjectFragment : Fragment() {
    private lateinit var tableObject: TableObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tableObject = JSON().parse(it.getString(TABLE_OBJECT)!!)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_table_object, container, false)
        updateUI(view, tableObject)
        return view
    }

    private fun updateUI(view: View, tableObject: TableObject) {
        view.balance.text = tableObject.balance
        view.age.text = tableObject.age.toString()
        view.name.text = tableObject.name
        view.company.text = tableObject.company
        view.email.text = tableObject.email
        view.phone.text = "phone: ${tableObject.phone}"
        view.address.text = "address: ${tableObject.address}"
        view.date.text = tableObject.registered.toDateFormatString()
        view.latitude.text = tableObject.latitude.toString()
        view.longitude.text = tableObject.longitude.toString()
        view.tags.text = tableObject.tags.joinToString(", ")
        view.about.text = tableObject.about
    }

    companion object {
        private const val TABLE_OBJECT = "tableObject"

        @JvmStatic
        fun newInstance(tableObject: TableObject) =
                TableObjectFragment().apply {
                    arguments = Bundle().apply {
                        putString(TABLE_OBJECT, JSON().stringify(tableObject))
                    }
                }
    }
}
