package com.example.glowify

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import android.app.AlertDialog
import android.view.LayoutInflater
import android.widget.Button

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        // Set up the toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Enable the back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Retrieve skin type and gender from intent extras
        val skinType = intent.getStringExtra("skinType")
        val gender = intent.getStringExtra("gender")

        // Show user details popup
        showUserDetailsPopup(skinType, gender)

        // Set click listener for the first skin care option (Dull Skin)
        val dullSkinCardView = findViewById<CardView>(R.id.dullSkinCardView)
        dullSkinCardView.setOnClickListener {
            // Navigate to the DullSkinActivity
            val intent = Intent(this, DullSkinActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for the second skin care option (Dry Skin)
        val drySkinCardView = findViewById<CardView>(R.id.drySkinCardView)
        drySkinCardView.setOnClickListener {
            // Navigate to the DrySkinActivity
            val intent = Intent(this, DrySkinActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for the third skin care option (Oily Skin)
        val oilySkinCardView = findViewById<CardView>(R.id.oilySkinCardView)
        oilySkinCardView.setOnClickListener {
            // Navigate to the OilySkinActivity
            val intent = Intent(this, OilySkinActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for the fourth skin care option (Sensitive Skin)
        val sensitiveSkinCardView = findViewById<CardView>(R.id.sensitiveSkinCardView)
        sensitiveSkinCardView.setOnClickListener {
            // Navigate to the SensitiveSkinActivity
            val intent = Intent(this, SensitiveSkinActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for the fifth skin care option (Combination Skin)
        val combinationSkinCardView = findViewById<CardView>(R.id.combinationSkinCardView)
        combinationSkinCardView.setOnClickListener {
            // Navigate to the CombinationSkinActivity
            val intent = Intent(this, CombinationSkinActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for the sixth skin care option (Normal Skin)
        val normalSkinCardView = findViewById<CardView>(R.id.normalSkinCardView)
        normalSkinCardView.setOnClickListener {
            // Navigate to the NormalSkinActivity
            val intent = Intent(this, NormalSkinActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for the seventh skin care option (Sun Damaged Skin)
        val sunDamagedSkinCardView = findViewById<CardView>(R.id.sunDamagedSkinCardView)
        sunDamagedSkinCardView.setOnClickListener {
            // Navigate to the com.example.glowify.SunDamagedSkinActivity
            val intent = Intent(this, SunDamagedSkinActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for the eighth skin care option (Acne Prone Skin)
        val acneProneSkinCardView = findViewById<CardView>(R.id.acneProneSkinCardView)
        acneProneSkinCardView.setOnClickListener {
            // Navigate to the AcneProneSkinActivity
            val intent = Intent(this, AcneProneSkinActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showUserDetailsPopup(skinType: String?, gender: String?) {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogView = inflater.inflate(R.layout.popup_user_details, null)
        dialogBuilder.setView(dialogView)

        val alertDialog = dialogBuilder.create()
        alertDialog.setCancelable(false) // Prevent dismissing dialog by tapping outside

        // Get reference to TextViews for displaying user details
        val tvSkinType = dialogView.findViewById<TextView>(R.id.tvSkinType)
        val tvGender = dialogView.findViewById<TextView>(R.id.tvGender)

        // Set skin type and gender details
        tvSkinType.text = "Skin Type: $skinType"
        tvGender.text = "Gender: $gender"

        // Get reference to the "OK" button in the popup modal
        val btnOk = dialogView.findViewById<Button>(R.id.btnOk)

        // Set click listener for the "OK" button to dismiss the dialog
        btnOk.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}
