package hr.milinko.firebasemilinko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import hr.milinko.firebasemilinko.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val DataBase: DatabaseReference= FirebaseDatabase.getInstance("https://pmumilinko-default-rtdb.europe-west1.firebasedatabase.app/").getReference("teskt")
    val text = ArrayList<Tekst>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DataBase.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
               
                try
                {
                    val a: List<Tekst> = snapshot.children.map{datasnapshot->datasnapshot.getValue(Tekst:: class.java)!!}
                    text.addAll(a)
                }
                catch(_:Exception)
                {
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}