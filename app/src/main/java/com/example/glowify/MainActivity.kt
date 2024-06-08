package com.example.glowify

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call function to show instructions popup when the activity starts
        showInstructionsPopup()

        // Get reference to the "Let's Get Started" button
        val myButton = findViewById<Button>(R.id.myButton)

        // Set click listener for the "Let's Get Started" button to show the skin type and gender input popup
        myButton.setOnClickListener {
            showSkinTypeAndGenderPopup()
        }
    }

    private fun showInstructionsPopup() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogView = inflater.inflate(R.layout.popup_instructions, null)
        dialogBuilder.setView(dialogView)

        // Add any additional customization to the dialog here, such as setting title, buttons, etc.
        val alertDialog = dialogBuilder.create()
        alertDialog.setCancelable(false) // Prevent dismissing dialog by tapping outside

        // Get reference to the "OK" button
        val btnOk = dialogView.findViewById<Button>(R.id.btnOk)

        // Set click listener for the "OK" button to dismiss the dialog
        btnOk.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun showSkinTypeAndGenderPopup() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogView = inflater.inflate(R.layout.popup_skin_gender, null)
        dialogBuilder.setView(dialogView)

        val alertDialog = dialogBuilder.create()
        alertDialog.setCancelable(false) // Prevent dismissing dialog by tapping outside

        // Get references to the skin type and gender EditText fields
        val etSkinType = dialogView.findViewById<EditText>(R.id.etSkinType)
        val etGender = dialogView.findViewById<EditText>(R.id.etGender)

        // Get reference to the "OK" button in the popup modal
        val btnOk = dialogView.findViewById<Button>(R.id.btnOk)

        // Set click listener for the "OK" button to handle navigation to the next activity
        btnOk.setOnClickListener {
            // Retrieve the entered skin type and gender values
            val skinType = etSkinType.text.toString()
            val gender = etGender.text.toString()

            val intent = Intent(this, NextActivity::class.java).apply {
                putExtra("skinType", skinType)
                putExtra("gender", gender)
            }
            startActivity(intent)

            // Dismiss the current dialog
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}
