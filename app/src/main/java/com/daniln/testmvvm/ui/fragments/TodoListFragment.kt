package com.daniln.testmvvm.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.daniln.testmvvm.AndroidApplication
import com.daniln.testmvvm.R
import com.daniln.testmvvm.ui.ListItemViewModel
import com.daniln.testmvvm.ui.ListItemViewModelFactory
import com.daniln.testmvvm.ui.adapters.ItemsAdapter
import kotlinx.android.synthetic.main.fragment_todo_list.*
import javax.inject.Inject

class TodoListFragment : Fragment() {
    private lateinit var listItemViewModel: ListItemViewModel

    @Inject
    lateinit var viewModelFactory: ListItemViewModelFactory;

    private var mItemsAdapter: ItemsAdapter = ItemsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity?.application as AndroidApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        listItemViewModel =
            ViewModelProvider(this, viewModelFactory).get(ListItemViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerViewList()

        listItemViewModel.items.observe(viewLifecycleOwner, Observer {
            mItemsAdapter.setup(it)
        })

        textButton.setOnClickListener {
            listItemViewModel.add(TextEdit_item.text.toString())
        }

        super.onActivityCreated(savedInstanceState)
    }

    @SuppressLint("WrongConstant")
    private fun initRecyclerViewList() {
        rvItems.layoutManager =
            LinearLayoutManager(activity?.applicationContext, OrientationHelper.VERTICAL, false)
        rvItems.adapter = mItemsAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    companion object {
        fun newInstance(): TodoListFragment {
            return TodoListFragment()
        }
    }
}
