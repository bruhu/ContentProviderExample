package bruhu.contentproviderexample.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getContacts(){
        // this will keep the data that we will later request
        // CONTENT_URI has the URI to access the contacts
        val cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null)
    }
}
