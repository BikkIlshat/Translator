package com.hfad.translator.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hfad.translator.databinding.SearchDialogFragmentBinding

class SearchDialogFragment : BottomSheetDialogFragment() {

    private val viewBinding: SearchDialogFragmentBinding by viewBinding(CreateMethod.INFLATE)

    private var onSearchClickListener: OnSearchClickListener? = null

    private val textWatcher = object : TextWatcher {

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) = with(viewBinding) {
            if (searchEditText.text != null && !searchEditText.text.toString().isEmpty()
            ) {
                searchButtonTextview.isEnabled = true
                clearTextImageview.visibility = View.VISIBLE
            } else {
                searchButtonTextview.isEnabled = false
                clearTextImageview.visibility = View.GONE
            }
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun afterTextChanged(s: Editable) {}
    }


    private val onSearchButtonClickListener =
        View.OnClickListener {
            with(viewBinding) {
                onSearchClickListener?.onClick(searchEditText.text.toString())
                dismiss()
            }

        }

    internal fun setOnSearchClickListener(listener: OnSearchClickListener) {
        onSearchClickListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding){
            searchButtonTextview.setOnClickListener(onSearchButtonClickListener)
            searchEditText.addTextChangedListener(textWatcher)
        }

        addOnClearClickListener()
    }

    override fun onDestroyView() {
        onSearchClickListener = null
        super.onDestroyView()
    }

    private fun addOnClearClickListener() = with(viewBinding) {
        clearTextImageview.setOnClickListener {
            searchEditText.setText("")
            searchButtonTextview.isEnabled = false
        }
    }

    interface OnSearchClickListener {

        fun onClick(searchWord: String)
    }

    companion object {
        fun newInstance(): SearchDialogFragment {
            return SearchDialogFragment()
        }
    }
}