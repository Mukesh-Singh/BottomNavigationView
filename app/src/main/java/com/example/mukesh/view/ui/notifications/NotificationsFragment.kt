package com.example.mukesh.view.ui.notifications

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mukesh.R
import com.example.mukesh.view.ui.main.MainSharedViewModel
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var mainSharedViewModel: MainSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainSharedViewModel=ViewModelProviders.of(requireActivity()).get(MainSharedViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        mainSharedViewModel.getDashboardTestSharedString().observe(this, Observer { sring ->
            textView.text=sring
        })
        val change_mode:Button=root.findViewById(R.id.change_mode)
        val mode1=AppCompatDelegate.getDefaultNightMode()
//        if (mode==AppCompatDelegate.MODE_NIGHT_NO || mode==AppCompatDelegate.MODE_NIGHT_UNSPECIFIED){
//            change_mode.text="Switch to dark mode"
//        }
//        else{
//            change_mode.text="Switch to light mode"
//        }
        change_mode.text="Switch Dark Mode"

        Log.i("NotificationsFragment","Current mode-: $mode1")

        change_mode.setOnClickListener {
            val mode=AppCompatDelegate.getDefaultNightMode()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                if (mode==AppCompatDelegate.MODE_NIGHT_NO || mode==AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
            else{
                if (mode==AppCompatDelegate.MODE_NIGHT_NO){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }

        }

        return root
    }
}