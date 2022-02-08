package com.hfad.translator.view.descriptionscreen

import android.content.Context
import android.content.Intent
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.ImageLoader
import coil.request.LoadRequest
import com.hfad.translator.R
import com.hfad.translator.databinding.ActivityDescriptionBinding
import com.hfad.utils.netwok.OnlineLiveData
import com.hfad.utils.ui.AlertDialogFragment

class DescriptionActivity : AppCompatActivity() {

    private  val viewBinding: ActivityDescriptionBinding by viewBinding()

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        setActionbarHomeButtonAsUp()

        viewBinding.descriptionScreenSwipeRefreshLayout.setOnRefreshListener { startLoadingOrShowError() }
        setData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setActionbarHomeButtonAsUp() {
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun setData() = with(viewBinding) {
        val bundle = intent.extras
        descriptionHeader.text = bundle?.getString(WORD_EXTRA)
        descriptionTextview.text = bundle?.getString(DESCRIPTION_EXTRA)
        val imageLink = bundle?.getString(URL_EXTRA)
        if (imageLink.isNullOrBlank()) {
            stopRefreshAnimationIfNeeded()
        } else {
            useCoilToLoadPhoto(descriptionImageview, imageLink)

        }
    }

    @RequiresApi(31)
    private fun startLoadingOrShowError() {
        OnlineLiveData(this).observe(
            this@DescriptionActivity
        ) {
            if (it) {
                setData()
            } else {
                AlertDialogFragment.newInstance(
                    getString(R.string.dialog_title_device_is_offline),
                    getString(R.string.dialog_message_device_is_offline)
                ).show(
                    supportFragmentManager,
                    DIALOG_FRAGMENT_TAG
                )
                stopRefreshAnimationIfNeeded()
            }
        }
    }


    private fun stopRefreshAnimationIfNeeded() = with(viewBinding) {
        if (descriptionScreenSwipeRefreshLayout.isRefreshing) {
            descriptionScreenSwipeRefreshLayout.isRefreshing = false
        }
    }


    @RequiresApi(31)
    private fun useCoilToLoadPhoto(imageView: ImageView, imageLink: String) {
        val request = LoadRequest.Builder(this)
            .data("https:$imageLink")
            .target(
                onStart = {},
                onSuccess = { result ->
                    imageView.setImageDrawable(result)
                    val blurEffect = RenderEffect.createBlurEffect(15f, 0f, Shader.TileMode.MIRROR)
                    imageView.setRenderEffect(blurEffect)
                },
                onError = {
                    imageView.setImageResource(R.drawable.ic_no_photo_vector)
                }
            )
            .build()

        ImageLoader(this).execute(request)
    }



    companion object {
        private const val DIALOG_FRAGMENT_TAG = "8c7dff51-9769-4f6d-bbee-a3896085e76e"
        private const val WORD_EXTRA = "f76a288a-5dcc-43f1-ba89-7fe1d53f63b0"
        private const val DESCRIPTION_EXTRA = "0eeb92aa-520b-4fd1-bb4b-027fbf963d9a"
        private const val URL_EXTRA = "6e4b154d-e01f-4953-a404-639fb3bf7281"

        fun getIntent(
            context: Context,
            word: String,
            description: String,
            url: String?
        ): Intent = Intent(context, DescriptionActivity::class.java).apply {
            putExtra(WORD_EXTRA, word)
            putExtra(DESCRIPTION_EXTRA, description)
            putExtra(URL_EXTRA, url)
        }
    }
}
