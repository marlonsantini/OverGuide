package fingerfire.com.overwatch.extensions

import android.app.Activity
import android.app.AlertDialog
import androidx.annotation.StringRes


fun Activity.showDialogOverwatch(@StringRes msg: Int) {
    val dialog = AlertDialog.Builder(this)
        .setTitle("Overwatch")
        .setMessage(msg)
        .setPositiveButton("OK") { _, _ ->
            finish()
        }
        .create()
    dialog.show()
}