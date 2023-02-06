package fingerfire.com.overwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fingerfire.com.overwatch.view.ui.allcharacters.HomeFragment

class MainActivity : AppCompatActivity() {

    /** Classe da activity principal responsável por hospedar os fragments */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
    }
}