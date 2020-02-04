package bruhu.contentproviderexample.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getContacts()
    }

    /*Add permission to access contacts manually and filter getContacts in the Logcat to see the result*/

    fun getContacts(){
        // mutable list to add the contact name
        val Contacts : MutableList<String> = ArrayList()
        // this will keep the data that we will later request
        // CONTENT_URI has the URI to access the contacts
        val cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null)
        // check if cursor is not null and if so, point to the first item
        if(cursor != null && cursor.moveToFirst()){
            // use do while looping the cursor until it has next value, so we can read all the values from the cursor
            do {
                // using cursor trying to get the name - we use getColumnIndex since we don't know the index number
                val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                // Logging the name value
                Log.d("getContacts", "Name: " + name)
                // add contact name to the list
                Contacts.add(name)
            }while(cursor.moveToNext())
            println(cursor)
            cursor.close()
        }
        autocomplete
    }
}
