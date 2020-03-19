package com.example.profilfakultas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.profilfakultas.R
import kotlinx.android.synthetic.main.activity_fak_detail.*

class FakDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fak_detail)

        var intentThatStartedThisActivity = getIntent()


        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            var partNama = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var partDesc = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)
            var partFoto = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER).toInt()
            namaFak2.text = partNama
            descFak2.text = partDesc
            fotoUPN2.setImageResource(partFoto)
        }
    }
}