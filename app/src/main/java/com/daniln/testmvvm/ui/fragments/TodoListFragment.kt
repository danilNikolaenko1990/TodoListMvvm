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
import com.daniln.testmvvm.ui.viewModels.ListItemViewModel
import com.daniln.testmvvm.ui.viewModels.ListItemViewModelFactory
import com.daniln.testmvvm.ui.adapters.ItemsAdapter
import com.google.android.material.snackbar.Snackbar
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

        createButton.setOnClickListener {
            val text = TextEdit_item.text.toString()
            if (text.isEmpty()) {
                printMessage(R.string.cannot_add_value)
            } else {
                listItemViewModel.add(text)
                TextEdit_item.setText("")
                printMessage(R.string.value_added)
            }
        }

        deleteAllButton.setOnClickListener {
            listItemViewModel.removeAll()
            printMessage(R.string.list_was_cleared)
        }

        super.onActivityCreated(savedInstanceState)
    }

    private fun printMessage(errorText: Int) {
        Snackbar.make(todoList_fragment, errorText, Snackbar.LENGTH_LONG).show();
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
