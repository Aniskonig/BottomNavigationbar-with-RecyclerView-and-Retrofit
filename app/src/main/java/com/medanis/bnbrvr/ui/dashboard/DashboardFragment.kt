package com.medanis.bnbrvr.ui.dashboard;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medanis.bnbrvr.R
import com.medanis.bnbrvr.adapters.StoresAdapter
import com.medanis.bnbrvr.others.dismissProgressBar
import com.medanis.bnbrvr.others.showProgressBar

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val progressBar = root.findViewById<ProgressBar>(R.id.progressBar)
        showProgressBar(progressBar)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        dashboardViewModel.data.observe(viewLifecycleOwner, Observer {
            val myRV = root.findViewById<RecyclerView>(R.id.storesRV)
            val myOptionsAdapter = StoresAdapter(context, it)
            myRV!!.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//            ViewCompat.setNestedScrollingEnabled(myRV, true)
//            myRV.scrollBarSize = 20
//            myRV.isVerticalScrollBarEnabled = true
//            myRV.isScrollContainer = true
            myRV.adapter = myOptionsAdapter
            dismissProgressBar(progressBar)
        })
        return root
    }
}