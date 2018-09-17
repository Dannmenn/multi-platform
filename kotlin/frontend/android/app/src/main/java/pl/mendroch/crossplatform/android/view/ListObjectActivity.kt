package pl.mendroch.crossplatform.android.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_object_activiti.*
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.android.Main
import pl.mendroch.crossplatform.android.R
import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.respositories.ListDataProvider
import pl.mendroch.crossplatform.utils.HttpUtil
import pl.mendroch.crossplatform.view.list.ListObjectView

class ListObjectActivity : AppCompatActivity() {
    private lateinit var listView: ListObjectView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_object_activiti)

        listView = ListObjectView(Dispatchers.Main, intent.getStringExtra(INTENT_OBJECT_ID), ListDataProvider(HttpUtil.HTTP_UTIL), this::updateUI)
        listView.onCreate()
    }

    private fun updateUI(listObject: ListObject) {
        _id.text = listObject._id
        index.text = listObject.index.toString()
        isActive.text = if (listObject.isActive) "active" else "inactive"
        balance.text = listObject.balance
        age.text = listObject.age.toString()
        eyeColor.text = listObject.eyeColor
        name.text = listObject.name
        company.text = listObject.company
        email.text = listObject.email
        phone.text = listObject.phone
        address.text = listObject.address
        date.text = listObject.registered.toDateFormatString()
        latitude.text = listObject.latitude.toString()
        longitude.text = listObject.longitude.toString()
        tags.text = listObject.tags.joinToString(", ")
        about.text = listObject.about
    }

    override fun onDestroy() {
        super.onDestroy()
        listView.preDestroy()
    }

    companion object {
        private const val INTENT_OBJECT_ID = "list_object_id"

        fun newIntent(context: Context, id: String): Intent {
            val intent = Intent(context, ListObjectActivity::class.java)
            intent.putExtra(INTENT_OBJECT_ID, id)
            return intent
        }
    }
}
