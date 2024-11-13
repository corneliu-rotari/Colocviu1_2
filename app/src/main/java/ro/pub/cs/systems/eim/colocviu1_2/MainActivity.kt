package ro.pub.cs.systems.eim.colocviu1_2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import ro.pub.cs.systems.eim.colocviu1_2.R.id.add
import ro.pub.cs.systems.eim.colocviu1_2.R.id.compute
import ro.pub.cs.systems.eim.colocviu1_2.R.id.nextTerm
import ro.pub.cs.systems.eim.colocviu1_2.R.id.allTerms

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val compute : Button = findViewById(compute);
        val add : Button= findViewById(add);
        val nextTerm: EditText = findViewById(nextTerm);
        val allTerms: TextView = findViewById(allTerms);

        var added : String = "";

        add.setOnClickListener {
            val readed : String = nextTerm.text.toString();
            if (readed.toIntOrNull() != null) {
                if (added == "") {
                    allTerms.text = added.plus(readed);
                }
                else {
                    allTerms.text = added.plus(" + ".plus(readed));
                }
                added = allTerms.text.toString();
            }
        }

        compute.setOnClickListener {
            val intent = Intent(this, Colocviu1_2SecondaryActivity::class.java)
            intent.putExtra("sum", added)
            startActivity(intent)        }

    }
}