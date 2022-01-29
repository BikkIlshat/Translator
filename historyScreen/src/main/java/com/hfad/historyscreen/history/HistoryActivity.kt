package com.hfad.historyscreen.history

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hfad.core.BaseActivity
import com.hfad.historyscreen.R
import com.hfad.historyscreen.databinding.ActivityHistoryBinding
import com.hfad.model.data.AppState
import com.hfad.model.data.userdata.DataModel
import org.koin.android.scope.getOrCreateScope
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.inject
import org.koin.core.scope.Scope


class HistoryActivity : BaseActivity<AppState, HistoryInteractor>(), KoinScopeComponent {
    override val scope: Scope by getOrCreateScope()
    private val binding: ActivityHistoryBinding by viewBinding()
    override lateinit var model: HistoryViewModel
    private val adapter: HistoryAdapter by lazy { HistoryAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        iniViewModel()
        initViews()
    }

    override fun onResume() {
        super.onResume()
        model.getData("", false)
    }

    override fun setDataToAdapter(data: List<DataModel>) {
        adapter.setData(data)
    }

    private fun iniViewModel() {
        if (binding.historyActivityRecyclerview.adapter != null) {
            throw IllegalStateException("The ViewModel should be initialised first")
        }
        val viewModel: HistoryViewModel by inject()
        model = viewModel
        model.subscribe().observe(this@HistoryActivity, { renderData(it) })
    }

    private fun initViews() {
        binding.historyActivityRecyclerview.adapter = adapter
    }
}
