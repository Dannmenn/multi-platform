package pl.mendroch.crossplatform.android

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_view.*
import pl.mendroch.crossplatform.android.view.DownloadFragment
import pl.mendroch.crossplatform.android.view.ListObjectActivity
import pl.mendroch.crossplatform.android.view.ListObjectFragment
import pl.mendroch.crossplatform.android.view.TableFragment
import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.utils.HttpUtil

class MainViewActivity : AppCompatActivity(), ListObjectFragment.OnListFragmentInteractionListener {
    init {
        HttpUtil.HTTP_UTIL.baseUrl = "http://10.0.2.2:8080"
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                addFragment(ListObjectFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                addFragment(TableFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                addFragment(DownloadFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)

        addFragment(ListObjectFragment())

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.content, fragment, fragment.javaClass.simpleName)
                .addToBackStack(fragment.javaClass.simpleName)
                .commit()
    }

    override fun onListFragmentInteraction(item: ListObject?) {
        item?.let {
            val intent = ListObjectActivity.newIntent(this, it._id)
            startActivity(intent)
        }
    }
}
