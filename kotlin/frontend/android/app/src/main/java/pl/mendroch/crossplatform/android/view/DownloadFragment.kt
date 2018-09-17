package pl.mendroch.crossplatform.android.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_download.view.*
import pl.mendroch.crossplatform.android.R
import pl.mendroch.crossplatform.common.Endpoints
import pl.mendroch.crossplatform.utils.HttpUtil

class DownloadFragment : Fragment() {
    private val url = HttpUtil.HTTP_UTIL.baseUrl + Endpoints.api + Endpoints.files

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_download, container, false)
        view.smallFile.setOnClickListener {
            openFile(Endpoints.small)
        }
        view.bigFile.setOnClickListener {
            openFile(Endpoints.big)
        }
        return view
    }

    private fun openFile(endpoint: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            //"application/vnd.ms-excel"
            intent.setDataAndType(Uri.parse(url + endpoint), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
        }
    }
}
