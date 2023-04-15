package com.example.salarymanagementsystem

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity12 : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

        bottomNavigationView = findViewById(R.id.bottomNav)
        val simpleRatingBar = findViewById<RatingBar>(R.id.simpleRatingBar)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val tv=findViewById<TextView>(R.id.textView)
        val feedback = findViewById<EditText>(R.id.feedback)

        val getBottomNav =  MainActivity2()
        getBottomNav.bottomNavigation(bottomNavigationView)

        submitButton.setOnClickListener {
            val totalStars = "Total Stars: " + simpleRatingBar.numStars
            val rating = "Rating: " + simpleRatingBar.rating
            val fb = feedback.text.toString()
            var toast = Toast.makeText(
                this, """ $totalStars | $rating  | $fb""".trimIndent(),
                Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP,1200,1200)
            toast.show()

            feedback.setText("")
            tv.setText("$rating \nWe really appreciate you taking the time to share your rating \nwith us.")
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menurate, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {


            R.id.git -> {
                Toast.makeText(this, "Opening Source Code", Toast.LENGTH_SHORT).show()
                var url = "https://github.com/abhikritimoti/Salary-Management-System.git"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setDataAndType(Uri.parse(url), "text/plain")
                val choose = Intent.createChooser(intent, "Share URL")
                startActivity(choose)
                return true
            }
            R.id.back -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return true
    }
}