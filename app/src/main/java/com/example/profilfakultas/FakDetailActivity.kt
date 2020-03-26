package com.example.profilfakultas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.profilfakultas.R
import kotlinx.android.synthetic.main.activity_fak_detail.*
import java.lang.Exception

class FakDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fak_detail)

        var intentThatStartedThisActivity = getIntent()


        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            var partNama = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var partDesc = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)
            var partFoto = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER).toInt()
            var partEmail = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_SPLIT_NAME)
            var partWeb = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_COMPONENT_NAME)
            namaFak2.text = partNama
            descFak2.text = partDesc
            fotoUPN2.setImageResource(partFoto)

            sendEmail.setOnClickListener{
                sendMail(partEmail)
            }

            visitWeb.setOnClickListener{
                openWeb(partWeb)
            }

        }

    }

    private fun sendMail(pengirim:String){
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_SPLIT_NAME, arrayOf(pengirim))

        try {
            startActivity(Intent.createChooser(mIntent, "Kirim Email"))
        }catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }

    private fun openWeb(url: String) {
        val showWebActivity = Intent(this, FakWeb::class.java)
        showWebActivity.putExtra(Intent.ACTION_VIEW, url)
        startActivity(showWebActivity)
    }

}