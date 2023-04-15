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

class MainActivity12 : AppCompatActivity() {
    private lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

        val simpleRatingBar = findViewById<RatingBar>(R.id.simpleRatingBar)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val tv=findViewById<TextView>(R.id.textView)
        val feedback = findViewById<EditText>(R.id.feedback)

        bottomNav = findViewById(R.id.bottomNav)
        title = "Rating"

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {

                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                    true
                }
                R.id.rate -> {
                    val intent = Intent(this, MainActivity12::class.java)
                    startActivity(intent)
                    true
                }
                R.id.git -> {
                    var url = "https://github.com/abhikritimoti/Salary-Management-System.git"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setDataAndType(Uri.parse(url), "text/plain")
                    val choose = Intent.createChooser(intent, "Share URL")
                    startActivity(choose)
                    true
                }
                R.id.exit -> {
                    val builder = androidx.appcompat.app.AlertDialog.Builder(this)
                    builder.setTitle("Exit Alert")
                        .setMessage("Are you sure, you want to exit ?")
                        .setCancelable(true)
                        .setIcon(android.R.drawable.ic_dialog_alert)

                    builder.setPositiveButton("Yes") { dialogInterface, which ->
                        finishAffinity()
                    }

                    builder.setNegativeButton("No") { dialogInterface, which ->
                        Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_SHORT).show()
                    }

                    val alertDialog: androidx.appcompat.app.AlertDialog = builder.create()
                    alertDialog.show()

                    true
                }
                else -> true

            }
        }

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
            tv.setText("$rating \nWe really appreciate you taking time to share your rating with us.")
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
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                return true
            }
        }
        return true
    }
}